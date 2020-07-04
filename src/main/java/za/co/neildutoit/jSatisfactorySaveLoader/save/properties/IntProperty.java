package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IIntPropertyValue;

import java.io.IOException;
import java.lang.reflect.Field;

public class IntProperty extends SerializedProperty implements IIntPropertyValue {
  public static final String TYPE_NAME = "IntProperty";
//  public const String TypeName = nameof(IntProperty);
//  public override String PropertyType => TypeName;

  //  public override Type BackingType => typeof(int);
//  public override object BackingObject => Value;
  private Field backingObject = this.getClass().getDeclaredField("value");

//  public override int SerializedLength => 4;

  public IntProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  public int value;

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  //  public override String ToString()
//  {
//    return $"Int {PropertyName}: {Value}";
//  }

  public static IntProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException, NoSuchFieldException {
    IntProperty result = new IntProperty(propertyName, index);

    reader.assertNullByte();
    result.setValue(reader.readInt32());

    return result;
  }

//  public override void Serialize(BinaryWriter writer)
//  {
//    writer.Write((byte)0);
//    writer.Write(Value);
//  }
}
