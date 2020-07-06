package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsystem to handle the resource sink and the rewards from sinked items
 */
@SaveObjectClass("/Script/FactoryGame.FGResourceSinkSubsystem")
public class FGResourceSinkSubsystem extends SaveActor {

  /**
   * The total number of resource sink points we have accumulated in total
   */
  @SaveProperty("mTotalResourceSinkPoints")
  private long totalResourceSinkPoints;

  /**
   * The current point level we have reached, this value only increases and isn't not affected by printing coupons
   */
  @SaveProperty("mCurrentPointLevel")
  private int currentPointLevel;

  /**
   * The number of coupons we have to our disposal to print and use
   */
  @SaveProperty("mNumResourceSinkCoupons")
  private int numResourceSinkCoupons;

  /**
   * The data for the global points history of the resource sink subsystem
   */
  @SaveProperty("mGlobalPointHistory")
  private List<Integer> globalPointHistory = new ArrayList<>();

  /**
   * The items that the player tried to sink that you can't sink that is also present in mFailedItemSinkMessages
   */
  @SaveProperty("mItemsFailedToSink")
  private List<ObjectReference> itemsFailedToSink = new ArrayList<>();

  /**
   * Have we ever tried to sink any item that you can't sink that is not present in mFailedItemSinkMessages
   */
  @SaveProperty("mAnyGenericItemsFailedToSink")
  private boolean anyGenericItemsFailedToSink;

  /**
   * Have we sunken a item of the coupon class, Used to give a schematic
   */
  @SaveProperty("mIsCouponEverSunk")
  private boolean isCouponEverSunk;

  public long getTotalResourceSinkPoints() {
    return totalResourceSinkPoints;
  }

  public void setTotalResourceSinkPoints(long totalResourceSinkPoints) {
    this.totalResourceSinkPoints = totalResourceSinkPoints;
  }

  public int getCurrentPointLevel() {
    return currentPointLevel;
  }

  public void setCurrentPointLevel(int currentPointLevel) {
    this.currentPointLevel = currentPointLevel;
  }

  public int getNumResourceSinkCoupons() {
    return numResourceSinkCoupons;
  }

  public void setNumResourceSinkCoupons(int numResourceSinkCoupons) {
    this.numResourceSinkCoupons = numResourceSinkCoupons;
  }

  public List<Integer> getGlobalPointHistory() {
    return globalPointHistory;
  }

  public void setGlobalPointHistory(List<Integer> globalPointHistory) {
    this.globalPointHistory = globalPointHistory;
  }

  public List<ObjectReference> getItemsFailedToSink() {
    return itemsFailedToSink;
  }

  public void setItemsFailedToSink(List<ObjectReference> itemsFailedToSink) {
    this.itemsFailedToSink = itemsFailedToSink;
  }

  public boolean isAnyGenericItemsFailedToSink() {
    return anyGenericItemsFailedToSink;
  }

  public void setAnyGenericItemsFailedToSink(boolean anyGenericItemsFailedToSink) {
    this.anyGenericItemsFailedToSink = anyGenericItemsFailedToSink;
  }

  public boolean isIsCouponEverSunk() {
    return isCouponEverSunk;
  }

  public void setIsCouponEverSunk(boolean couponEverSunk) {
    isCouponEverSunk = couponEverSunk;
  }
}
