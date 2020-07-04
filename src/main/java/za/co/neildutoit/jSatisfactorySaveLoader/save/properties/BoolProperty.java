package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IBoolPropertyValue;

import java.io.IOException;

public class BoolProperty extends SerializedProperty implements IBoolPropertyValue {
  public static final String TYPE_NAME = "BoolProperty";

//public const String TypeName = nameof(BoolProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(bool);
//public override object BackingObject => Value;

//public override int SerializedLength => 0;

  private boolean value;

  public boolean isValue() {
    return value;
  }

  @Override
  public void setValue(boolean value) {
    this.value = value;
  }

  public BoolProperty(String propertyName, int index) {
    super(propertyName, index);
  }

//public override String ToString()
//    {
//    return $"Bool {PropertyName}: {Value}";
//    }

  public static BoolProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException {
    BoolProperty result = new BoolProperty(propertyName, index);
    result.setValue(reader.readByte() != 0);

    reader.assertNullByte();

    overhead.setValue(2);
    return result;
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.Write((byte)(Value ? 1 : 0));
//    writer.Write((byte)0);
//    }
}
