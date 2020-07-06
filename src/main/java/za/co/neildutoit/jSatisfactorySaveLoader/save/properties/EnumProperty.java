package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IEnumPropertyValue;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.io.IOException;
import java.lang.reflect.Field;

public class EnumProperty extends SerializedProperty implements IEnumPropertyValue {
  public static final String TYPE_NAME = "EnumProperty";
//private static readonly Logger log = LogManager.GetCurrentClassLogger();

//public const String TypeName = nameof(EnumProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(Enum);
//public override object BackingObject => Value;
private Field backingObject = this.getClass().getDeclaredField("value");

//public override int SerializedLength => Value.GetSerializedLength();

  private String type;
  private String value;

  public EnumProperty(String propertyName, int index) throws NoSuchFieldException {
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

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  public void setBackingObject(Field backingObject) {
    this.backingObject = backingObject;
  }

  //public override String ToString()
//    {
//    return $"Enum {PropertyName}: {Value}";
//    }

  public static EnumProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException, NoSuchFieldException {
    EnumProperty result = new EnumProperty(propertyName, index);
    result.setType(reader.readCharArray().trim());

    overhead.setValue(getSerializedLength(result.getType()) + 1);

    reader.assertNullByte();

    result.setValue(reader.readCharArray());

    return result;
  }

//public void Serialize(BinaryWriter writer)
//    {
//    writer.WriteLengthPrefixedString(Type);
//    writer.Write((byte)0);
//    writer.WriteLengthPrefixedString(Value);
//    }
//
public void assignToProperty(IPropertyContainer saveObject, Field field) {
  throw new NotImplementedException();
}
//public void AssignToProperty(IPropertyContainer saveObject, PropertyInfo info)
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
