package za.co.neildutoit.jSatisfactorySaveLoader.save.serialization;

import org.apache.commons.lang3.mutable.MutableInt;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.ESessionVisibility;
import za.co.neildutoit.jSatisfactorySaveLoader.save.*;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.*;

import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * Based on https://github.com/Goz3rr/SatisfactorySaveEditor/tree/newer_parser commit 4e7ae94
 */
public class SatisfactorySaveSerializer {
  private final static Logger LOGGER = Logger.getLogger(SatisfactorySaveSerializer.class.getName());

  private final SaveObjectFactory saveObjectFactory = new SaveObjectFactory();

  private static List<String> missingProperties = new ArrayList<>();

  //  public Event EventHandler<StageChangedEventArgs> deserializationStageChanged;
//
  private void incrementDeserializationStage(SerializerStage stage) {
    //TODO
//    DeserializationStageChanged?.Invoke(this, new StageChangedEventArgs()
//  {
//    Stage = stage,
//    Current = currentDeserializationStage++,
//    Total = 7
//  });
  }

  private void updateDeserializationProgress(long current, long total) {
    //TODO
//    var progress = (float)current / total * 100;
//    DeserializationStageProgressed?.Invoke(this, new StageProgressedEventArgs()
//  {
//    Current = current,
//    Total = total,
//    Progress = progress
//  });
  }

  public FGSaveSession deserialize(File file) throws IOException, DataFormatException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, IntrospectionException, NoSuchFieldException {
    int currentDeserializationStage = 0;
    incrementDeserializationStage(SerializerStage.FileOpen);
    updateDeserializationProgress(0, -1);

//    var sw = Stopwatch.StartNew();
    FileInputStream stream = new FileInputStream(file);
    BinaryReader reader = new BinaryReader(stream);

    incrementDeserializationStage(SerializerStage.ParseHeader);
    updateDeserializationProgress(0, -1);
    FGSaveSession save = new FGSaveSession(deserializeHeader(reader));

    LOGGER.log(Level.INFO, "Save is " + (save.getHeader().isCompressed() ? "compressed" : "not compressed"));
    if (!save.getHeader().isCompressed()) {
      deserializeSaveData(save, reader);
    } else {
      incrementDeserializationStage(SerializerStage.Decompressing);

      long uncompressedSize = 0L;

//      var minimumProgressUpdate = stream.Length / PROGRESSION_REPORT_MODIFIER;
//      long lastProgressUpdate = 0L;
//      updateDeserializationProgress(0, stream.Length);
      byte[] decompressedFull = new byte[0];

      while (true) {
        FCompressedChunkHeader chunkHeader = reader.readCompressedChunkHeader();
//        Trace.Assert(chunkHeader.PackageTag == FCompressedChunkHeader.Magic);

        FCompressedChunkInfo chunkInfo = reader.readCompressedChunkInfo();
//        Trace.Assert(chunkHeader.UncompressedSize == chunkInfo.UncompressedSize);

        if (chunkInfo.getCompressedSize() == 0) {
          break;
        }

        byte[] compressed = reader.readBytes((int) chunkInfo.getCompressedSize());
        byte[] decompressed = decompress(compressed);
        int startPosition = reader.getPosition();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(decompressedFull);
        outputStream.write(decompressed);
        decompressedFull = outputStream.toByteArray();

        reader.setPosition(startPosition + (int) chunkInfo.getCompressedSize());


//        if (reader.getPosition() - lastProgressUpdate > minimumProgressUpdate) {
//          updateDeserializationProgress(stream.Position, stream.Length);
//          lastProgressUpdate = stream.Position;
//        }

        uncompressedSize += chunkInfo.getUncompressedSize();
      }

//      try (FileOutputStream fos = new FileOutputStream("uncompessedData")) {
//        fos.write(decompressedFull);//18481152
//        //fos.close(); There is no more need for this line since you had created the instance of "fos" inside the try. And this will automatically close the OutputStream
//      }

      BinaryReader uncompressedReader = new BinaryReader(new ByteArrayInputStream(decompressedFull));
      uncompressedReader.setPosition(0);
      int dataLength = uncompressedReader.readInt32();
//        Trace.Assert(uncompressedSize == dataLength + 4);

      deserializeSaveData(save, uncompressedReader);
    }

//    sw.Stop();
    incrementDeserializationStage(SerializerStage.Done);
    updateDeserializationProgress(0, -1);
//    log.Info($"Parsing save took {sw.ElapsedMilliseconds / 1000f}s");

    return save;
  }

