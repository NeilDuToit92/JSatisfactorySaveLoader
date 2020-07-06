package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.DynamicGameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues.*;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MapProperty extends SerializedProperty {
  public static final String TYPE_NAME = "MapProperty";
//public const String TypeName = nameof(MapProperty);
//public override String PropertyType => TypeName;

  //public override Type BackingType => typeof(Dictionary<,>);
//public override object BackingObject => Elements;
  private Field backingObject = this.getClass().getDeclaredField("elements");
//public override int SerializedLength => 0;

  private String keyType;
  private String valueType;
  private Map<IArrayElement, IArrayElement> elements = new HashMap<>();

  public MapProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  public String getKeyType() {
    return keyType;
  }

  public void setKeyType(String keyType) {
    this.keyType = keyType;
  }

  public String getValueType() {
    return valueType;
  }

  public void setValueType(String valueType) {
    this.valueType = valueType;
  }

  public Map<IArrayElement, IArrayElement> getElements() {
    return elements;
  }

  public void setElements(Map<IArrayElement, IArrayElement> elements) {
    this.elements = elements;
  }

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  //public override String ToString()
//    {
//    return $"Map<{KeyType},{ValueType}> {PropertyName}";
//    }

  public static MapProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException, IntrospectionException, InvocationTargetException {
    MapProperty result = new MapProperty(propertyName, index);

    result.setKeyType(reader.readCharArray().trim());
    result.setValueType(reader.readCharArray().trim());

    overhead.setValue(getSerializedLength(result.getKeyType()) + getSerializedLength(result.getValueType()) + 1);

//    var keyType = GetPropertyValueTypeFromName(result.KeyType);
//    var valueType = GetPropertyValueTypeFromName(result.ValueType);
//    result.Elements = (IDictionary)Activator.CreateInstance(typeof(Dictionary<,>).MakeGenericType(keyType, valueType));

    reader.assertNullByte();
    reader.assertNullInt32();

    int posA = reader.getPosition();
    int posB = reader.getPosition();

    int count = reader.readInt32();
    for (int i = 0; i < count; i++) {
      IArrayElement key, value;

      switch (result.getKeyType()) {
        case IntProperty.TYPE_NAME: {
          IntArrayValue intArrayValue = new IntArrayValue();
          intArrayValue.setValue(reader.readInt32());
          key = intArrayValue;
        }
        break;
        case ObjectProperty.TYPE_NAME: {
          ObjectArrayValue objectArrayValue = new ObjectArrayValue();
          objectArrayValue.setReference(reader.readObjectReference());
          key = objectArrayValue;
        }
        break;
        case StrProperty.TYPE_NAME: {
          StrArrayValue strArrayValue = new StrArrayValue();
          strArrayValue.setValue(reader.readCharArray());
          key = strArrayValue;
        }
        break;
        default:
          System.out.println("Unimplemented Map KeyType: " + result.getKeyType());
          throw new NotImplementedException();
      }

      switch (result.getValueType()) {
        case ByteProperty.TYPE_NAME: {
          ByteArrayValue byteArrayValue = new ByteArrayValue();
          byteArrayValue.setByteValue(reader.readByte());
          value = byteArrayValue;
        }
        break;
        case StructProperty.TYPE_NAME: {
          GameStruct gameStruct = new DynamicGameStruct(null);
          gameStruct.deserialize(reader);
          StructArrayValue structArrayValue = new StructArrayValue();
          structArrayValue.setData(gameStruct);
          value = structArrayValue;
        }
        break;
        default:
          System.out.println("Unimplemented Map ValueType: " + result.getValueType());
          throw new NotImplementedException();
      }

      result.getElements().put(key, value);
    }

    return result;
  }

//public void Serialize(BinaryWriter writer)
//    {
//    throw new NotImplementedException();
//    }

  public void assignToProperty(IPropertyContainer saveObject, Field field) {
    // TODO: add assigning of maps
    saveObject.addDynamicProperty(this);
  }
}
