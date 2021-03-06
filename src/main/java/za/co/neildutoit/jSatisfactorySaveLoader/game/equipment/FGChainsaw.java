package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Equipment/Chainsaw/Equip_Chainsaw.Equip_Chainsaw_C")
public class FGChainsaw extends FGEquipment {
  @SaveProperty("mEnergyStored")
  private float energyStored;

  public float getEnergyStored() {
    return energyStored;
  }

  public void setEnergyStored(float energyStored) {
    this.energyStored = energyStored;
  }
}
