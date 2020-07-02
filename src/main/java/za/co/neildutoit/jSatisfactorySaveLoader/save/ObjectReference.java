package za.co.neildutoit.jSatisfactorySaveLoader.save;


public class ObjectReference {

  private String levelName;
  private String pathName;

  public ObjectReference(String levelName, String pathName) {
    this.levelName = levelName;
    this.pathName = pathName;
  }

  public String getLevelName() {
    return levelName;
  }

  public void setLevelName(String levelName) {
    this.levelName = levelName;
  }

  public String getPathName() {
    return pathName;
  }

  public void setPathName(String pathName) {
    this.pathName = pathName;
  }
}
