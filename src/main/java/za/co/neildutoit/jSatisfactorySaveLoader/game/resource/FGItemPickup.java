package za.co.neildutoit.jSatisfactorySaveLoader.game.resource;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FInventoryStack;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

public abstract class FGItemPickup extends SaveActor {
  @SaveProperty("mPickupItems")
  private FInventoryStack pickupItems;

  public FInventoryStack getPickupItems() {
    return pickupItems;
  }

  public void setPickupItems(FInventoryStack pickupItems) {
    this.pickupItems = pickupItems;
  }
}
