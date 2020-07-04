package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FInventoryItem;

@GameStructAttr("InventoryStack")
public class FInventoryStack extends GameStruct {
//  public override String StructName => "InventoryStack";

  //        [StructProperty("Item")]
  private FInventoryItem item;

  //        [StructProperty("NumItems")]
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
