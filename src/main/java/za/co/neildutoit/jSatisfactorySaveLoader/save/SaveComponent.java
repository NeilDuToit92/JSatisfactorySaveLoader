package za.co.neildutoit.jSatisfactorySaveLoader.save;

public class SaveComponent extends SaveObject {
  public SaveObjectKind objectKind = SaveObjectKind.Component;

  private String ParentEntityName;

  @Override
  public SaveObjectKind getObjectKind() {
    return objectKind;
  }

  public void setObjectKind(SaveObjectKind objectKind) {
    this.objectKind = objectKind;
  }

  public String getParentEntityName() {
    return ParentEntityName;
  }

  public void setParentEntityName(String parentEntityName) {
    ParentEntityName = parentEntityName;
  }
}
