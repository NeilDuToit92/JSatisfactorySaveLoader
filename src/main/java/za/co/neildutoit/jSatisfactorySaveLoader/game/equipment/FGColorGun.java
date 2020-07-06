package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Equipment/ColorGun/Equip_ColorGun.Equip_ColorGun_C")
public class FGColorGun extends FGWeaponInstantFire {
  @SaveProperty("mColorSlot")
  private byte colorSlot;

  public byte getColorSlot() {
    return colorSlot;
  }

  public void setColorSlot(byte colorSlot) {
    this.colorSlot = colorSlot;
  }
}
