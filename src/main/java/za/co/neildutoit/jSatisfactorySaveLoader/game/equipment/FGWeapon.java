package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

public abstract class FGWeapon extends FGEquipment {

  @SaveProperty("mCurrentAmmo")
  private int currentAmmo;

  public int getCurrentAmmo() {
    return currentAmmo;
  }

  public void setCurrentAmmo(int currentAmmo) {
    this.currentAmmo = currentAmmo;
  }
}
