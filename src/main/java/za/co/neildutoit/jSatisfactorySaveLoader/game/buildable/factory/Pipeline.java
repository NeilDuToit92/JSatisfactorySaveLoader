package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FFluidBox;

@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/Pipeline/Build_Pipeline.Build_Pipeline_C")
public class Pipeline extends FGBuildablePipeBase {

  /**
   * Simulation data.
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
