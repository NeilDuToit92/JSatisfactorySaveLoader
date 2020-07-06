package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FTransform;

public class FGBuildableConveyorLift extends FGBuildableConveyorBase {
  @SaveProperty("mTopTransform")
  private FTransform topTransform;

  @SaveProperty("mIsReversed")
  private boolean isReversed;

  public FTransform getTopTransform() {
    return topTransform;
  }

  public void setTopTransform(FTransform topTransform) {
    this.topTransform = topTransform;
  }

  public boolean isIsReversed() {
    return isReversed;
  }

  public void setIsReversed(boolean reversed) {
    isReversed = reversed;
  }
}
