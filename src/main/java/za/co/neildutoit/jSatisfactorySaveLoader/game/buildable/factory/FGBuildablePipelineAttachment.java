package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FFluidBox;

/**
 * Base for pipe attachments such as pumps and junctions.
 */
public abstract class FGBuildablePipelineAttachment extends FGBuildableFactory {

  /**
   * Fluid box belonging to this integrant
   */
  @SaveProperty("mFluidBox")
  private FFluidBox fluidBox;

  public FFluidBox getFluidBox() {
    return fluidBox;
  }

  public void setFluidBox(FFluidBox fluidBox) {
    this.fluidBox = fluidBox;
  }
}
