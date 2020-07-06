package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.FGBuildable;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FSplinePointData;

import java.util.ArrayList;
import java.util.List;

/**
 * Pipeline for transferring liquid and gases to factory buildings.
 */
public abstract class FGBuildablePipeBase extends FGBuildable {
  @SaveProperty("mSplineData")
  private List<FSplinePointData> splineData = new ArrayList<>();

  public List<FSplinePointData> getSplineData() {
    return splineData;
  }

  public void setSplineData(List<FSplinePointData> splineData) {
    this.splineData = splineData;
  }
}
