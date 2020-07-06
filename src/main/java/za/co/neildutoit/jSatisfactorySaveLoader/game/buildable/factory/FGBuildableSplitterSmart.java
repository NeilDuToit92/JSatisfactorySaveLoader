package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FSplitterSortRule;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FInventoryItem;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class FGBuildableSplitterSmart extends FGBuildableAttachmentSplitter {
  @SaveProperty("mSortRules")
  private List<FSplitterSortRule> sortRules = new ArrayList<>();

  @SaveProperty("mLastItem")
  private FInventoryItem lastItem;

  @SaveProperty("mItemToLastOutputMap")
  private Map<ObjectReference, Byte> itemToLastOutputMap = new HashMap<>();

  @SaveProperty("mLastOutputIndex")
  private int lastOutputIndex;

  public List<FSplitterSortRule> getSortRules() {
    return sortRules;
  }

  public void setSortRules(List<FSplitterSortRule> sortRules) {
    this.sortRules = sortRules;
  }

  public FInventoryItem getLastItem() {
    return lastItem;
  }

  public void setLastItem(FInventoryItem lastItem) {
    this.lastItem = lastItem;
  }

  public Map<ObjectReference, Byte> getItemToLastOutputMap() {
    return itemToLastOutputMap;
  }

  public void setItemToLastOutputMap(Map<ObjectReference, Byte> itemToLastOutputMap) {
    this.itemToLastOutputMap = itemToLastOutputMap;
  }

  public int getLastOutputIndex() {
    return lastOutputIndex;
  }

  public void setLastOutputIndex(int lastOutputIndex) {
    this.lastOutputIndex = lastOutputIndex;
  }
}
