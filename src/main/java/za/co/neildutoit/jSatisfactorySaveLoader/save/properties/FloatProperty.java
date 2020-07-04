package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IFloatPropertyValue;

import java.io.IOException;

public class FloatProperty extends SerializedProperty implements IFloatPropertyValue {
  public static final String TYPE_NAME = "FloatProperty";
//public const String TypeName = nameof(FloatProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(float);
//public override object BackingObject => Value;

//public override int SerializedLength => 4;

  private float value;

  @Override
  public float getValue() {
    return value;
  }

  @Override
  public void setValue(float value) {
    this.value = value;
  }

  public FloatProperty(String propertyName, int index) {
    super(propertyName, index);
  }

//public override String ToString()
//    {
//    return $"Float {PropertyName}: {Value}";
//    }

  public static FloatProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException {
    FloatProperty result = new FloatProperty(propertyName, index);

    reader.assertNullByte();

    result.setValue(reader.readSingle());
    return result;
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.Write((byte)0);
//    writer.Write(Value);
//    }
}
