package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableStorage extends FGBuildableFactory {
  @SaveProperty("mStorageInventory")
  private ObjectReference storageInventory;

  public ObjectReference getStorageInventory() {
    return storageInventory;
  }

  public void setStorageInventory(ObjectReference storageInventory) {
    this.storageInventory = storageInventory;
  }
}
