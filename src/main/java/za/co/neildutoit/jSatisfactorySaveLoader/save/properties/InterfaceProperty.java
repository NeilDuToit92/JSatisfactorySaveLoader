package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IInterfacePropertyValue;

import java.io.IOException;

public class InterfaceProperty extends SerializedProperty implements IInterfacePropertyValue {
  public static final String TYPE_NAME = "InterfaceProperty";
//public const String TypeName = nameof(InterfaceProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(ObjectReference);
//public override object BackingObject => Reference;

//public override int SerializedLength => Reference.SerializedLength;

  private ObjectReference reference;

  public InterfaceProperty(String propertyName, int index) {
    super(propertyName, index);
  }

  @Override
  public ObjectReference getReference() {
    return reference;
  }

  @Override
  public void setReference(ObjectReference reference) {
    this.reference = reference;
  }

  //public override String ToString()
//    {
//    return $"Interface {PropertyName}: {Reference}";
//    }

  public static InterfaceProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException {
    InterfaceProperty result = new InterfaceProperty(propertyName, index);

    reader.assertNullByte();
    result.setReference(reader.readObjectReference());

    return result;
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.Write((byte)0);
//    writer.Write(Reference);
//    }
}
