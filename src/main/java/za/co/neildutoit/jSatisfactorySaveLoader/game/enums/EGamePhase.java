package za.co.neildutoit.jSatisfactorySaveLoader.game.enums;

import za.co.neildutoit.jSatisfactorySaveLoader.save.EnumAsByte;

public enum EGamePhase implements EnumAsByte {
  EGP_EarlyGame(0),
  EGP_MidGame(1),
  EGP_LateGame(2),
  EGP_EndGame(3),
  EGP_FoodCourt(4),
  @Deprecated
  EGP_LaunchTowTruck(4),
  EGP_Victory(5);

  private int number;


  EGamePhase(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public static EGamePhase getByNumber(int number) {
    for (EGamePhase e : values()) {
      if (e.number == number) {
        return e;
      }
    }
    return null;
  }
}
