package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import org.apache.commons.lang3.mutable.MutableInt;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStructFactory;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IStructPropertyValue;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

public class StructProperty extends SerializedProperty implements IStructPropertyValue {
  //  private static readonly Logger log = LogManager.GetCurrentClassLogger();
  public static final String TYPE_NAME = "StructProperty";

  public GameStruct data;

  public StructProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  @Override
  public GameStruct getData() {
    return data;
  }

  @Override
  public void setData(GameStruct data) {
    this.data = data;
  }

  private String propertyType = "StructProperty";

  //  public override Type BackingType => typeof(object);
//  public Field backingObject = this.getClass().getDeclaredField("");
  public Field backingObject = null;

//  public override int SerializedLength => 0;

  public int Unk1;
  public int Unk2;
  public int Unk3;
  public int Unk4;
  public byte Unk5;

  public int getUnk1() {
    return Unk1;
  }

  public void setUnk1(int unk1) {
    Unk1 = unk1;
  }

  public int getUnk2() {
    return Unk2;
  }

  public void setUnk2(int unk2) {
    Unk2 = unk2;
  }

  public int getUnk3() {
    return Unk3;
  }

  public void setUnk3(int unk3) {
    Unk3 = unk3;
  }

  public int getUnk4() {
    return Unk4;
  }

  public void setUnk4(int unk4) {
    Unk4 = unk4;
  }

  public byte getUnk5() {
    return Unk5;
  }

  public void setUnk5(byte unk5) {
    Unk5 = unk5;
  }

  @Override
  public String getPropertyType() {
    return propertyType;
  }

  //  public override String ToString()
//  {
//    return $"Struct {PropertyName}";
//  }

  public static StructProperty deserialize(BinaryReader reader, String propertyName, int size, int index, MutableInt overhead) throws IOException, InstantiationException, IllegalAccessException, NoSuchFieldException, IntrospectionException, InvocationTargetException {
    StructProperty result = new StructProperty(propertyName, index);
    String structType = reader.readCharArray().trim();
    overhead.setValue(structType.trim().length() + 22);

    result.Unk1 = reader.readInt32();
    result.Unk2 = reader.readInt32();
    result.Unk3 = reader.readInt32();
    result.Unk4 = reader.readInt32();
    result.Unk5 = reader.readByte();

    int before = reader.getPosition();

    GameStruct structObj = GameStructFactory.createFromType(structType);
    structObj.deserialize(reader);
    result.setData(structObj);

    int after = reader.getPosition();

//    if (before + size != after)
//      throw new InvalidOperationException("Expected {size} bytes read but got {after - before}");

    return result;
  }

  //  public void Serialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }

  public void assignToProperty(IPropertyContainer saveObject, Field field) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
    if (field.getType().isArray() && data.getClass().getTypeName().equals(field.getType().getTypeName().replace("[]", ""))) {
      Object[] array = (Object[])getFieldValue(saveObject, field);
      array = Arrays.copyOf(array, array.length + 1); //create new array from old array and allocate one more element
      array[array.length - 1] = data;
      setFieldValue(saveObject, field, array);
      return;
    }

    String typeName1 = field.getType().getTypeName();
    String typeName2 = data.getClass().getTypeName();
    if (data == null || !field.getType().getTypeName().equals(data.getClass().getTypeName()))
    {
//      log.Error($"Attempted to assign {PropertyType} {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
      saveObject.addDynamicProperty(this);
      return;
    }

    setFieldValue(saveObject, field, data);
  }
}
