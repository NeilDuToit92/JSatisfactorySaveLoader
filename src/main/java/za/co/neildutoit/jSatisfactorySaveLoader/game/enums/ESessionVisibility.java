package za.co.neildutoit.jSatisfactorySaveLoader.game.enums;

public enum ESessionVisibility {

  SV_Private(0),
  SV_FriendsOnly(1),
  SV_Invalid(2);

  private int number;

  ESessionVisibility(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static ESessionVisibility getByNumber(int number) {
    for (ESessionVisibility e : values()) {
      if (e.number == number) {
        return e;
      }
    }
    return null;
  }
}
