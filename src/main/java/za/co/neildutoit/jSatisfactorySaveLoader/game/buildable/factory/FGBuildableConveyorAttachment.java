package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableConveyorAttachment extends FGBuildableFactory {
  @SaveProperty("mBufferInventory")
  private ObjectReference bufferInventory;

  public ObjectReference getBufferInventory() {
    return bufferInventory;
  }

  public void setBufferInventory(ObjectReference bufferInventory) {
    this.bufferInventory = bufferInventory;
  }
}
