package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IInt64PropertyValue;

import java.io.IOException;

public class Int64Property extends SerializedProperty implements IInt64PropertyValue {
  public static final String TYPE_NAME = "Int64Property";
//  public const String TypeName = nameof(Int64Property);
//  public override String PropertyType => TypeName;

//  public override Type BackingType => typeof(long);
//  public override object BackingObject => Value;

//  public override int SerializedLength => 8;

  private long value;

  public Int64Property(String propertyName, int index) {
    super(propertyName, index);
  }

  public long getValue() {
    return value;
  }

  public void setValue(long value) {
    this.value = value;
  }

//  public override String ToString()
//{
//  return $"Int64 {PropertyName}: {Value}";
//}

  public static Int64Property deserialize(BinaryReader reader, String propertyName, int index) throws IOException {
    Int64Property result = new Int64Property(propertyName, index);

    reader.assertNullByte();
    result.setValue(reader.readInt64());

    return result;
  }

//  public override
//
//  void Serialize(BinaryWriter writer) {
//    writer.Write((byte) 0);
//    writer.Write(Value);
//  }
}
