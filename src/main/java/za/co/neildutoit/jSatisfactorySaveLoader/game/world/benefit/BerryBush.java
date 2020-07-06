package za.co.neildutoit.jSatisfactorySaveLoader.game.world.benefit;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/World/Benefit/BerryBush/BP_BerryBush.BP_BerryBush_C")
public class BerryBush extends Bush {

  @SaveProperty("mBerryIndex")
  private int berryIndex;

  public int getBerryIndex() {
    return berryIndex;
  }

  public void setBerryIndex(int berryIndex) {
    this.berryIndex = berryIndex;
  }
}
