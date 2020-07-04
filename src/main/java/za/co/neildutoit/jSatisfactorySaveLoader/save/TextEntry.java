package za.co.neildutoit.jSatisfactorySaveLoader.save;

public abstract class TextEntry {
  /*
  amespace SatisfactorySaveParser.Save
{
#pragma warning disable CA1720 // Identifier contains type name
    public enum EFormatArgumentType
    {
        Int,
        UInt,
        Float,
        Double,
        Text,
        Gender,
    }
#pragma warning restore CA1720 // Identifier contains type name
   */

  public enum ETextHistoryType {
    None(255),
    Base(0),
    NamedFormat,
    OrderedFormat,
    ArgumentFormat,
    AsNumber,
    AsPercent,
    AsCurrency,
    AsDate,
    AsTime,
    AsDateTime,
    Transform,
    StringTableEntry,
    TextGenerator;

    private int number;

    ETextHistoryType(int number) {
      this.number = number;
    }

    ETextHistoryType() { }

    public static ETextHistoryType getByNumber(int number) {
      for (ETextHistoryType e : values()) {
        if (e.number == number) {
          return e;
        }
      }
      return null;
    }

    public int getNumber() {
      return number;
    }

    public void setNumber(int number) {
      this.number = number;
    }
  }


//        public abstract ETextHistoryType HistoryType { get; }
//        public abstract int SerializedLength { get; }

  private int flags;

  public int getFlags() {
    return flags;
  }

  public void setFlags(int flags) {
    this.flags = flags;
  }

  public TextEntry(int flags) {
    this.flags = flags;
  }

  public TextEntry() {}

  public static class BaseTextEntry extends TextEntry //implements IEquatable<BaseTextEntry>
  {
//          public override ETextHistoryType HistoryType => ETextHistoryType.Base;
//          public override int SerializedLength => Namespace.GetSerializedLength() + Key.GetSerializedLength() + Value.GetSerializedLength();

    private String namespace;

    /**
     * Unknown String value, possibly relating to String table
     */
    private String key;

    /**
     * Main text value
     */
    private String value;

    public BaseTextEntry() {
    }

    public BaseTextEntry(int flags) {
      super(flags);
    }

    public String getNamespace() {
      return namespace;
    }

    public void setNamespace(String namespace) {
      this.namespace = namespace;
    }

    public String getKey() {
      return key;
    }

    public void setKey(String key) {
      this.key = key;
    }

    public String getValue() {
      return value;
    }

    public void setValue(String value) {
      this.value = value;
    }

    //          public boolean Equals(BaseTextEntry other)
//          {
//              if (other == null) return false;
//
//              return Flags == other.Flags &&
//                  Namespace == other.Namespace &&
//                  Key == other.Key &&
//                  Value == other.Value;
//          }

//          public boolean equals(object obj)
//          {
//              return Equals(obj as BaseTextEntry);
//          }
//
//          public override int GetHashCode()
//          {
//              return Flags + Namespace.GetHashCode(StringComparison.InvariantCulture) + 17 * Key.GetHashCode(StringComparison.InvariantCulture) + 23 * Value.GetHashCode(StringComparison.InvariantCulture);
//          }
  }

  /*
        public class ArgumentFormat : IEquatable<ArgumentFormat>
        {
            public String Name //{ get; set; }
            public EFormatArgumentType ValueType //{ get; set; }
            public TextEntry Value //{ get; set; }

            public bool Equals(ArgumentFormat other)
            {
                if (other == null) return false;

                return Name == other.Name &&
                    Value.Equals(other.Value);
            }

            public override bool Equals(object obj)
            {
                return Equals(obj as ArgumentFormat);
            }

            public override int GetHashCode()
            {
                return Name.GetHashCode(StringComparison.InvariantCulture) + 17 * Value.GetHashCode();
            }
        }

        public class ArgumentFormatTextEntry : TextEntry
        {
            public override ETextHistoryType HistoryType => ETextHistoryType.ArgumentFormat;
            public override int SerializedLength => 0;

            public BaseTextEntry SourceFormat //{ get; set; }

            public List<ArgumentFormat> Arguments { get; } = new List<ArgumentFormat>();

            public ArgumentFormatTextEntry(int flags) : base(flags)
            {
            }
        }
    */
  public static class NoneTextEntry extends TextEntry {
//        public override ETextHistoryType HistoryType => ETextHistoryType.None;

//        public override int SerializedLength => 0;

    public NoneTextEntry(int flags) {
      super(flags);
    }
  }
}


