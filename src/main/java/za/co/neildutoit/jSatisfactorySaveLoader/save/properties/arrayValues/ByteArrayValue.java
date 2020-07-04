package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IBytePropertyValue;

public class ByteArrayValue implements IBytePropertyValue, IArrayElement
{
//  public Type BackingType => typeof(byte);

  private String enumType;
  private String enumValue;

  private byte byteValue;

  private boolean isEnum = false;

  @Override
  public String getEnumType() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setEnumType(String enumType) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String getEnumValue() {
    throw new UnsupportedOperationException();
  }

  @Override
  public void setEnumValue(String enumValue) {
    throw new UnsupportedOperationException();
  }

  @Override
  public byte getByteValue() {
    return byteValue;
  }

  @Override
  public void setByteValue(byte byteValue) {
    this.byteValue = byteValue;
  }

  @Override
  public boolean isEnum() {
    return isEnum;
  }

  public void setIsEnum(boolean anEnum) {
    isEnum = anEnum;
  }

  //  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
