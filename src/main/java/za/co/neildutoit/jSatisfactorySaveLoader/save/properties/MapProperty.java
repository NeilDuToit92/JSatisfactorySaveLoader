package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import org.apache.commons.lang3.mutable.MutableInt;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.DynamicGameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues.*;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapProperty extends SerializedProperty {
  public static final String TYPE_NAME = "MapProperty";
//public const String TypeName = nameof(MapProperty);
//public override String PropertyType => TypeName;

//public override Type BackingType => typeof(Dictionary<,>);
//public override object BackingObject => Elements;

//public override int SerializedLength => 0;

  private String keyType;
  private String valueType;
  private Map<IArrayElement, IArrayElement> elements = new HashMap<>();

  public MapProperty(String propertyName, int index) {
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

  //public override String ToString()
//    {
//    return $"Map<{KeyType},{ValueType}> {PropertyName}";
//    }

  public static MapProperty deserialize(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
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

      System.out.println(result.getKeyType());
      switch (result.getKeyType()) {
        case IntProperty.TYPE_NAME: {
          System.out.println("Before IntProperty " + reader.getPosition());
          IntArrayValue intArrayValue = new IntArrayValue();
          intArrayValue.setValue(reader.readInt32());
          key = intArrayValue;
          System.out.println("After IntProperty " + reader.getPosition());
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
          int p1 = reader.getPosition();
          GameStruct gameStruct = new DynamicGameStruct(null);
          gameStruct.deserialize(reader);
          StructArrayValue structArrayValue = new StructArrayValue();
          structArrayValue.setData(gameStruct);
          value = structArrayValue;
          p1 = reader.getPosition();
          p1 = reader.getPosition();

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

//public override void Serialize(BinaryWriter writer)
//    {
//    throw new NotImplementedException();
//    }

//  public void AssignToProperty(IPropertyContainer saveObject, PropertyInfo info) {
//    // TODO: add assigning of maps
//    saveObject.addDynamicProperty(this);
//  }
}
