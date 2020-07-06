package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.EGamePhase;

import java.util.ArrayList;
import java.util.List;

@GameStructAttr("PhaseCost")
public class FPhaseCost extends GameStruct {
//  public override String StructName => "PhaseCost";

  @StructPropertyAttr("gamePhase")
  public EGamePhase gamePhase;

  @StructPropertyAttr("Cost")
  public List<FItemAmount> cost = new ArrayList<>();

  public EGamePhase getGamePhase() {
    return gamePhase;
  }

  public void setGamePhase(EGamePhase gamePhase) {
    this.gamePhase = gamePhase;
  }

  public List<FItemAmount> getCost() {
    return cost;
  }

  public void setCost(List<FItemAmount> cost) {
    this.cost = cost;
  }
}
