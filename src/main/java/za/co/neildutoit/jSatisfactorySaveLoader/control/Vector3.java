package za.co.neildutoit.jSatisfactorySaveLoader.control;

public class Vector3 {
  private float x;
  private float y;
  private float z;

  public Vector3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public float getX() {
    return x;
  }

  public void setX(float x) {
    this.x = x;
  }

  public float getY() {
    return y;
  }

  public void setY(float y) {
    this.y = y;
  }

  public float getZ() {
    return z;
  }

  public void setZ(float z) {
    this.z = z;
  }

  public boolean isSuspicious()
  {
    return (x > 0 && x < 1E-8) || (y > 0 && y < 1E-8) || (z > 0 && z < 1E-8);
  }
}
