package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildablePole extends FGBuildablePoleBase {
  @SaveProperty("mHeight")
  private float height;

  @SaveProperty("mPoleMesh")
  private ObjectReference poleMesh;

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public ObjectReference getPoleMesh() {
    return poleMesh;
  }

  public void setPoleMesh(ObjectReference poleMesh) {
    this.poleMesh = poleMesh;
  }
}
