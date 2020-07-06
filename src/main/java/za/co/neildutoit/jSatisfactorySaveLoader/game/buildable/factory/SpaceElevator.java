package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/SpaceElevator/Build_SpaceElevator.Build_SpaceElevator_C")
public class SpaceElevator extends FGBuildableFactory {

  @SaveProperty("mInputInventory")
  private ObjectReference inputInventory;

  public ObjectReference getInputInventory() {
    return inputInventory;
  }

  public void setInputInventory(ObjectReference inputInventory) {
    this.inputInventory = inputInventory;
  }
}
