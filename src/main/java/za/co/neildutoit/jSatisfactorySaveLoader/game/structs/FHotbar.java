package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;

@GameStructAttr("Hotbar")
public class FHotbar extends GameStruct
{
//  public override String StructName => "Hotbar";

  @StructPropertyAttr("HotbarShortcuts")
  //TODO: @NDT: What must this be??
  private Object hotbarShortcuts;

  public Object getHotbarShortcuts() {
    return hotbarShortcuts;
  }

  public void setHotbarShortcuts(Object hotbarShortcuts) {
    this.hotbarShortcuts = hotbarShortcuts;
  }
}