  public byte[] decompress(byte[] data) throws IOException, DataFormatException {
    Inflater inflater = new Inflater();
    inflater.setInput(data);
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
    byte[] buffer = new byte[1024];
    while (!inflater.finished()) {
      int count = inflater.inflate(buffer);
      outputStream.write(buffer, 0, count);
    }
    outputStream.close();
    byte[] output = outputStream.toByteArray();
    return output;
  }

  public static FSaveHeader deserializeHeader(BinaryReader reader) throws IOException {
    FSaveHeaderVersion headerVersion = FSaveHeaderVersion.values()[reader.readInt32()];
    FSaveCustomVersion saveVersion = FSaveCustomVersion.values()[reader.readInt32()];

    if (headerVersion.ordinal() > FSaveHeaderVersion.LatestVersion.ordinal()) {
      //TODO throw new UnsupportedHeaderVersionException(headerVersion);
    }

    if (saveVersion.ordinal() > FSaveCustomVersion.LatestVersion.ordinal()) {
      //TODO throw new UnsupportedSaveVersionException(saveVersion);
    }

    int buildVersion = reader.readInt32();
    String mapName = reader.readCharArray();
    String mapOptions = reader.readCharArray();
    String sessionName = reader.readCharArray();
    int playDuration = reader.readInt32();
    long saveDateTime = reader.readInt64();

    FSaveHeader header = new FSaveHeader(headerVersion, saveVersion, buildVersion, mapName, mapOptions, sessionName, playDuration, saveDateTime);

    String logStr =
        "Read save header: HeaderVersion=" + header.getHeaderVersion() +
            ", SaveVersion=" + header.getSaveVersion() +
            ", BuildVersion=" + header.getBuildVersion() +
            ", MapName=" + header.getMapName() +
            ", MapOpts=" + header.getMapOptions() +
            ", SessionName=" + header.getSessionName() +
            ", PlayTime=" + header.getPlayDuration() +
            ", SaveTime=" + header.getSaveDateTime();

    if (header.supportsSessionVisibility()) {
      header.setSessionVisibility(ESessionVisibility.getByNumber(reader.readByte()));
      logStr += ", Visibility=" + header.getSessionVisibility();
    }

    LOGGER.log(Level.INFO, logStr);

    return header;
  }

  private void deserializeSaveData(FGSaveSession save, BinaryReader reader) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, IntrospectionException, NoSuchFieldException {
    incrementDeserializationStage(SerializerStage.ReadObjects);

    // Does not need to be a public property because it's equal to Objects.Count
    long totalSaveObjects = reader.readUInt32();
    LOGGER.log(Level.INFO, "Save contains " + totalSaveObjects + " object headers");

    updateDeserializationProgress(0, totalSaveObjects);
    int PROGRESSION_REPORT_MODIFIER = 20;
    long minimumProgressUpdate = totalSaveObjects / PROGRESSION_REPORT_MODIFIER;
    long lastProgressUpdate = 0L;

    for (int i = 0; i < totalSaveObjects; i++) {
      save.getObjects().add(deserializeObjectHeader(reader));

      if (i - lastProgressUpdate > minimumProgressUpdate) {
        updateDeserializationProgress(i, totalSaveObjects);
        lastProgressUpdate = i;
      }
    }

    incrementDeserializationStage(SerializerStage.ReadObjectData);
    long totalSaveObjectData = reader.readUInt32();
// TODO   log.Info("Save contains {totalSaveObjectData} object data");

    updateDeserializationProgress(0, totalSaveObjectData);
    minimumProgressUpdate = totalSaveObjectData / PROGRESSION_REPORT_MODIFIER;
    lastProgressUpdate = 0L;

//    Trace.Assert(save.Objects.Count == totalSaveObjects);
//    Trace.Assert(save.Objects.Count == totalSaveObjectData);
//    assert 2 < 10;

    for (int i = 0; i < save.getObjects().size(); i++) {
      deserializeObjectData(save.getObjects().get(i), reader);

      if (i - lastProgressUpdate > minimumProgressUpdate) {
        updateDeserializationProgress(i, totalSaveObjectData);
        lastProgressUpdate = i;
      }
    }

    incrementDeserializationStage(SerializerStage.ReadDestroyedObjects);
    updateDeserializationProgress(0, -1);
    save.getDestroyedActors().addAll(deserializeDestroyedActors(reader));

//    log.Debug($"Read {reader.BaseStream.Position} of total {reader.BaseStream.Length} bytes");
//    Trace.Assert(reader.BaseStream.Position == reader.BaseStream.Length);
  }

