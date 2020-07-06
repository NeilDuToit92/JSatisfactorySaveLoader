package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@GameStructAttr("SplitterSortRule")
public class FSplitterSortRule extends GameStruct {
//  public override String StructName => "SplitterSortRule";

  @StructPropertyAttr("ItemClass")
  private ObjectReference itemClass;

  @StructPropertyAttr("OutputIndex")
  private int outputIndex;

  public ObjectReference getItemClass() {
    return itemClass;
  }

  public void setItemClass(ObjectReference itemClass) {
    this.itemClass = itemClass;
  }

  public int getOutputIndex() {
    return outputIndex;
  }

  public void setOutputIndex(int outputIndex) {
    this.outputIndex = outputIndex;
  }
}
