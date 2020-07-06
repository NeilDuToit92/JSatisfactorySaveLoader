package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FLinearColor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.TextEntry;

@SaveObjectClass("/Game/FactoryGame/Equipment/Beacon/BP_Beacon.BP_Beacon_C")
public class Beacon extends FGConsumableEquipment {
  @SaveProperty("mCompassText")
  private TextEntry compassText;

  @SaveProperty("mCompassColor")
  private FLinearColor compassColor;

  public TextEntry getCompassText() {
    return compassText;
  }

  public void setCompassText(TextEntry compassText) {
    this.compassText = compassText;
  }

  public FLinearColor getCompassColor() {
    return compassColor;
  }

  public void setCompassColor(FLinearColor compassColor) {
    this.compassColor = compassColor;
  }
}