  public SaveObject deserializeObjectHeader(BinaryReader reader) throws IOException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
    SaveObjectKind kind = SaveObjectKind.values()[reader.readInt32()];
    String className = reader.readCharArray().intern();

    SaveObject saveObject = saveObjectFactory.createFromClass(kind, className);
    saveObject.setInstance(reader.readObjectReference());

    switch (saveObject.getObjectKind()) {
      case Actor:
        SaveActor saveActor = (SaveActor) saveObject;
        saveActor.setNeedTransform(reader.readInt32() == 1);
        saveActor.setRotation(reader.readVector4());
        saveActor.setPosition(reader.readVector3());
        saveActor.setScale(reader.readVector3());

        if (saveActor.getScale().isSuspicious()) {
//TODO          log.Warn($"Actor {actor} has suspicious scale {actor.Scale}");
        }
        saveActor.setWasPlacedInLevel(reader.readInt32() == 1);
        break;

      case Component:
        SaveComponent saveComponent = (SaveComponent) saveObject;
        saveComponent.setParentEntityName(reader.readCharArray());
        break;

      default:
//        TODO: throw new NotImplementedException($"Unknown SaveObject kind {kind}");
    }

    return saveObject;
  }

  public static void deserializeObjectData(SaveObject saveObject, BinaryReader reader) throws IOException, InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException, NoSuchFieldException {
    int dataLength = reader.readInt32();
    int before = reader.getPosition();

    switch (saveObject.getObjectKind()) {
      case Actor:
        SaveActor actor = new SaveActor();
        actor.setParentObject(reader.readObjectReference());
        int componentCount = reader.readInt32();
        for (int i = 0; i < componentCount; i++) {
          actor.getComponents().add(reader.readObjectReference());
        }

        break;

      case Component:
        break;

      default:
//        throw new UnsupportedEncodingException("Unknown SaveObject kind" + saveObject.getObjectKind());
    }

    int pos = reader.getPosition();
    SerializedProperty prop;
    while ((prop = deserializeProperty(reader)) != null) {
      pos = reader.getPosition();
      String a = "";

//      prop.getMatchingSaveProperty(saveObject.getClass().getTypeName());
//      prop.getMatchingStructProperty(saveObject.getClass().getTypeName());

      Field field = prop.getMatchingSaveProperty(saveObject.getClass());
//      var(objProperty, _) = prop.GetMatchingSaveProperty(saveObject.GetType());

      if (field == null) {
//        String type = saveObject.getClass().getTypeName();
////

        String propType = "";
        if (prop.getBackingObject() != null) {
          propType = prop.getBackingObject().getType().getTypeName();
        }
        if (prop instanceof StructProperty) {
          propType += ((StructProperty) prop).getData().getClass().getTypeName();
        }

        //TODO:
        String propertyUniqueName = saveObject.getClass().getTypeName() + "." + prop.getPropertyName() + ":" + propType;
        if (!missingProperties.contains(propertyUniqueName)) {
////TODO          if (type == typeof(SaveActor) || type == typeof(SaveComponent))
////            log.Warn($"Missing property for {propType} {prop.PropertyName} on {saveObject.TypePath}");
////          else
////            log.Warn($"Missing property for {propType} {prop.PropertyName} on {type.Name}");

          missingProperties.add(propertyUniqueName);
        }

        saveObject.addDynamicProperty(prop);
        continue;
      }

      prop.assignToProperty(saveObject, field);
    }

    pos = reader.getPosition();
    int extra = reader.readInt32();
//TODO    if (extra != 0)
//      log.Warn($"Read extra {extra} after {saveObject.TypePath} @ {reader.BaseStream.Position - 4}");

    int remaining = dataLength - (reader.getPosition() - before);
    if (remaining > 0) {
      saveObject.deserializeNativeData(reader, remaining);
    }

    long after = reader.getPosition();
//TODO:    if (before + dataLength != after)
//      throw new FatalSaveException($"Expected {dataLength} bytes read but got {after - before}", before);
  }

  public static SerializedProperty deserializeProperty(BinaryReader reader) throws IOException, IllegalAccessException, InstantiationException, NoSuchFieldException {
    SerializedProperty result;

    String propertyName = reader.readCharArray();
    if (propertyName.trim().equals("None")) {
      return null;
    }

//    TODO: Trace.Assert(!String.IsNullOrEmpty(propertyName));

    String propertyType = reader.readCharArray().trim();
    int size = reader.readInt32();
    int index = reader.readInt32();

    MutableInt overhead = new MutableInt(1);
    long before = reader.getPosition();
    switch (propertyType) {
      case ArrayProperty.TYPE_NAME:
        result = ArrayProperty.parse(reader, propertyName, index, overhead);
        break;
      case BoolProperty.TYPE_NAME:
        result = BoolProperty.deserialize(reader, propertyName, index, overhead);
        break;
      case ByteProperty.TYPE_NAME:
        result = ByteProperty.deserialize(reader, propertyName, index, overhead);
        break;
      case EnumProperty.TYPE_NAME:
        result = EnumProperty.deserialize(reader, propertyName, index, overhead);
        break;
      case FloatProperty.TYPE_NAME:
        result = FloatProperty.deserialize(reader, propertyName, index);
        break;
      case IntProperty.TYPE_NAME:
        result = IntProperty.deserialize(reader, propertyName, index);
        break;
      case Int64Property.TYPE_NAME:
        result = Int64Property.deserialize(reader, propertyName, index);
        break;
      case InterfaceProperty.TYPE_NAME:
        result = InterfaceProperty.deserialize(reader, propertyName, index);
        break;
      case MapProperty.TYPE_NAME:
        result = MapProperty.deserialize(reader, propertyName, index, overhead);
        break;
      case NameProperty.TYPE_NAME:
        result = NameProperty.deserialize(reader, propertyName, index);
        break;
      case ObjectProperty.TYPE_NAME:
        result = ObjectProperty.deserialize(reader, propertyName, index);
        break;
//      case SetProperty.TYPE_NAME:
//        result = SetProperty.parse(reader, propertyName, index, overhead);
//        break;
      case StrProperty.TYPE_NAME:
        result = StrProperty.deserialize(reader, propertyName, index);
        break;
      case StructProperty.TYPE_NAME:
        result = StructProperty.deserialize(reader, propertyName, size, index, overhead);
        break;
      case TextProperty.TYPE_NAME:
        result = TextProperty.deserialize(reader, propertyName, index);
        break;
      default:
        System.out.println("Not implemented: " + propertyType);
        throw new NotImplementedException();
////TODO:        throw new NotImplementedException("Unknown property type {propertyType} for property {propertyName}");
    }
    //TODO: var after = reader.BaseStream.Position;
    long after = reader.getPosition();
    long readBytes = (int) (after - before - overhead.getValue());

    if (size != readBytes) {

      //TODO: Use logger
      System.out.println("Expected " + size + " bytes read but got " + readBytes);
    }
//      throw new InvalidOperationException($"Expected {size} bytes read but got {readBytes}");

    return result;
//    return null;
  }

  public List<ObjectReference> deserializeDestroyedActors(BinaryReader reader) throws IOException {
    int destroyedActorsCount = reader.readInt32();
//    log.Info($"Save contains {destroyedActorsCount} destroyed actors");

    List<ObjectReference> list = new ArrayList<>();

    for (int i = 0; i < destroyedActorsCount; i++) {
      list.add(reader.readObjectReference());
    }

    return list;
  }


}
