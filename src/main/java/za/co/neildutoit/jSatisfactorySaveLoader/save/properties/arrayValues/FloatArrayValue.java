package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IFloatPropertyValue;

public class FloatArrayValue implements IFloatPropertyValue, IArrayElement
{
//  public Type BackingType => typeof(float);

  public float value;

  @Override
  public float getValue() {
    return value;
  }

  @Override
  public void setValue(float value) {
    this.value = value;
  }

//  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
