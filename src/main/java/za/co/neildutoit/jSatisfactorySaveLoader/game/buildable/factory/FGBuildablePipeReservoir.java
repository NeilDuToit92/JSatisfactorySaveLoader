package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FFluidBox;

/**
 * Pipeline for transferring liquid and gases to factory buildings.
 */
public abstract class FGBuildablePipeReservoir extends FGBuildableFactory {
  /**
   * Fluid box used for flow calculations
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
