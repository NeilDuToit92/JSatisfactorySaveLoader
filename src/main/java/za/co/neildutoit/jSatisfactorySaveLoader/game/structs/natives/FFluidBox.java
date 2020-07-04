package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("FluidBox")
public class FFluidBox extends GameStruct {
//  public override String StructName => "FluidBox";
//  public override int SerializedLength => 4;

  private float unknown;

  public void deserialize(BinaryReader reader) throws IOException {
    setUnknown(reader.readSingle());
  }

  public float getUnknown() {
    return unknown;
  }

  public void setUnknown(float unknown) {
    this.unknown = unknown;
  }

//  public override void Serialize(BinaryWriter writer)
//{
//  writer.Write(Unknown);
//}
}
