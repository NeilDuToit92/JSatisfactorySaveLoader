package za.co.neildutoit.jSatisfactorySaveLoader.game.resource;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Resource/BP_ResourceDeposit.BP_ResourceDeposit_C")
public class ResourceDeposit extends FGResourceNode {

  @SaveProperty("mResourceDepositTableIndex")
  private int resourceDepositTableIndex;

  @SaveProperty("mIsEmptied")
  private boolean isEmptied;

  @SaveProperty("mMineAmount")
  private int mineAmount;

  public int getResourceDepositTableIndex() {
    return resourceDepositTableIndex;
  }

  public void setResourceDepositTableIndex(int resourceDepositTableIndex) {
    this.resourceDepositTableIndex = resourceDepositTableIndex;
  }

  public boolean isIsEmptied() {
    return isEmptied;
  }

  public void setIsEmptied(boolean emptied) {
    isEmptied = emptied;
  }

  public int getMineAmount() {
    return mineAmount;
  }

  public void setMineAmount(int mineAmount) {
    this.mineAmount = mineAmount;
  }
}
