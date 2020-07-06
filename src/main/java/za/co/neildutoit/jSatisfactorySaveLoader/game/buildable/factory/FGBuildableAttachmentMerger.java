package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/CA_Merger/Build_ConveyorAttachmentMerger.Build_ConveyorAttachmentMerger_C")
public class FGBuildableAttachmentMerger extends FGBuildableConveyorAttachment {
  @SaveProperty("mCurrentInputIndex")
  private int currentInputIndex;

  @SaveProperty("mCurrentInventoryIndex")
  private int currentInventoryIndex;

  public int getCurrentInputIndex() {
    return currentInputIndex;
  }

  public void setCurrentInputIndex(int currentInputIndex) {
    this.currentInputIndex = currentInputIndex;
  }

  public int getCurrentInventoryIndex() {
    return currentInventoryIndex;
  }

  public void setCurrentInventoryIndex(int currentInventoryIndex) {
    this.currentInventoryIndex = currentInventoryIndex;
  }
}
