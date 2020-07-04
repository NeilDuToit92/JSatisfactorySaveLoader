package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStructFactory;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArrayProperty extends SerializedProperty {
  public static final String TYPE_NAME = "ArrayProperty";
//  private static readonly Logger log = LogManager.GetCurrentClassLogger();
//
//  public const String TypeName = nameof(ArrayProperty);
//  public override String PropertyType => TypeName;
//
//  public override Type BackingType => typeof(List<IArrayElement>);
//  public override object BackingObject => Elements;
//
//  public override int SerializedLength => 0;

  /**
   * String representation of the Property type this array consists of
   */
  public String type;

  /**
   * Actual content of the array
   */
  public List<IArrayElement> elements = new ArrayList<IArrayElement>();

  public ArrayProperty(String propertyName, int index) {
    super(propertyName, index);
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public List<IArrayElement> getElements() {
    return elements;
  }

  public static ArrayProperty parse(BinaryReader reader, String propertyName, int index, MutableInt overhead) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException {
    ArrayProperty result = new ArrayProperty(propertyName, index);
    result.setType(reader.readCharArray().trim());
    reader.assertNullByte();

    overhead.setValue(getSerializedLength(result.getType()) + 1);

    int count = reader.readInt32();

    switch (result.getType()) {
      case ByteProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          ByteArrayValue byteArrayValue = new ByteArrayValue();
          byteArrayValue.setByteValue(reader.readByte());
          result.getElements().add(byteArrayValue);
        }
      }
      break;

      case EnumProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          String str = reader.readCharArray();
          EnumArrayValue enumArrayValue = new EnumArrayValue();
          enumArrayValue.setValue(str);
          enumArrayValue.setType(str.split(":")[0]);
          result.getElements().add(enumArrayValue);
        }
      }
      break;

      case FloatProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          FloatArrayValue floatArrayValue = new FloatArrayValue();
          floatArrayValue.setValue(reader.readSingle());
          result.getElements().add(floatArrayValue);
        }
      }
      break;

      case IntProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          IntArrayValue intArrayValue = new IntArrayValue();
          intArrayValue.setValue(reader.readInt32());
          result.getElements().add(intArrayValue);
        }
      }
      break;

      case InterfaceProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          InterfaceArrayValue interfaceArrayValue = new InterfaceArrayValue();
          interfaceArrayValue.setReference(reader.readObjectReference());
          result.getElements().add(interfaceArrayValue);
        }
      }
      break;

      case ObjectProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          ObjectArrayValue objectArrayValue = new ObjectArrayValue();
          objectArrayValue.setReference(reader.readObjectReference());
          result.getElements().add(objectArrayValue);
        }
      }
      break;

      case StrProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          StrArrayValue strArrayValue = new StrArrayValue();
          strArrayValue.setValue(reader.readCharArray());
          result.getElements().add(strArrayValue);
        }
      }
      break;

      case StructProperty.TYPE_NAME: {
        String name = reader.readCharArray();

        String propertyType = reader.readCharArray();
//        Trace.Assert(propertyType == "StructProperty");

        int structSize = reader.readInt32();
        int structIndex = reader.readInt32();

        String structType = reader.readCharArray();

        int unk1 = reader.readInt32();
        int unk2 = reader.readInt32();
        int unk3 = reader.readInt32();
        int unk4 = reader.readInt32();
        int unk5 = reader.readByte();

        for (int i = 0; i < count; i++) {
          GameStruct structObj = GameStructFactory.createFromType(structType);
          structObj.deserialize(reader);

          StructArrayValue structArrayValue = new StructArrayValue();
          structArrayValue.setData(structObj);
          result.getElements().add(structArrayValue);
        }
      }
      break;

      case TextProperty.TYPE_NAME: {
        for (int i = 0; i < count; i++) {
          TextArrayValue textArrayValue = new TextArrayValue();
          textArrayValue.setText(TextProperty.parseTextEntry(reader));

          result.getElements().add(textArrayValue);
        }
      }
      break;

      default:
        System.out.println("Unimplemented Array type: " + result.getType());
//        throw new NotImplementedException();
    }

    return result;
  }

//  public override void Serialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
//
//  public override void AssignToProperty(IPropertyContainer saveObject, PropertyInfo info)
//  {
//    if (info.PropertyType.GetGenericTypeDefinition() != typeof(List<>))
//    {
//      log.Error($"Attempted to assign array {PropertyName} to non list field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
//      saveObject.AddDynamicProperty(this);
//      return;
//    }
//
//    var propertyType = info.PropertyType.GetGenericArguments()[0];
//    var mismatchedType = Elements.FirstOrDefault(e => !e.BackingType.IsAssignableFrom(propertyType));
//    if (mismatchedType != null)
//    {
//      log.Error($"Attempted to insert {mismatchedType.BackingType} into {info.DeclaringType}.{info.Name} of {propertyType}");
//      saveObject.AddDynamicProperty(this);
//      return;
//    }
//
//    var list = info.GetValue(saveObject);
//    var addMethod = info.PropertyType.GetMethod(nameof(List<object>.Add));
//
//    switch (Type)
//    {
//      case ByteProperty.TypeName:
//      {
//        foreach (var obj in Elements.Cast<IBytePropertyValue>())
//        {
//          addMethod.Invoke(list, new[] { (object)obj.ByteValue });
//        }
//      }
//      break;
//
//      case EnumProperty.TypeName:
//      {
//        // TODO: add assigning of enums
//        saveObject.AddDynamicProperty(this);
//      }
//      break;
//
//      case IntProperty.TypeName:
//      {
//        foreach (var prop in Elements.Cast<IIntPropertyValue>())
//        {
//          addMethod.Invoke(list, new[] { (object)prop.Value });
//        }
//      }
//      break;
//
//      case ObjectProperty.TypeName:
//      {
//        foreach (var obj in Elements.Cast<IObjectPropertyValue>())
//        {
//          addMethod.Invoke(list, new[] { obj.Reference });
//        }
//      }
//      break;
//
//      case StructProperty.TypeName:
//      {
//        foreach (var obj in Elements.Cast<IStructPropertyValue>())
//        {
//          addMethod.Invoke(list, new[] { obj.Data });
//        }
//      }
//      break;
//
//      case InterfaceProperty.TypeName:
//      {
//        foreach (var obj in Elements.Cast<IInterfacePropertyValue>())
//        {
//          addMethod.Invoke(list, new[] { obj.Reference });
//        }
//      }
//      break;
//
//      default:
//      {
//        log.Warn($"Attempted to assign array {PropertyName} of unknown type {Type}");
//        saveObject.AddDynamicProperty(this);
//      }
//      break;
//    }
//  }
}
