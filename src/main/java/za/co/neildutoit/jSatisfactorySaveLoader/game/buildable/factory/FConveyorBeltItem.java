package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public class FConveyorBeltItem {
  // FInventoryItem
  private String itemClass;

  private ObjectReference itemState;

  private float offset;

  public FConveyorBeltItem(String itemClass, ObjectReference itemState, float offset) {
    this.itemClass = itemClass;
    this.itemState = itemState;
    this.offset = offset;
  }

  public String getItemClass() {
    return itemClass;
  }

  public void setItemClass(String itemClass) {
    this.itemClass = itemClass;
  }

  public ObjectReference getItemState() {
    return itemState;
  }

  public void setItemState(ObjectReference itemState) {
    this.itemState = itemState;
  }

  public float getOffset() {
    return offset;
  }

  public void setOffset(float offset) {
    this.offset = offset;
  }
}
