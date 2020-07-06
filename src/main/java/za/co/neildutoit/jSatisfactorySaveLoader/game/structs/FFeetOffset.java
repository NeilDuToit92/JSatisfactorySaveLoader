package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;

@GameStructAttr("FeetOffset")
public class FFeetOffset extends GameStruct {
//  public override String StructName => "FeetOffset";

  @StructPropertyAttr("FeetIndex")
  private byte feetIndex;

  @StructPropertyAttr("FeetName")
  private String feetName;

  @StructPropertyAttr("OffsetZ")
  private float offsetZ;

  @StructPropertyAttr("ShouldShow")
  private boolean shouldShow;

  public byte getFeetIndex() {
    return feetIndex;
  }

  public void setFeetIndex(byte feetIndex) {
    this.feetIndex = feetIndex;
  }

  public String getFeetName() {
    return feetName;
  }

  public void setFeetName(String feetName) {
    this.feetName = feetName;
  }

  public float getOffsetZ() {
    return offsetZ;
  }

  public void setOffsetZ(float offsetZ) {
    this.offsetZ = offsetZ;
  }

  public boolean isShouldShow() {
    return shouldShow;
  }

  public void setShouldShow(boolean shouldShow) {
    this.shouldShow = shouldShow;
  }
}
