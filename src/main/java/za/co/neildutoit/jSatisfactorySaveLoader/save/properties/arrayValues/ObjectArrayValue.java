package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IObjectPropertyValue;

public class ObjectArrayValue implements IObjectPropertyValue, IArrayElement
{
//  public Type BackingType => typeof(ObjectReference);

  private ObjectReference reference;

  @Override
  public ObjectReference getReference() {
    return reference;
  }

  @Override
  public void setReference(ObjectReference reference) {
    this.reference = reference;
  }

  //  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
