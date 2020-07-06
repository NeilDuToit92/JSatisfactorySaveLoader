package za.co.neildutoit.jSatisfactorySaveLoader.game.world.benefit;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Game/FactoryGame/World/Benefit/DropPod/BP_DropPod.BP_DropPod_C")
public class DropPod extends SaveActor {
  @SaveProperty("mHasBeenOpened")
  private boolean hasBeenOpened;

  @SaveProperty("mInventory")
  private ObjectReference inventory;

  public boolean isHasBeenOpened() {
    return hasBeenOpened;
  }

  public void setHasBeenOpened(boolean hasBeenOpened) {
    this.hasBeenOpened = hasBeenOpened;
  }

  public ObjectReference getInventory() {
    return inventory;
  }

  public void setInventory(ObjectReference inventory) {
    this.inventory = inventory;
  }
}
