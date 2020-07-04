package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IInterfacePropertyValue;

public class InterfaceArrayValue implements IInterfacePropertyValue, IArrayElement
{
//  public Type BackingType => typeof(ObjectReference);

  public ObjectReference reference;

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
