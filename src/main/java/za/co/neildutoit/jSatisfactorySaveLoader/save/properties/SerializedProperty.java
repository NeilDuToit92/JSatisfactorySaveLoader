package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.IPropertyContainer;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class SerializedProperty {
  //  private static readonly Logger log = LogManager.GetCurrentClassLogger();
//  private static readonly Dictionary<(Type, String), (PropertyInfo, Attribute)> propertyCache = new Dictionary<(Type, String), (PropertyInfo, Attribute)>();
  private static Map<String, Field> propertyCache = new HashMap<>();

  /**
   * Name of the property
   */
  private String propertyName;

  /**
   * String representation of the name of the property type
   */
  private String propertyType;

  /**
   * Index of property when in an array
   */
  private int index;

  //
//  // TODO: not currently assigned/used/implemented
//  public byte HasPropertyGuid { get; private set; }

//  private abstract Type BackingType { get; }
  public Field backingObject;
//
//  public abstract int SerializedLength { get; }
//
  protected SerializedProperty(String propertyName, int index) {
    this.propertyName = propertyName;
    this.index = index;
  }

  public String getPropertyName() {
    return propertyName;
  }

  public int getIndex() {
    return index;
  }

  public String getPropertyType() {
    return propertyType;
  }

  public Field getBackingObject() {
    return backingObject;
  }

  //
//
//  ///
//
//  /// <param name="target"></param>
//  /// <returns></returns>
//  public (PropertyInfo Property, SavePropertyAttribute Attribute) GetMatchingSaveProperty(Type targetType)

  /**
   * Attempts to find a matching class property for this serialized property. Returns null if one can't be found.
   *
   * @param targetType
   * @return
   */
  public Field getMatchingSaveProperty(Class<?> targetType) {
    Field retField = null;
    if (getPropertyName().equals("mStorageInventory")) {
      System.out.println("");
    }
    if (propertyCache.containsKey(targetType.getTypeName() + ":" + getPropertyName())) {
      retField = propertyCache.get(targetType.getTypeName() + ":" + getPropertyName());
    } else {
      List<Field> fields = new ArrayList<>();
      //Filter annotations
      for (Field field : getAllFields(targetType)) {
        if (field.isAnnotationPresent(SaveProperty.class)) {
          fields.add(field);
        }
      }

      for (Field field : fields) {
        if (getPropertyName().equals(field.getAnnotation(SaveProperty.class).value())) {
          retField = field;
          break;
        }
      }

      propertyCache.put(targetType.getTypeName() + ":" + getPropertyName(), retField);
    }
    return retField;
  }

  private static List<Field> getAllFields(Class<?> type) {
    return getAllFields(new ArrayList<>(), type);
  }

  private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
    fields.addAll(Arrays.asList(type.getDeclaredFields()));

    if (type.getSuperclass() != null) {
      getAllFields(fields, type.getSuperclass());
    }

    return fields;
  }

//
//  ///     Attempts to find a matching struct property for this serialized property. Returns null if one can't be found.
//
//  /// <param name="target"></param>
//  /// <returns></returns>

  /**
   * Attempts to find a matching struct property for this serialized property. Returns null if one can't be found.
   */
    public Field getMatchingStructProperty(Class<?> targetType) {
      Field retField = null;

      if (propertyCache.containsKey(targetType.getTypeName() + ":" + getPropertyName())) {
        retField = propertyCache.get(targetType.getTypeName() + ":" + getPropertyName());
      } else {
        List<Field> fields = new ArrayList<>();
        //Filter annotations
        for (Field field : getAllFields(targetType)) {
          if (field.isAnnotationPresent(StructPropertyAttr.class)) {
            fields.add(field);
          }
        }

        for (Field field : fields) {
          if (getPropertyName().equals(field.getAnnotation(StructPropertyAttr.class).value())) {
            retField = field;
            break;
          }
        }

        propertyCache.put(targetType.getTypeName() + ":" + getPropertyName(), retField);
      }

      if (retField == null)
      {
        System.out.println("getMatchingStructProperty returning null: TypeName: " +  targetType.getTypeName() + " Property Name: " + getPropertyName());
      }

    return retField;
  }

  public void assignToProperty(IPropertyContainer saveObject, Field field) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
    if (getBackingObject() == null || field.getType() != getBackingObject().getType())
    {
//      log.Error($"Attempted to assign {PropertyType} {PropertyName} to incompatible backing field {info.DeclaringType}.{info.Name} ({info.PropertyType.Name})");
      saveObject.addDynamicProperty(this);
      return;
    }

    //    if (info.PropertyType.IsArray && BackingType == info.PropertyType.GetElementType())
    if (field.getType().isArray())
    {
      PropertyDescriptor pd = new PropertyDescriptor(field.getName(), saveObject.getClass());
      pd.getReadMethod().invoke(saveObject);
      Object value = getFieldValue(saveObject, field);
//      var array = (Array)info.GetValue(saveObject);
//      array.SetValue(BackingObject, Index);
      return;
    }

