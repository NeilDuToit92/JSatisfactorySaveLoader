package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import za.co.neildutoit.jSatisfactorySaveLoader.save.TextEntry;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.ITextPropertyValue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Objects;

public class TextProperty extends SerializedProperty implements ITextPropertyValue {
  public static final String TYPE_NAME = "TextProperty";
//  public const String TypeName = nameof(TextProperty);
//  public override String PropertyType => TypeName;

//  public override Type BackingType => typeof(TextEntry);
//  public override object BackingObject => Text;
private Field backingObject = this.getClass().getDeclaredField("text");

//  public  int SerializedLength => 5 + Text.SerializedLength;

  /**
   * History Type
   */
  private TextEntry.ETextHistoryType historyType;

  private TextEntry text;

  public TextProperty(String propertyName, int index) throws NoSuchFieldException {
    super(propertyName, index);
  }

  public TextEntry getText() {
    return text;
  }

  public void setText(TextEntry text) {
    this.text = text;
  }

  @Override
  public Field getBackingObject() {
    return backingObject;
  }

  //  public override String ToString()
//{
//  return $"Text {PropertyName}: {Text}";
//}

  public static TextEntry parseTextEntry(BinaryReader reader) throws IOException {
    int flags = reader.readInt32();
    //FSaveHeaderVersion.values()[reader.readInt32()]
    byte historyTypeByte = reader.readByte();
    //TODO: Test mode here
//    TextEntry.ETextHistoryType historyType = TextEntry.ETextHistoryType.values()[historyTypeByte];
    TextEntry.ETextHistoryType historyType = TextEntry.ETextHistoryType.getByNumber(historyTypeByte);

    switch (Objects.requireNonNull(historyType)) {
      //TODO: Start here
      case Base: {
        TextEntry.BaseTextEntry baseTextEntry = new TextEntry.BaseTextEntry();
        baseTextEntry.setNamespace(reader.readCharArray());
        baseTextEntry.setKey(reader.readCharArray());
        baseTextEntry.setValue(reader.readCharArray());
        return baseTextEntry;
      }
//      break;
//      case ArgumentFormat: {
//        var result = new ArgumentFormatTextEntry(flags)
//        {
//          SourceFormat = (BaseTextEntry)ParseTextEntry(reader)
//        };
//
//        int count = reader.readInt32();
//        for (int i = 0; i < count; i++)
//        {
//          result.Arguments.add(new ArgumentFormat()
//          {
//            Name = reader.ReadLengthPrefixedString(),
//            ValueType = (EFormatArgumentType)reader.ReadByte(),
//            Value = ParseTextEntry(reader)
//          });
//
//        }
//        return result;
//      }
      case None: {
        return new TextEntry.NoneTextEntry(flags);
      }
      default:
        System.out.println("Unknown ETextHistoryType " + historyType);
        throw new NotImplementedException();
    }
  }

  public static TextProperty deserialize(BinaryReader reader, String propertyName, int index) throws IOException, NoSuchFieldException {
    TextProperty result = new TextProperty(propertyName, index);

    reader.assertNullByte();
    result.setText(parseTextEntry(reader));

    return result;
  }

//  public void Serialize(BinaryWriter writer)
//{
//  writer.Write((byte)0);
//  writer.Write(Text.Flags);
//  writer.Write((byte)Text.HistoryType);
//
//}
}
