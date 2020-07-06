package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FItemAmount;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FLinearColor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Base for everything buildable, buildable things can have factory connections, power connections etc.
 */
public class FGBuildable extends SaveActor {
  /**
   * The primary color of this buildable
   */
  @SaveProperty("mPrimaryColor")
  private FLinearColor primaryColor;

  /**
   * The secondary color of this buildable
   */
  @SaveProperty("mSecondaryColor")
  private FLinearColor secondaryColor;

  /**
   * The color slot of this buildable
   */
  @SaveProperty("mColorSlot")
  private byte colorSlot;

  /**
   * If this building should show highlight before first use, save when it has been shown
   */
  @SaveProperty("mDidFirstTimeUse")
  private boolean didFirstTimeUse;

  /**
   * The building ID this belongs to.
   */
  @SaveProperty("mBuildingID")
  private int buildingID;;

  @SaveProperty("mDismantleRefund")
  private List<FItemAmount> dismantleRefund = new ArrayList<>();

  /**
   * Recipe this building was built with, e.g. used for refunds and stats.
   */
  @SaveProperty("mBuiltWithRecipe")
  private ObjectReference builtWithRecipe;

  /**
   * Time when this building was built
   */
  @SaveProperty("mBuildTimeStamp")
  private float buildTimeStamp;

  public FLinearColor getPrimaryColor() {
    return primaryColor;
  }

  public void setPrimaryColor(FLinearColor primaryColor) {
    this.primaryColor = primaryColor;
  }

  public FLinearColor getSecondaryColor() {
    return secondaryColor;
  }

  public void setSecondaryColor(FLinearColor secondaryColor) {
    this.secondaryColor = secondaryColor;
  }

  public byte getColorSlot() {
    return colorSlot;
  }

  public void setColorSlot(byte colorSlot) {
    this.colorSlot = colorSlot;
  }

  public boolean isDidFirstTimeUse() {
    return didFirstTimeUse;
  }

  public void setDidFirstTimeUse(boolean didFirstTimeUse) {
    this.didFirstTimeUse = didFirstTimeUse;
  }

  public int getBuildingID() {
    return buildingID;
  }

  public void setBuildingID(int buildingID) {
    this.buildingID = buildingID;
  }

  public List<FItemAmount> getDismantleRefund() {
    return dismantleRefund;
  }

  public void setDismantleRefund(List<FItemAmount> dismantleRefund) {
    this.dismantleRefund = dismantleRefund;
  }

  public ObjectReference getBuiltWithRecipe() {
    return builtWithRecipe;
  }

  public void setBuiltWithRecipe(ObjectReference builtWithRecipe) {
    this.builtWithRecipe = builtWithRecipe;
  }

  public float getBuildTimeStamp() {
    return buildTimeStamp;
  }

  public void setBuildTimeStamp(float buildTimeStamp) {
    this.buildTimeStamp = buildTimeStamp;
  }
}
