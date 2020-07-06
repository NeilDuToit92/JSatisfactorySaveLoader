package za.co.neildutoit.jSatisfactorySaveLoader.game.schematics.progression;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.EGamePhase;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FPhaseCost;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Schematics/Progression/BP_GamePhaseManager.BP_GamePhaseManager_C")
public class GamePhaseManager extends SaveActor {

  @SaveProperty("mGamePhase")
  private EGamePhase gamePhase;

  @SaveProperty("mGamePhaseCosts")
  private List<FPhaseCost> gamePhaseCosts = new ArrayList<>();

  public EGamePhase getGamePhase() {
    return gamePhase;
  }

  public void setGamePhase(EGamePhase gamePhase) {
    this.gamePhase = gamePhase;
  }

  public List<FPhaseCost> getGamePhaseCosts() {
    return gamePhaseCosts;
  }

  public void setGamePhaseCosts(List<FPhaseCost> gamePhaseCosts) {
    this.gamePhaseCosts = gamePhaseCosts;
  }
}
