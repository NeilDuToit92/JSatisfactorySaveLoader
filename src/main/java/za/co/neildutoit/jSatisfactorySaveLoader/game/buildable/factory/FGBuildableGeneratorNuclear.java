package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableGeneratorNuclear extends FGBuildableGeneratorFuel {
  @SaveProperty("mOutputInventory")
  private ObjectReference outputInventory;

        @SaveProperty("mWasteLeftFromCurrentFuel")
        private int wasteLeftFromCurrentFuel;

  public ObjectReference getOutputInventory() {
    return outputInventory;
  }

  public void setOutputInventory(ObjectReference outputInventory) {
    this.outputInventory = outputInventory;
  }

  public int getWasteLeftFromCurrentFuel() {
    return wasteLeftFromCurrentFuel;
  }

  public void setWasteLeftFromCurrentFuel(int wasteLeftFromCurrentFuel) {
    this.wasteLeftFromCurrentFuel = wasteLeftFromCurrentFuel;
  }
}
