package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

public abstract class FGWeaponInstantFire extends FGWeapon {
  @SaveProperty("mHasReloadedOnce")
  private boolean hasReloadedOnce;

  public boolean isHasReloadedOnce() {
    return hasReloadedOnce;
  }

  public void setHasReloadedOnce(boolean hasReloadedOnce) {
    this.hasReloadedOnce = hasReloadedOnce;
  }
}
