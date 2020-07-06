package za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

@GameStructAttr("RailroadTrackPosition")
public class FRailroadTrackPosition extends GameStruct {
//public override String StructName => "RailroadTrackPosition";
//public override int SerializedLength => Root.GetSerializedLength() + InstanceName.GetSerializedLength() + 8;

  private String root;
  private String instanceName;
  private float offset;
  private float forward;

  public String getRoot() {
    return root;
  }

  public void setRoot(String root) {
    this.root = root;
  }

  public String getInstanceName() {
    return instanceName;
  }

  public void setInstanceName(String instanceName) {
    this.instanceName = instanceName;
  }

  public float getOffset() {
    return offset;
  }

  public void setOffset(float offset) {
    this.offset = offset;
  }

  public float getForward() {
    return forward;
  }

  public void setForward(float forward) {
    this.forward = forward;
  }

  public void deserialize(BinaryReader reader) throws IOException {
    setRoot(reader.readCharArray());
    setInstanceName(reader.readCharArray());
    setOffset(reader.readSingle());
    setForward(reader.readSingle());
  }

//public override void Serialize(BinaryWriter writer)
//    {
//    writer.WriteLengthPrefixedString(Root);
//    writer.WriteLengthPrefixedString(InstanceName);
//    writer.Write(Offset);
//    writer.Write(Forward);
//    }
}
