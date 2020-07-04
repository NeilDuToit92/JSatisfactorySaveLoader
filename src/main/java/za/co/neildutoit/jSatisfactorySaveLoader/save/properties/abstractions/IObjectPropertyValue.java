package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public interface IObjectPropertyValue {
  ObjectReference getReference();
  void setReference(ObjectReference objectReference);
}
