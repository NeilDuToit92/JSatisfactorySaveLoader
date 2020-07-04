package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IEnumPropertyValue;

import java.io.IOException;

public class EnumProperty extends SerializedProperty implements IEnumPropertyValue {
  public static final String TYPE_NAME = "EnumProperty";
//private static readonly Logger log = LogManager.GetCurrentClassLogger();

//public const String TypeName = nameof(EnumProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(Enum);
//public override object BackingObject => Value;

//public override int SerializedLength => Value.GetSerializedLength();

  private String type;
  private String value;

  public EnumProperty(String propertyName, int index) {
    super(propertyName, index);
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

  //public override String ToString()
//    {
//    return $"Enum {PropertyName}: {Value}";
//    }

  public static EnumProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException {
    EnumProperty result = new EnumProperty(propertyName, index);
    result.setType(reader.readCharArray().trim());

    overhead.setValue(getSerializedLength(result.getType()) + 1);

    reader.assertNullByte();

    result.setValue(reader.readCharArray());

    return result;
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.WriteLengthPrefixedString(Type);
//    writer.Write((byte)0);
//    writer.WriteLengthPrefixedString(Value);
//    }
//
//public override void AssignToProperty(IPropertyContainer saveObject, PropertyInfo info)
//    {
//    if (Type != info.PropertyType.Name)
//    {
//    log.Error($"Attempted to assign enum {PropertyName} ({Type}) to mismatched property {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
//    saveObject.AddDynamicProperty(this);
//    return;
//    }
//
//    // TODO: should probably already be in BackingObject
//    if (!Enum.TryParse(info.PropertyType, Value.Split(':').Last(), true, out object enumValue))
//    {
//    log.Error($"Failed to parse \"{Value}\" as {info.PropertyType.Name}");
//    saveObject.AddDynamicProperty(this);
//    return;
//    }
//
//    info.SetValue(saveObject, enumValue);
//    }
}
