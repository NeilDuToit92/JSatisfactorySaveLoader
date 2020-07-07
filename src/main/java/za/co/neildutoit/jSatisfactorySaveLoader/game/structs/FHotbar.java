package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues.IArrayElement;

import java.util.ArrayList;
import java.util.List;

@GameStructAttr("Hotbar")
public class FHotbar extends GameStruct
{
//  public override String StructName => "Hotbar";

  @StructPropertyAttr("HotbarShortcuts")
  private List<IArrayElement> hotbarShortcuts = new ArrayList<>();

  public List<IArrayElement> getHotbarShortcuts() {
    return hotbarShortcuts;
  }

  public void setHotbarShortcuts(List<IArrayElement> hotbarShortcuts) {
    this.hotbarShortcuts = hotbarShortcuts;
  }
}
