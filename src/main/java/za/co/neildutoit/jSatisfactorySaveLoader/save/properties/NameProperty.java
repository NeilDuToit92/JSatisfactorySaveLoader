package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.INamePropertyValue;

import java.io.IOException;
import java.lang.reflect.Field;

public class NameProperty extends SerializedProperty implements INamePropertyValue {
  public static final String TYPE_NAME = "NameProperty";
//  public const String TypeName = nameof(NameProperty);
//  public override String PropertyType => TypeName;

  //  public override Type BackingType => typeof(String);
//  public override object BackingObject => Value;
  public Field backingObject = this.getClass().getDeclaredField("value");


//  public override int SerializedLength => Value.GetSerializedLength();

  protected String value;

  public NameProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

//  public override String ToString()
//{
//  return $"Name {PropertyName}: {Value}";
//}

  public static NameProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException, NoSuchFieldException {
    NameProperty result = new NameProperty(propertyName, index);

    reader.assertNullByte();
    result.setValue(reader.readCharArray());

    return result;
  }

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

//  public void Serialize(BinaryWriter writer)
//{
//  writer.Write((byte)0);
//  writer.WriteLengthPrefixedString(Value);
//}
}
