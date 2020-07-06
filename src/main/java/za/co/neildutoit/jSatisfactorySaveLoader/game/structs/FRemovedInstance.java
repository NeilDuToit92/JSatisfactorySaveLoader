package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;

@GameStructAttr("RemovedInstance")
public class FRemovedInstance extends GameStruct {
//  public String STRUCT_NAME = "RemovedInstance";

  @StructPropertyAttr("Transform")
  private FTransform transform;

  public FTransform getTransform() {
    return transform;
  }

  public void setTransform(FTransform transform) {
    this.transform = transform;
  }
}
