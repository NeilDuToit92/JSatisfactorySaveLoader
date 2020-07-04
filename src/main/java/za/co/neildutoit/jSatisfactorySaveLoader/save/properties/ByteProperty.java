package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IBytePropertyValue;

import java.io.IOException;

public class ByteProperty extends SerializedProperty implements IBytePropertyValue {
  public static final String TYPE_NAME = "ByteProperty";
//private static readonly Logger log = LogManager.GetCurrentClassLogger();

//public const String TypeName = nameof(ByteProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(object);
//public override object BackingObject => null;

//public override int SerializedLength => EnumType == "None" ? 1 : EnumValue.GetSerializedLength();
  /**
   * String used to store the enum type when an enum is forced to be saved as a byte (??). "None" if not an enum
   */
  private String enumType;

  /**
   * String representation of the enum value. Only valid when <see cref="EnumType"/> is not "None"
   */
  private String enumValue;

  /**
   * Byte value. Only valid when <see cref="EnumType"/> is "None"
   */
  private byte byteValue;

  /**
   * Indicates if this ByteProperty is holding a <see cref="EnumAsByte{T}"/>
   */
  private boolean isEnum = false;

  public ByteProperty(String propertyName, int index) {
    super(propertyName, index);
  }

  @Override
  public String getEnumType() {
    return enumType;
  }

  @Override
  public void setEnumType(String enumType) {
    this.enumType = enumType;
    this.isEnum = enumType != null && !"None".equals(enumType);
  }

  @Override
  public String getEnumValue() {
    return enumValue;
  }

  @Override
  public void setEnumValue(String enumValue) {
    this.enumValue = enumValue;
  }

  @Override
  public byte getByteValue() {
    return byteValue;
  }

  @Override
  public void setByteValue(byte byteValue) {
    this.byteValue = byteValue;
  }

  public boolean isEnum() {
    return isEnum;
  }

  public void setIsEnum(boolean anEnum) {
    isEnum = anEnum;
  }

  //  public override String
//
//  ToString() {
//    if (IsEnum)
//      return $ "Byte {PropertyName}: {EnumType}::{EnumValue}";
//
//    return $ "Byte {PropertyName}: {ByteValue}";
//  }

  public static ByteProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException {
    ByteProperty result = new ByteProperty(propertyName, index);
    result.setEnumType(reader.readCharArray().trim());
    reader.assertNullByte();

    if (result.isEnum()) {
      result.setEnumValue(reader.readCharArray());
    } else {
      result.setByteValue(reader.readByte());
    }

    overhead.setValue(getSerializedLength(result.getEnumType()) + 1);

    return result;
  }

//  void Serialize(BinaryWriter writer) {
//    writer.WriteLengthPrefixedString(EnumType);
//    writer.Write((byte) 0);
//
//    if (IsEnum) {
//      writer.WriteLengthPrefixedString(EnumValue);
//    } else {
//      writer.Write(ByteValue);
//    }
//  }
//
//  public override
//
//  void AssignToProperty(IPropertyContainer saveObject, PropertyInfo info) {
//    if (IsEnum) {
//      if (!info.PropertyType.IsGenericType || info.PropertyType.GetGenericTypeDefinition() != typeof(EnumAsByte < >))
//      {
//        log.Error($"Attempted to assign {PropertyType} ({EnumType}) {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
//        saveObject.AddDynamicProperty(this);
//        return;
//      }
//
//      var enumType = info.PropertyType.GenericTypeArguments[0];
//      if (enumType.Name != EnumType) {
//        log.Error($"Attempted to assign {PropertyType} ({EnumType}) {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
//        saveObject.AddDynamicProperty(this);
//        return;
//      }
//
//      if (!Enum.TryParse(enumType, EnumValue, true, out object enumValue)) {
//        log.Error($"Failed to parse \"{EnumValue}\" as {enumType.Name}");
//        saveObject.AddDynamicProperty(this);
//        return;
//      }
//
//      var enumAsByteType = typeof(EnumAsByte < >).MakeGenericType(new[]{
//        enumType
//      });
//      var instance = Activator.CreateInstance(enumAsByteType, enumValue);
//      info.SetValue(saveObject, instance);
//      return;
//    }
//
//    if (info.PropertyType != typeof( byte))
//    {
//      log.Error($"Attempted to assign {PropertyType} {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
//      saveObject.AddDynamicProperty(this);
//      return;
//    }
//
//    info.SetValue(saveObject, ByteValue);
//  }
}
