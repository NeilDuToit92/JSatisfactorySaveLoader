package za.co.neildutoit.jSatisfactorySaveLoader.save.serialization;

import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.ESessionVisibility;
import za.co.neildutoit.jSatisfactorySaveLoader.save.*;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.SerializedProperty;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
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

  public FGSaveSession deserialize(File file) throws IOException, DataFormatException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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

      while (reader.getPosition() < file.length()) {
        FCompressedChunkHeader chunkHeader = reader.readCompressedChunkHeader();
//        Trace.Assert(chunkHeader.PackageTag == FCompressedChunkHeader.Magic);

        FCompressedChunkInfo chunkInfo = reader.readCompressedChunkInfo();
//        Trace.Assert(chunkHeader.UncompressedSize == chunkInfo.UncompressedSize);

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

  private void deserializeSaveData(FGSaveSession save, BinaryReader reader) throws IOException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
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

    switch (saveObject.getObjectKind())
    {
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
//      component.ParentEntityName = reader.ReadLengthPrefixedString();
        break;

      default:
//        TODO: throw new NotImplementedException($"Unknown SaveObject kind {kind}");
    }

    return saveObject;
  }

  public static void deserializeObjectData(SaveObject saveObject, BinaryReader reader) throws IOException {
    int dataLength = reader.readInt32();
//TODO: int before = reader. BaseStream.Position;
    int before = reader.getPosition();

    switch (saveObject.getObjectKind()) {
      case Actor:
        SaveActor actor = new SaveActor();
//        actor.setParentObject(reader.readObjectReference());
        int componentCount = reader.readInt32();
        for (int i = 0; i < componentCount; i++) {
//          actor.getComponents().add(reader.readObjectReference());
        }

        break;

      case Component:
        break;

      default:
//        throw new UnsupportedEncodingException("Unknown SaveObject kind" + saveObject.getObjectKind());
    }

    SerializedProperty prop;
    while ((prop = deserializeProperty(reader)) != null) {
//      var(objProperty, _) = prop.GetMatchingSaveProperty(saveObject.GetType());

//      if (objProperty == null) {
//        var type = saveObject.GetType();
//
//        var propType = prop.PropertyType;
//        if (prop is StructProperty structProp)
//        propType += " ({structProp.Data.GetType().Name})";
//
//        //TODO:
//        String propertyUniqueName = $ "{saveObject.TypePath}.{prop.PropertyName}:{propType}";
//        if (!missingProperties.Contains(propertyUniqueName)) {
////TODO          if (type == typeof(SaveActor) || type == typeof(SaveComponent))
////            log.Warn($"Missing property for {propType} {prop.PropertyName} on {saveObject.TypePath}");
////          else
////            log.Warn($"Missing property for {propType} {prop.PropertyName} on {type.Name}");
//
//          missingProperties.Add(propertyUniqueName);
//        }
//
//        saveObject.AddDynamicProperty(prop);
//        continue;
//      }
//
//      prop.AssignToProperty(saveObject, objProperty);
    }

    int extra = reader.readInt32();
//TODO    if (extra != 0)
//      log.Warn($"Read extra {extra} after {saveObject.TypePath} @ {reader.BaseStream.Position - 4}");

//TODO:    var remaining = dataLength - (int) (reader.BaseStream.Position - before);
    long remaining = dataLength - (int) (reader.getPosition() - before);
//    if (remaining > 0)
//      saveObject.deserializeNativeData(reader, remaining);

//TODO    var after = reader.BaseStream.Position;
    long after = reader.getPosition();
//TODO:    if (before + dataLength != after)
//      throw new FatalSaveException($"Expected {dataLength} bytes read but got {after - before}", before);
  }

  public static SerializedProperty deserializeProperty(BinaryReader reader) throws IOException {
    SerializedProperty result;

    String propertyName = reader.readCharArray();
    if (propertyName == "None")
      return null;

//    TODO: Trace.Assert(!String.IsNullOrEmpty(propertyName));

    String propertyType = reader.readCharArray();
    int size = reader.readInt32();
    int index = reader.readInt32();

    int overhead = 1;
    //TODO: var before = reader.BaseStream.Position;
    long before = reader.getPosition();
//    switch (propertyType) {
//      case ArrayProperty.TypeName:
//        result = ArrayProperty.Parse(reader, propertyName, index, out overhead);
//        break;
//      case BoolProperty.TypeName:
//        result = BoolProperty.Deserialize(reader, propertyName, index, out overhead);
//        break;
//      case ByteProperty.TypeName:
//        result = ByteProperty.Deserialize(reader, propertyName, index, out overhead);
//        break;
//      case EnumProperty.TypeName:
//        result = EnumProperty.Deserialize(reader, propertyName, index, out overhead);
//        break;
//      case FloatProperty.TypeName:
//        result = FloatProperty.Deserialize(reader, propertyName, index);
//        break;
//      case IntProperty.TypeName:
//        result = IntProperty.Deserialize(reader, propertyName, index);
//        break;
//      case Int64Property.TypeName:
//        result = Int64Property.Deserialize(reader, propertyName, index);
//        break;
//      case InterfaceProperty.TypeName:
//        result = InterfaceProperty.Deserialize(reader, propertyName, index);
//        break;
//      case MapProperty.TypeName:
//        result = MapProperty.Deserialize(reader, propertyName, index, out overhead);
//        break;
//      case NameProperty.TypeName:
//        result = NameProperty.Deserialize(reader, propertyName, index);
//        break;
//      case ObjectProperty.TypeName:
//        result = ObjectProperty.Deserialize(reader, propertyName, index);
//        break;
//      case SetProperty.TypeName:
//        result = SetProperty.Parse(reader, propertyName, index, out overhead);
//        break;
//      case StrProperty.TypeName:
//        result = StrProperty.Deserialize(reader, propertyName, index);
//        break;
//      case StructProperty.TypeName:
//        result = StructProperty.Deserialize(reader, propertyName, size, index, out overhead);
//        break;
//      case TextProperty.TypeName:
//        result = TextProperty.Deserialize(reader, propertyName, index);
//        break;
//      default:
//        throw new NotImplementedException();
////TODO:        throw new NotImplementedException("Unknown property type {propertyType} for property {propertyName}");
//    }
    //TODO: var after = reader.BaseStream.Position;
    long after = reader.getPosition();
    long readBytes = (int) (after - before - overhead);

//TODO:    if (size != readBytes)
//      throw new InvalidOperationException($"Expected {size} bytes read but got {readBytes}");

//    return result;
    return null;
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
