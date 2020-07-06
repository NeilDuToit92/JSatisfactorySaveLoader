package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

/**
 * Building that you can sink items into to get points
 */
@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/ResourceSink/Build_ResourceSink.Build_ResourceSink_C")
public class ResourceSink extends FGBuildableFactory {

  @SaveProperty("mCouponInventory")
  private ObjectReference couponInventory;

  @SaveProperty("mSavedProducingTimer")
  private float savedProducingTimer;

  public ObjectReference getCouponInventory() {
    return couponInventory;
  }

  public void setCouponInventory(ObjectReference couponInventory) {
    this.couponInventory = couponInventory;
  }

  public float getSavedProducingTimer() {
    return savedProducingTimer;
  }

  public void setSavedProducingTimer(float savedProducingTimer) {
    this.savedProducingTimer = savedProducingTimer;
  }
}
