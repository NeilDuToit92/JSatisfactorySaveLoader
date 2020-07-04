package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IStrPropertyValue;

import java.io.IOException;

public class StrProperty extends SerializedProperty implements IStrPropertyValue {
  public static final String TYPE_NAME = "StrProperty";
//public const String TypeName = nameof(StrProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(String);
//public override object BackingObject => Value;

//public override int SerializedLength => Value.GetSerializedLength();

  private String value;


  public StrProperty(String propertyName, int index) {
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

//      public override String ToString()
//    {
//    return $"String {PropertyName}: {Value}";
//    }

  public static StrProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException {
    StrProperty result = new StrProperty(propertyName, index);

    reader.assertNullByte();
    result.setValue(reader.readCharArray());

    return result;
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.Write((byte)0);
//    writer.WriteLengthPrefixedString(Value);
//    }
}
