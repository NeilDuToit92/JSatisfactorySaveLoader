package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.List;

public class FHotbarsArray extends ObjectReference {

  public FHotbarsArray(String levelName, String pathName) {
    super(levelName, pathName);
  }
  private List<FHotbar> items = new ArrayList<>();

  public List<FHotbar> getItems() {
    return items;
  }

  public void setItems(List<FHotbar> items) {
    this.items = items;
  }
}
