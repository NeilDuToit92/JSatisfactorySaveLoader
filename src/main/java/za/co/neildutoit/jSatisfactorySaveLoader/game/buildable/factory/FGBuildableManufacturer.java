package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableManufacturer extends FGBuildableFactory {
  @SaveProperty("mCurrentManufacturingProgress")
  private float currentManufacturingProgress;

  @SaveProperty("mInputInventory")
  private ObjectReference inputInventory;

  @SaveProperty("mOutputInventory")
  private ObjectReference outputInventory;

  @SaveProperty("mCurrentRecipe")
  private ObjectReference currentRecipe;

  public float getCurrentManufacturingProgress() {
    return currentManufacturingProgress;
  }

  public void setCurrentManufacturingProgress(float currentManufacturingProgress) {
    this.currentManufacturingProgress = currentManufacturingProgress;
  }

  public ObjectReference getInputInventory() {
    return inputInventory;
  }

  public void setInputInventory(ObjectReference inputInventory) {
    this.inputInventory = inputInventory;
  }

  public ObjectReference getOutputInventory() {
    return outputInventory;
  }

  public void setOutputInventory(ObjectReference outputInventory) {
    this.outputInventory = outputInventory;
  }

  public ObjectReference getCurrentRecipe() {
    return currentRecipe;
  }

  public void setCurrentRecipe(ObjectReference currentRecipe) {
    this.currentRecipe = currentRecipe;
  }
}
