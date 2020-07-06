package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("Color")
public class FColor extends GameStruct {
//  public override String StructName => "Color";
//  public override int SerializedLength => 4;

  private byte r;
  private byte g;
  private byte b;
  private byte a;

  public byte getR() {
    return r;
  }

  public void setR(byte r) {
    this.r = r;
  }

  public byte getG() {
    return g;
  }

  public void setG(byte g) {
    this.g = g;
  }

  public byte getB() {
    return b;
  }

  public void setB(byte b) {
    this.b = b;
  }

  public byte getA() {
    return a;
  }

  public void setA(byte a) {
    this.a = a;
  }

  public void deserialize(BinaryReader reader) throws IOException {
    setB(reader.readByte());
    setG(reader.readByte());
    setR(reader.readByte());
    setA(reader.readByte());
  }


//  public override void Serialize(BinaryWriter writer)
//{
//  writer.Write(B);
//  writer.Write(G);
//  writer.Write(R);
//  writer.Write(A);
//}
}
