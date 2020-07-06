package za.co.neildutoit.jSatisfactorySaveLoader.game.character.creature;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.character.FGCharacterBase;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGCreature extends FGCharacterBase {
  @SaveProperty("mSpline")
  private ObjectReference spline;

  @SaveProperty("mIsPersistent")
  private boolean isPersistent;

  public ObjectReference getSpline() {
    return spline;
  }

  public void setSpline(ObjectReference spline) {
    this.spline = spline;
  }

  public boolean isPersistent() {
    return isPersistent;
  }

  public void setPersistent(boolean persistent) {
    isPersistent = persistent;
  }
}
