package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableGeneratorFuel extends FGBuildableGenerator {
  @SaveProperty("mFuelInventory")
  private ObjectReference fuelInventory;

  /**
   * Amount left of the currently burned piece of fuel. In megawatt seconds (MWs).
   */
  @SaveProperty("mCurrentFuelAmount")
  private float currentFuelAmount;

  /**
   * Amount left of the currently loaded supplemental resource. In Liters ( 1 Liquid inventory item = 1 Liter )
   */
  @SaveProperty("mCurrentSupplementalAmount")
  private float currentSupplementalAmount;

  /**
   * Used so clients know how if they have available fuel or not. Could be removed later if we start syncing the production indicator state
   */
  @SaveProperty("mHasFuelCached") // TODO mHasFuleCached
  private boolean hasFuelCached;

  /**
   * Like the mHasFuelCached - Used to notify clients if there is enough supplemental resource available
   */
  @SaveProperty("mHasSupplementalCached")
  private boolean hasSupplementalCached;

  /**
   * Type of the currently burned piece of fuel.
   */
  @SaveProperty("mCurrentFuelClass")
  private ObjectReference currentFuelClass;

  public ObjectReference getFuelInventory() {
    return fuelInventory;
  }

  public void setFuelInventory(ObjectReference fuelInventory) {
    this.fuelInventory = fuelInventory;
  }

  public float getCurrentFuelAmount() {
    return currentFuelAmount;
  }

  public void setCurrentFuelAmount(float currentFuelAmount) {
    this.currentFuelAmount = currentFuelAmount;
  }

  public float getCurrentSupplementalAmount() {
    return currentSupplementalAmount;
  }

  public void setCurrentSupplementalAmount(float currentSupplementalAmount) {
    this.currentSupplementalAmount = currentSupplementalAmount;
  }

  public boolean isHasFuelCached() {
    return hasFuelCached;
  }

  public void setHasFuelCached(boolean hasFuelCached) {
    this.hasFuelCached = hasFuelCached;
  }

  public boolean isHasSupplementalCached() {
    return hasSupplementalCached;
  }

  public void setHasSupplementalCached(boolean hasSupplementalCached) {
    this.hasSupplementalCached = hasSupplementalCached;
  }

  public ObjectReference getCurrentFuelClass() {
    return currentFuelClass;
  }

  public void setCurrentFuelClass(ObjectReference currentFuelClass) {
    this.currentFuelClass = currentFuelClass;
  }
}
