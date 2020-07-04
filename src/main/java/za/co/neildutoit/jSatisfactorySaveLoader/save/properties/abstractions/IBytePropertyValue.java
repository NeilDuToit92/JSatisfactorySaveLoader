package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions;

public interface IBytePropertyValue {
  String getEnumType();
  void setEnumType(String enumType);

  String getEnumValue();
  void setEnumValue(String enumValue);

  byte getByteValue();
  void setByteValue(byte value);

  boolean isEnum();
  void setIsEnum(boolean isEnum);
}