//    info.SetValue(saveObject, BackingObject);
//    saveObject
    Object value = getBackingObjectValue();
    setFieldValue(saveObject, field, value);
  }

  protected Object getFieldValue(IPropertyContainer saveObject, Field field) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), saveObject.getClass());
    return pd.getReadMethod().invoke(saveObject);
  }

  protected void setFieldValue(IPropertyContainer saveObject, Field field, Object value) throws InvocationTargetException, IllegalAccessException {
    PropertyDescriptor pd = null;
    try {
      pd = new PropertyDescriptor(field.getName(), saveObject.getClass());
    } catch (IntrospectionException e) {
      e.printStackTrace();
    }
    pd.getWriteMethod().invoke(saveObject, value);
  }

  private Object getBackingObjectValue() throws InvocationTargetException, IllegalAccessException {
    PropertyDescriptor pd = null;
    try {
      pd = new PropertyDescriptor(getBackingObject().getName(), this.getClass());
    } catch (IntrospectionException e) {
      e.printStackTrace();
    }
    return pd.getReadMethod().invoke(this);
  }

//  public abstract void Serialize(BinaryWriter writer);
//
//  public static Type GetPropertyTypeFromName(String name)
//  {
//    return name switch
//    {
//      ArrayProperty.TypeName => typeof(ArrayProperty),
//        BoolProperty.TypeName => typeof(BoolProperty),
//        ByteProperty.TypeName => typeof(ByteProperty),
//        EnumProperty.TypeName => typeof(EnumProperty),
//        FloatProperty.TypeName => typeof(FloatProperty),
//        Int64Property.TypeName => typeof(Int64Property),
//        InterfaceProperty.TypeName => typeof(InterfaceProperty),
//        IntProperty.TypeName => typeof(IntProperty),
//        MapProperty.TypeName => typeof(MapProperty),
//        NameProperty.TypeName => typeof(NameProperty),
//        ObjectProperty.TypeName => typeof(ObjectProperty),
//        SetProperty.TypeName => typeof(SetProperty),
//        StrProperty.TypeName => typeof(StrProperty),
//        StructProperty.TypeName => typeof(StructProperty),
//        TextProperty.TypeName => typeof(TextProperty),
//        _ => throw new NotImplementedException($"Unknown PropertyType {name}"),
//    };
//  }
//
//  public static Type GetPropertyValueTypeFromName(String name)
//  {
//    switch (name);
//    {
//      case ByteProperty.TYPE_NAME => typeof(ByteArrayValue),
//        EnumProperty.TypeName => typeof(EnumArrayValue),
//        FloatProperty.TypeName => typeof(FloatArrayValue),
//        InterfaceProperty.TypeName => typeof(InterfaceArrayValue),
//        IntProperty.TypeName => typeof(IntArrayValue),
//        NameProperty.TypeName => typeof(NameArrayValue),
//        ObjectProperty.TypeName => typeof(ObjectArrayValue),
//        StrProperty.TypeName => typeof(StrArrayValue),
//        StructProperty.TypeName => typeof(StructArrayValue),
//        TextProperty.TypeName => typeof(TextArrayValue),
//        _ => throw new NotImplementedException($"Unknown PropertyType {name}"),
//    };
//
//  }

  /**
   * Get the serialized length of a String in bytes, while taking encoding and overhead into account
   *
   * @param str
   * @return
   */
  public static int getSerializedLength(String str) {
    if (str == null || str.length() == 0) return 4;

    //if a single letter is not ascii, length will instead be a negative number and each letter will be 2 bytes
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if ((int) c > 127) {
        return str.length() * 2 + 6;
      }
    }
    return str.length() + 5;
  }
}
