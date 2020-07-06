package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/CA_Splitter/Build_ConveyorAttachmentSplitter.Build_ConveyorAttachmentSplitter_C")
public class FGBuildableAttachmentSplitter extends FGBuildableConveyorAttachment {
  @SaveProperty("mCurrentOutputIndex")
  private int currentOutputIndex;

  @SaveProperty("mCurrentInventoryIndex")
  private int currentInventoryIndex;

  public int getCurrentOutputIndex() {
    return currentOutputIndex;
  }

  public void setCurrentOutputIndex(int currentOutputIndex) {
    this.currentOutputIndex = currentOutputIndex;
  }

  public int getCurrentInventoryIndex() {
    return currentInventoryIndex;
  }

  public void setCurrentInventoryIndex(int currentInventoryIndex) {
    this.currentInventoryIndex = currentInventoryIndex;
  }
}
