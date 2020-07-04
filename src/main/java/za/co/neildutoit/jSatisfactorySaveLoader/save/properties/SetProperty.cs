using System;
using System.Collections.Generic;
using System.IO;

using SatisfactorySaveParser.Save.Properties.ArrayValues;

namespace SatisfactorySaveParser.Save.Properties
{
    public class SetProperty : SerializedProperty
    {
        public const String TypeName = nameof(SetProperty);
        public override String PropertyType => TypeName;

        public override Type BackingType => typeof(List<IArrayElement>);
        public override object BackingObject => Elements;

        public override int SerializedLength => 0;

        /// <summary>
        ///     String representation of the Property type this set consists of
        /// </summary>
        public String Type //{ get; set; }

        /// <summary>
        ///     Actual content of the set
        /// </summary>
        public List<IArrayElement> Elements { get; } = new List<IArrayElement>();

        public SetProperty(String propertyName, int index = 0) : base(propertyName, index)
        {
        }

        public static SetProperty Parse(BinaryReader reader, String propertyName, int index, out int overhead)
        {
            var result = new SetProperty(propertyName, index)
            {
                Type = reader.ReadLengthPrefixedString()
            };

            reader.AssertNullByte();
            reader.AssertNullInt32();

            var count = reader.ReadInt32();

            switch (result.Type)
            {
                case NameProperty.TypeName:
                    {
                        for (var i = 0; i < count; i++)
                        {
                            result.Elements.Add(new NameArrayValue()
                            {
                                Value = reader.ReadLengthPrefixedString()
                            });
                        }
                    }
                    break;

                default:
                    throw new NotImplementedException($"Unimplemented Set type: {result.Type}");
            }


            overhead = result.Type.Length + 6;
            return result;
        }

        public override void Serialize(BinaryWriter writer)
        {
            throw new NotImplementedException();
        }
    }
}
