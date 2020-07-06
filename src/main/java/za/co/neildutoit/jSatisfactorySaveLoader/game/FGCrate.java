package za.co.neildutoit.jSatisfactorySaveLoader.game;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Game/FactoryGame/-Shared/Crate/BP_Crate.BP_Crate_C")
public class FGCrate extends SaveActor {
  @SaveProperty("mInventory")
  private ObjectReference inventory;

  public ObjectReference getInventory() {
    return inventory;
  }

  public void setInventory(ObjectReference inventory) {
    this.inventory = inventory;
  }
}