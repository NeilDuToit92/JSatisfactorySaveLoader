package za.co.neildutoit.jSatisfactorySaveLoader.game.world.benefit;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.resource.FGItemPickup;

public class Bush extends FGItemPickup {
  @SaveProperty("mSavedNumItems")
  private int savedNumItems;

  @SaveProperty("mNumRespawns")
  private int numRespawns;

  public int getSavedNumItems() {
    return savedNumItems;
  }

  public void setSavedNumItems(int savedNumItems) {
    this.savedNumItems = savedNumItems;
  }

  public int getNumRespawns() {
    return numRespawns;
  }

  public void setNumRespawns(int numRespawns) {
    this.numRespawns = numRespawns;
  }
}
