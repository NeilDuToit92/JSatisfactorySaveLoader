package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector4;
import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("Quat")
public class FQuat extends GameStruct {
//  public override String StructName => "Quat";
//  public override int SerializedLength => 16;
//
  public Vector4 data;

  public Vector4 getData() {
    return data;
  }

  public void setData(Vector4 data) {
    this.data = data;
  }

  @Override
  public void deserialize(BinaryReader reader) throws IOException {
    setData(reader.readVector4());
  }



//  public void Serialize(BinaryWriter writer)
//  {
//    writer.Write(Data);
//  }
}
