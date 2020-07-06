package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FInventoryStack;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Script/FactoryGame.FGInventoryComponent")
public class FGInventoryComponent extends SaveComponent {
  @SaveProperty("mAdjustedSizeDiff")
  private int adjustedSizeDiff;

  @SaveProperty("mInventoryStacks")
  private List<FInventoryStack> inventoryStacks = new ArrayList<>();

  @SaveProperty("mArbitrarySlotSizes")
  private List<Integer> arbitrarySlotSizes = new ArrayList<>();

  @SaveProperty("mAllowedItemDescriptors")
  private List<ObjectReference> allowedItemDescriptors = new ArrayList<>();

  @SaveProperty("mCanBeRearrange")
  private boolean canBeRearrange;

  public FGInventoryComponent() {
    super();
  }

  public int getAdjustedSizeDiff() {
    return adjustedSizeDiff;
  }

  public void setAdjustedSizeDiff(int adjustedSizeDiff) {
    this.adjustedSizeDiff = adjustedSizeDiff;
  }

  public List<FInventoryStack> getInventoryStacks() {
    return inventoryStacks;
  }

  public void setInventoryStacks(List<FInventoryStack> inventoryStacks) {
    this.inventoryStacks = inventoryStacks;
  }

  public List<Integer> getArbitrarySlotSizes() {
    return arbitrarySlotSizes;
  }

  public void setArbitrarySlotSizes(List<Integer> arbitrarySlotSizes) {
    this.arbitrarySlotSizes = arbitrarySlotSizes;
  }

  public List<ObjectReference> getAllowedItemDescriptors() {
    return allowedItemDescriptors;
  }

  public void setAllowedItemDescriptors(List<ObjectReference> allowedItemDescriptors) {
    this.allowedItemDescriptors = allowedItemDescriptors;
  }

  public boolean isCanBeRearrange() {
    return canBeRearrange;
  }

  public void setCanBeRearrange(boolean canBeRearrange) {
    this.canBeRearrange = canBeRearrange;
  }
}
