using System;

namespace SatisfactorySaveParser.Game.Structs
{
    [AttributeUsage(AttributeTargets.Class, AllowMultiple = true)]
    public class GameStructAttribute : Attribute
    {
        public String StructName //{ get; set; }

        public GameStructAttribute(String structName)
        {
            StructName = structName;
        }
    }
}
