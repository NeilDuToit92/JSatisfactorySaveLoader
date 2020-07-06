package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.FGBuildable;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public class FGBuildableFactory extends FGBuildable {
  @SaveProperty("mPowerInfo")
  private ObjectReference powerInfo;

  @SaveProperty("mTimeSinceStartStopProducing")
  private float timeSinceStartStopProducing;

  @SaveProperty("mCurrentPotential")
  private float currentPotential;

  @SaveProperty("mPendingPotential")
  private float pendingPotential;

  @SaveProperty("mIsProductionPaused")
  private boolean isProductionPaused;

  @SaveProperty("mInventoryPotential")
  private ObjectReference inventoryPotential;

  @SaveProperty("mIsProducing")
  private boolean isProducing;

  public ObjectReference getPowerInfo() {
    return powerInfo;
  }

  public void setPowerInfo(ObjectReference powerInfo) {
    this.powerInfo = powerInfo;
  }

  public float getTimeSinceStartStopProducing() {
    return timeSinceStartStopProducing;
  }

  public void setTimeSinceStartStopProducing(float timeSinceStartStopProducing) {
    this.timeSinceStartStopProducing = timeSinceStartStopProducing;
  }

  public float getCurrentPotential() {
    return currentPotential;
  }

  public void setCurrentPotential(float currentPotential) {
    this.currentPotential = currentPotential;
  }

  public float getPendingPotential() {
    return pendingPotential;
  }

  public void setPendingPotential(float pendingPotential) {
    this.pendingPotential = pendingPotential;
  }

  public boolean isIsProductionPaused() {
    return isProductionPaused;
  }

  public void setIsProductionPaused(boolean productionPaused) {
    isProductionPaused = productionPaused;
  }

  public ObjectReference getInventoryPotential() {
    return inventoryPotential;
  }

  public void setInventoryPotential(ObjectReference inventoryPotential) {
    this.inventoryPotential = inventoryPotential;
  }

  public boolean isIsProducing() {
    return isProducing;
  }

  public void setIsProducing(boolean producing) {
    isProducing = producing;
  }
}
