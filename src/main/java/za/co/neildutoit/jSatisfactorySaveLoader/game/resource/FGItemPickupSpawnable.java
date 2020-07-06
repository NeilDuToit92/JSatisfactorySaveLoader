package za.co.neildutoit.jSatisfactorySaveLoader.game.resource;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Resource/BP_ItemPickup_Spawnable.BP_ItemPickup_Spawnable_C")
public class FGItemPickupSpawnable extends FGItemPickup {
  @SaveProperty("mPlaySpawnEffect")
  private boolean playSpawnEffect;

  @SaveProperty("mUpdatedOnDayNr")
  private int updatedOnDayNr;

  public boolean isPlaySpawnEffect() {
    return playSpawnEffect;
  }

  public void setPlaySpawnEffect(boolean playSpawnEffect) {
    this.playSpawnEffect = playSpawnEffect;
  }

  public int getUpdatedOnDayNr() {
    return updatedOnDayNr;
  }

  public void setUpdatedOnDayNr(int updatedOnDayNr) {
    this.updatedOnDayNr = updatedOnDayNr;
  }
}
