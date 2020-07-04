package za.co.neildutoit.jSatisfactorySaveLoader.save.serialization;

import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.SerializedProperty;

public interface IPropertyContainer {
  //  ReadOnlyCollection<SerializedProperty> DynamicProperties { get; }
//
  void addDynamicProperty(SerializedProperty prop);
}
