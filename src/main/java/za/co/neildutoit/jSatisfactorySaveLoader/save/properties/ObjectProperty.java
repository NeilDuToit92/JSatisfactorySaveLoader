package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IObjectPropertyValue;

import java.io.IOException;

public class ObjectProperty extends SerializedProperty implements IObjectPropertyValue {
  public static final String TYPE_NAME = "ObjectProperty";
//    public const String TypeName = nameof(ObjectProperty);
//    public override String PropertyType => TypeName;

//    public override Type BackingType => typeof(ObjectReference);
//    public override object BackingObject => Reference;

//    public override int SerializedLength => Reference.SerializedLength;

  private ObjectReference reference;

  public ObjectProperty(String propertyName, int index) {
    super(propertyName, index);
  }

  public ObjectReference getReference() {
    return reference;
  }

  public void setReference(ObjectReference reference) {
    this.reference = reference;
  }

  //    public override String ToString()
//        {
//        return $"Object {PropertyName}: {Reference}";
//        }

  public static ObjectProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException {
    ObjectProperty result = new ObjectProperty(propertyName, index);

    reader.assertNullByte();
    result.setReference(reader.readObjectReference());

    return result;
  }

//    public override void Serialize(BinaryWriter writer)
//        {
//        writer.Write((byte)0);
//        writer.Write(Reference);
//        }
}
