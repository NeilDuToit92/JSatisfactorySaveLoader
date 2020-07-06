package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.vehicle;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Buildable/Vehicle/Golfcart/BP_Golfcart.BP_Golfcart_C")
public class Golfcart extends FGWheeledVehicle {
  @SaveProperty("mIsFoldAnimationDone")
  private boolean isFoldAnimationDone;

  public boolean isIsFoldAnimationDone() {
    return isFoldAnimationDone;
  }

  public void setIsFoldAnimationDone(boolean foldAnimationDone) {
    isFoldAnimationDone = foldAnimationDone;
  }
}
