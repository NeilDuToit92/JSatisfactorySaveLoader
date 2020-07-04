package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IStrPropertyValue;

public class StrArrayValue implements IStrPropertyValue, IArrayElement {
//  public Type BackingType => typeof(String);

  private String value;

  @Override
  public String getValue() {
    return value;
  }

  @Override
  public void setValue(String value) {
    this.value = value;
  }

//  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}

