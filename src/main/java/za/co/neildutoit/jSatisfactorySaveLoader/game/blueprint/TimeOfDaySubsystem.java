package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_TimeOfDaySubsystem.BP_TimeOfDaySubsystem_C")
public class TimeOfDaySubsystem extends SaveActor {
  /**
   * How many seconds that has passed into our current day
   */
  @SaveProperty("mDaySeconds")
  private float daySeconds;

  /**
   * The current day that has passed
   */
  @SaveProperty("mNumberOfPassedDays")
  private int numberOfPassedDays;

  public float getDaySeconds() {
    return daySeconds;
  }

  public void setDaySeconds(float daySeconds) {
    this.daySeconds = daySeconds;
  }

  public int getNumberOfPassedDays() {
    return numberOfPassedDays;
  }

  public void setNumberOfPassedDays(int numberOfPassedDays) {
    this.numberOfPassedDays = numberOfPassedDays;
  }
}
