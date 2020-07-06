package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;

@GameStructAttr("ItemFoundData")
public class FItemFoundData extends GameStruct {
//  public override String StructName => "ItemFoundData";

  @StructPropertyAttr("WasFound")
  private boolean wasFound;

  public boolean isWasFound() {
    return wasFound;
  }

  public void setWasFound(boolean wasFound) {
    this.wasFound = wasFound;
  }
}
