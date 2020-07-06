package za.co.neildutoit.jSatisfactorySaveLoader.game.character;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

public abstract class FGCharacterBase extends SaveActor {
  @SaveProperty("mHealthComponent")
  private ObjectReference healthComponent;

  public ObjectReference getHealthComponent() {
    return healthComponent;
  }

  public void setHealthComponent(ObjectReference healthComponent) {
    this.healthComponent = healthComponent;
  }
}
