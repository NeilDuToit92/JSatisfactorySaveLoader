package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Script/FactoryGame.FGWorldSettings")
public class FGWorldSettings extends SaveActor {

  @SaveProperty("mBuildableSubsystem")
  private ObjectReference buildableSubsystem;

  @SaveProperty("mFoundationSubsystem")
  private ObjectReference foundationSubsystem;

  public ObjectReference getBuildableSubsystem() {
    return buildableSubsystem;
  }

  public void setBuildableSubsystem(ObjectReference buildableSubsystem) {
    this.buildableSubsystem = buildableSubsystem;
  }

  public ObjectReference getFoundationSubsystem() {
    return foundationSubsystem;
  }

  public void setFoundationSubsystem(ObjectReference foundationSubsystem) {
    this.foundationSubsystem = foundationSubsystem;
  }
}
