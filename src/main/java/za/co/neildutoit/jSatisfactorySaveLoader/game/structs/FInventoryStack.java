package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FInventoryItem;

@GameStructAttr("InventoryStack")
public class FInventoryStack extends GameStruct {
//  public override String StructName => "InventoryStack";

  @StructPropertyAttr("Item")
  private FInventoryItem item;

  @StructPropertyAttr("NumItems")
  private int numItems;

  public FInventoryItem getItem() {
    return item;
  }

  public void setItem(FInventoryItem item) {
    this.item = item;
  }

  public int getNumItems() {
    return numItems;
  }

  public void setNumItems(int numItems) {
    this.numItems = numItems;
  }
}
