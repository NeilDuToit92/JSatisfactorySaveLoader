package za.co.neildutoit.jSatisfactorySaveLoader.save;

public enum SaveObjectKind {
  Component(0),
  Actor(1);

  private int number;

  SaveObjectKind(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static SaveObjectKind getByNumber(int number) {
    for (SaveObjectKind e : values()) {
      if (e.number == number) {
        return e;
      }
    }
    return null;
  }
}
