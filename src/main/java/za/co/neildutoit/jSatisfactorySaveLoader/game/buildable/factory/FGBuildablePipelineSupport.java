package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;

/**
 * Base class for variable length pipe supports
 */
public abstract class FGBuildablePipelineSupport extends FGBuildablePoleBase {
  /**
   * This supports length.
   */
  @SaveProperty("mLength")
  private float length;

  /**
   * This supports length.
   */
  @SaveProperty("mVerticalAngle")
  private float verticalAngle;

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }

  public float getVerticalAngle() {
    return verticalAngle;
  }

  public void setVerticalAngle(float verticalAngle) {
    this.verticalAngle = verticalAngle;
  }
}
