package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;


import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_TutorialSubsystem.BP_TutorialSubsystem_C")
public class FGTutorialSubsystem extends SaveComponent {

  /**
   * classes of things we have build
   */
  @SaveProperty("mBuildingsBuilt")
  private List<ObjectReference> buildingsBuilt = new ArrayList<>();

  /**
   * Used to indicate if we should push the intro messages
   */
  @SaveProperty("mHasSeenIntroTutorial")
  private boolean hasSeenIntroTutorial;

  /**
   * Needed to set up delegates
   */
  @SaveProperty("mOwningPlayerState")
  private ObjectReference owningPlayerState;

  public List<ObjectReference> getBuildingsBuilt() {
    return buildingsBuilt;
  }

  public void setBuildingsBuilt(List<ObjectReference> buildingsBuilt) {
    this.buildingsBuilt = buildingsBuilt;
  }

  public boolean isHasSeenIntroTutorial() {
    return hasSeenIntroTutorial;
  }

  public void setHasSeenIntroTutorial(boolean hasSeenIntroTutorial) {
    this.hasSeenIntroTutorial = hasSeenIntroTutorial;
  }

  public ObjectReference getOwningPlayerState() {
    return owningPlayerState;
  }

  public void setOwningPlayerState(ObjectReference owningPlayerState) {
    this.owningPlayerState = owningPlayerState;
  }
}
