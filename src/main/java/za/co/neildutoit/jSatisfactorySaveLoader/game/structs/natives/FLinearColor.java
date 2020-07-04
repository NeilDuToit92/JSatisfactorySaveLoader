package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("LinearColor")
public class FLinearColor extends GameStruct {
//  public override String StructName => "LinearColor";
//  public override int SerializedLength => 16;

  private float r;
  private float g;
  private float b;
  private float a;

  public float getR() {
    return r;
  }

  public void setR(float r) {
    this.r = r;
  }

  public float getG() {
    return g;
  }

  public void setG(float g) {
    this.g = g;
  }

  public float getB() {
    return b;
  }

  public void setB(float b) {
    this.b = b;
  }

  public float getA() {
    return a;
  }

  public void setA(float a) {
    this.a = a;
  }

  @Override
  public void deserialize(BinaryReader reader) throws IOException {
    this.r = reader.readSingle();
    this.g = reader.readSingle();
    this.b = reader.readSingle();
    this.a = reader.readSingle();
  }

//  public override void Serialize(BinaryWriter writer)
//{
//  writer.Write(R);
//  writer.Write(G);
//  writer.Write(B);
//  writer.Write(A);
//}
}
