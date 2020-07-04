package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector3;
import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("Box")
public class Box extends GameStruct {
//  public override String StructName => "Box";
//  public override int SerializedLength => 25;

  private Vector3 min;
  private Vector3 max;
  private byte unknownByte;

  public Vector3 getMin() {
    return min;
  }

  public void setMin(Vector3 min) {
    this.min = min;
  }

  public Vector3 getMax() {
    return max;
  }

  public void setMax(Vector3 max) {
    this.max = max;
  }

  public byte getUnknownByte() {
    return unknownByte;
  }

  public void setUnknownByte(byte unknownByte) {
    this.unknownByte = unknownByte;
  }

  @Override
  public void deserialize(BinaryReader reader) throws IOException {
    this.min = reader.readVector3();
    this.max = reader.readVector3();
    this.unknownByte = reader.readByte();
  }

//  public override void Serialize(BinaryWriter writer)
//  {
//    writer.Write(Min);
//    writer.Write(Max);
//    writer.Write(UnknownByte);
//  }
}
