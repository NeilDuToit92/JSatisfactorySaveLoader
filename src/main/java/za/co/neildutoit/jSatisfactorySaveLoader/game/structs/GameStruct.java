package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.SerializedProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.Wrapper;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.SatisfactorySaveSerializer;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GameStruct implements IPropertyContainer {
//  private static readonly Logger log = LogManager.GetCurrentClassLogger();
//  private static readonly HashSet<String> missingProperties = new HashSet<String>();

  /**
   * Fallback list of properties that had no matching class property
   */
  private List<SerializedProperty> dynamicProperties = null;

//  public virtual int SerializedLength => 0;
//  public abstract String StructName { get; }
//
//
//  ///     Fallback list of properties that had no matching class property
//
//  public ReadOnlyCollection<SerializedProperty> DynamicProperties => dynamicProperties?.AsReadOnly();
//
  public void addDynamicProperty(SerializedProperty prop)
  {
    if (dynamicProperties == null) {
      dynamicProperties = new ArrayList<>();
    }
    dynamicProperties.add(prop);
  }

  public void deserialize(BinaryReader reader) throws IllegalAccessException, IOException, InstantiationException, NoSuchFieldException, IntrospectionException, InvocationTargetException {
    SerializedProperty prop;
    while ((prop = SatisfactorySaveSerializer.deserializeProperty(reader)) != null)
    {
      //TODO: @NDT - need to do mapping here
      Field field = prop.getMatchingStructProperty(this.getClass());

      if (field == null)
      {
        if (this.getClass() == DynamicGameStruct.class)
        {
//          var propertyUniqueName = $"{GetType().Name}.{prop.PropertyName}:{prop.PropertyType}";
//          if (!missingProperties.Contains(propertyUniqueName))
//          {
//            if (prop is StructProperty structProp)
//            log.Warn($"Missing property for {prop.PropertyType} ({structProp.Data.GetType().Name}) {prop.PropertyName} on struct {GetType().Name}");
//                            else
//            log.Warn($"Missing property for {prop.PropertyType} {prop.PropertyName} on struct {GetType().Name}");
//
//            missingProperties.add(propertyUniqueName);
//          }
        }

        addDynamicProperty(prop);
        continue;
      }
//
      prop.assignToProperty(this, field);
    }
  }
//
//  public virtual void Serialize(BinaryWriter writer)
//  {
//    throw new System.NotImplementedException();
//  }
}
