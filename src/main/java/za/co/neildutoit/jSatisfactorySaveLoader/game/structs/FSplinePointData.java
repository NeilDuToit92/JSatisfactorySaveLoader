package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FVector;

@GameStructAttr("SplinePointData")
public class FSplinePointData extends GameStruct {
//  public override String StructName => "SplinePointData";

  @StructPropertyAttr("Location")
  private FVector location;

  @StructPropertyAttr("ArriveTangent")
  private FVector arriveTangent;

  @StructPropertyAttr("LeaveTangent")
  private FVector leaveTangent;

  public FVector getLocation() {
    return location;
  }

  public void setLocation(FVector location) {
    this.location = location;
  }

  public FVector getArriveTangent() {
    return arriveTangent;
  }

  public void setArriveTangent(FVector arriveTangent) {
    this.arriveTangent = arriveTangent;
  }

  public FVector getLeaveTangent() {
    return leaveTangent;
  }

  public void setLeaveTangent(FVector leaveTangent) {
    this.leaveTangent = leaveTangent;
  }
}
