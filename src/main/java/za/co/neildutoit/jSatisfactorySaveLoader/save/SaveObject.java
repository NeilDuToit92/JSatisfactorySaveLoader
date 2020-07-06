package za.co.neildutoit.jSatisfactorySaveLoader.save;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.SerializedProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class SaveObject implements IPropertyContainer {
  //TODO  private static readonly Logger log = LogManager.GetCurrentClassLogger();
  private static List<String> missingDeserializers = new ArrayList<>();
  private static List<String> missingSerializers = new ArrayList<>();

  private List<SerializedProperty> dynamicProperties = null;


  /**
   * Type of save object
   */
  protected SaveObjectKind objectKind;

  /**
   * Forward slash separated path of the script/prefab of this object
   * Can be an empty String
   */

  private String typePath;

  ///     Reference to the instance of the object

  private ObjectReference instance;

  public String getTypePath() {
    return typePath;
  }

  public SaveObjectKind getObjectKind() {
    return objectKind;
  }

  ///     Fallback list of properties that had no matching class property

//  private List<SerializedProperty> dynamicProperties = new ArrayList<>();
//
//  AsReadOnly();
//
//
//  ///     Fallback array of native bytes that are only used for certain objects when serialization logic is missing, ideally always empty
//
  public byte[] nativeData;
//
//  {
//    get;
//    set;
//  } =null;
//
//  public override String
//
//  ToString() {
//    return TypePath;
//  }
//
  public void addDynamicProperty(SerializedProperty prop) {
    if (dynamicProperties == null) {
      dynamicProperties = new ArrayList<>();
    }
    dynamicProperties.add(prop);
  }

//
//  ///     Default implementation to allow saves to at least load when missing logic for proper deserialization of native data.
//
//  /// <param name="reader"></param>
//  /// <param name="length"></param>
//  public virtual
//
  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    if (!missingDeserializers.contains(typePath)) {
//      log.Warn($"Missing native deserializer for {ObjectKind} {TypePath} ({length} bytes)");
      System.out.println("Missing native deserializer for " + typePath);
      missingDeserializers.add(typePath);
    }

    this.nativeData = reader.readBytes(length);
  }
//
//
//  ///     Default implementation to allow saves to at least save when missing logic for proper serialization of native data.
//
//  /// <param name="reader"></param>
//  public virtual
//
//  void SerializeNativeData(BinaryWriter writer) {
//    if (NativeData != null) {
//      if (!missingSerializers.Contains(TypePath)) {
//        log.Warn($"Missing native serializer for {ObjectKind} {TypePath} ({NativeData.Length} bytes)");
//        missingSerializers.add(TypePath);
//      }
//
//      writer.Write(NativeData);
//    }
//  }


  public ObjectReference getInstance() {
    return instance;
  }

  public void setInstance(ObjectReference instance) {
    this.instance = instance;
  }

  public byte[] getNativeData() {
    return nativeData;
  }

  public void setNativeData(byte[] nativeData) {
    this.nativeData = nativeData;
  }
}
