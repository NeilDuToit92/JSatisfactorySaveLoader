package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.save.EnumAsByte;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IBytePropertyValue;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.util.List;

public class ByteProperty extends SerializedProperty implements IBytePropertyValue {
  public static final String TYPE_NAME = "ByteProperty";
//private static readonly Logger log = LogManager.GetCurrentClassLogger();

//public const String TypeName = nameof(ByteProperty);
//public override String PropertyType => TypeName;

  //public override Type BackingType => typeof(object);
//public override object BackingObject => null;
  private Field backingObject = null;

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

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  public void setBackingObject(Field backingObject) {
    this.backingObject = backingObject;
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
  public void assignToProperty(IPropertyContainer saveObject, Field field) throws InvocationTargetException, IllegalAccessException {
    if (isEnum()) {

      boolean isEnumAsByte = false;
      for(Class<?> interfaceClass : field.getType().getInterfaces())
      {
        if (interfaceClass == EnumAsByte.class)
        {
          isEnumAsByte = true;
          break;
        }
      }

      //From a generic class you get a nonempty array of TypeVariable
      //From a non-generic class you get an empty array.
      if (field.getType().getTypeParameters().length == 0 && !isEnumAsByte)
      {
        System.out.println("Attempted to assign " + getPropertyType() + " (" + getEnumType() + ") " + getPropertyName() +
            " to incompatible backing field " + field.getType() + "." + field.getName() + " (" + field.getType().getTypeName() + ")");
        saveObject.addDynamicProperty(this);
        return;
      }

      String enumTypeName = null;
      if (field.getType().getTypeParameters().length > 0)
      {
        enumTypeName = field.getType().getTypeParameters()[0].getTypeName();
      }
      if (enumTypeName == null)
      {
        enumTypeName = field.getType().getSimpleName();
      }
      if (!enumTypeName.equals(getEnumType())) {
        System.out.println("Attempted to assign {PropertyType} ({EnumType}) {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
        saveObject.addDynamicProperty(this);
        return;
      }

      Enum enumValue = null;
      try {
        //TODO: @Ndt - There has to be a way to make this better
        enumValue = Enum.valueOf((Class<Enum>) field.getType(), getEnumValue());
      } catch (IllegalArgumentException iae) {
        System.out.println("Failed to parse " + getEnumValue() + " as " + enumTypeName);
        saveObject.addDynamicProperty(this);
        return;
      }

      setFieldValue(saveObject, field, enumValue);
      return;
    }

    if (field.getType() != Byte.class && field.getType() != byte.class)
    {
      System.out.println("Attempted to assign " + getPropertyType() + " " + getPropertyName() + " to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
      saveObject.addDynamicProperty(this);
      return;
    }

    setFieldValue(saveObject, field, getByteValue());
//    System.out.println("ByteProperty.assignToProperty has not been implemented yet");
//    throw new NotImplementedException();
  }
}
