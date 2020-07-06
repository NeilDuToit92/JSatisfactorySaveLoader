package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FItemFoundData;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_StorySubsystem.BP_StorySubsystem_C")
public class StorySubsystem extends SaveActor {
  /**
   * array of item descriptor class/message and if they have been found already
   */
  @SaveProperty("mItemFoundData")
  private List<FItemFoundData> itemFoundData = new ArrayList<>();

  public List<FItemFoundData> getItemFoundData() {
    return itemFoundData;
  }

  public void setItemFoundData(List<FItemFoundData> itemFoundData) {
    this.itemFoundData = itemFoundData;
  }
}
