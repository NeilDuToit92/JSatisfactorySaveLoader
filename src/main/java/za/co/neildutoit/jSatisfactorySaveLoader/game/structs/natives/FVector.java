package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector3;
import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("Vector")
public class FVector extends GameStruct {

//  public override String StructName => "Vector";
//  public override int SerializedLength => 12;

  public Vector3 data;

  public Vector3 getData() {
    return data;
  }

  public void setData(Vector3 data) {
    this.data = data;
  }

  @Override
  public void deserialize(BinaryReader reader) throws IOException {
    setData(reader.readVector3());
  }

//  public override void Serialize(BinaryWriter writer)
//  {
//    writer.Write(Data);
//  }
}
