package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("InventoryItem")
public class FInventoryItem extends GameStruct {
//  public override String StructName => "InventoryItem";
//  public int SerializedLength => 4 + itemType.GetSerializedLength() + unknown2.GetSerializedLength() + unknown3.GetSerializedLength();

  public int unknown1;
  public String itemType;
  public String unknown2;
  public String unknown3;

  @Override
  public void deserialize(BinaryReader reader) throws IOException {
    this.unknown1 = reader.readInt32();
    this.itemType = reader.readCharArray();
    this.unknown2 = reader.readCharArray();
    this.unknown3 = reader.readCharArray();
  }

//  public void Serialize(BinaryWriter writer)
//  {
//    writer.Write(Unknown1);
//    writer.WriteLengthPrefixedString(ItemType);
//    writer.WriteLengthPrefixedString(Unknown2);
//    writer.WriteLengthPrefixedString(Unknown3);
//  }
}
