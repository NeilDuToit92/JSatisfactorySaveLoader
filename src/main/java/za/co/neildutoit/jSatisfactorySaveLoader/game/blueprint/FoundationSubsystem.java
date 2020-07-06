package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FBuilding;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.HashMap;
import java.util.Map;

/**
 * Class keeping track of which buildables that for a building.
 */
@SaveObjectClass("/Script/FactoryGame.FGFoundationSubsystem")
public class FoundationSubsystem extends SaveActor {
  /**
   * All the buildings in the game, map with foundation ID and the building struct.
   */
  @SaveProperty("mBuildings")
  private Map<Integer, FBuilding> buildings = new HashMap<>();

  public Map<Integer, FBuilding> getBuildings() {
    return buildings;
  }

  public void setBuildings(Map<Integer, FBuilding> buildings) {
    this.buildings = buildings;
  }
}
