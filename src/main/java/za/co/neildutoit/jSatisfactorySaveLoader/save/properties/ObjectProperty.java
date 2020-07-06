package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IObjectPropertyValue;

import java.io.IOException;
import java.lang.reflect.Field;

public class ObjectProperty extends SerializedProperty implements IObjectPropertyValue {
  public static final String TYPE_NAME = "ObjectProperty";
//    public const String TypeName = nameof(ObjectProperty);
//    public override String PropertyType => TypeName;

  //    public override Type BackingType => typeof(ObjectReference);
//    public override object BackingObject => Reference;
  private Field backingObject = this.getClass().getDeclaredField("reference");

//    public override int SerializedLength => Reference.SerializedLength;

  private ObjectReference reference;

  public ObjectProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  public ObjectReference getReference() {
    return reference;
  }

  public void setReference(ObjectReference reference) {
    this.reference = reference;
  }

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  //    public override String ToString()
//        {
//        return $"Object {PropertyName}: {Reference}";
//        }

  public static ObjectProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException, NoSuchFieldException {
    ObjectProperty result = new ObjectProperty(propertyName, index);

    reader.assertNullByte();
    result.setReference(reader.readObjectReference());

    return result;
  }

//    public void Serialize(BinaryWriter writer)
//        {
//        writer.Write((byte)0);
//        writer.Write(Reference);
//        }
}
