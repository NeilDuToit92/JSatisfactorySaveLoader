package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;

import java.util.ArrayList;
import java.util.List;

@GameStructAttr("RemovedInstanceArray")
public class FRemovedInstanceArray extends GameStruct {
//  public String STRUCT_NAME = "RemovedInstanceArray";

  @StructPropertyAttr("Items")
  private List<FRemovedInstance> items = new ArrayList<>();

  public List<FRemovedInstance> getItems() {
    return items;
  }

  public void setItems(List<FRemovedInstance> items) {
    this.items = items;
  }
}
