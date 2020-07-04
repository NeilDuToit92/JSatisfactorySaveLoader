package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IIntPropertyValue;

public class IntArrayValue implements IIntPropertyValue, IArrayElement {
//  public Type BackingType => typeof(int);

  private int value;

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public void setValue(int value) {
    this.value = value;
  }

//  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
