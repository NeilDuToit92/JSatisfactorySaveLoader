package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@GameStructAttr("ItemAmount")
public class FItemAmount extends GameStruct {
//  public override String StructName => "ItemAmount";

  @StructPropertyAttr("ItemClass")
  private ObjectReference itemClass;

  @StructPropertyAttr("amount")
  private int amount;

  public ObjectReference getItemClass() {
    return itemClass;
  }

  public void setItemClass(ObjectReference itemClass) {
    this.itemClass = itemClass;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
