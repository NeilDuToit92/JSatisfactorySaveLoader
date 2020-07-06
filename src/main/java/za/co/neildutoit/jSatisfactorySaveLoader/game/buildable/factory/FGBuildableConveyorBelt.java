package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FSplinePointData;

import java.util.ArrayList;
import java.util.List;

public class FGBuildableConveyorBelt extends FGBuildableConveyorBase {
  @SaveProperty("mSplineData")
  private List<FSplinePointData> splineData = new ArrayList<>();

  public List<FSplinePointData> getSplineData() {
    return splineData;
  }

  public void setSplineData(List<FSplinePointData> splineData) {
    this.splineData = splineData;
  }
}
