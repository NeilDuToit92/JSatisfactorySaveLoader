package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Script/FactoryGame.FGMapManager")
public class FGMapManager extends SaveActor {
  @SaveProperty("mFogOfWarRawData")
  private List<Byte> fogOfWarRawData = new ArrayList<>();

  public List<Byte> getFogOfWarRawData() {
    return fogOfWarRawData;
  }

  public void setFogOfWarRawData(List<Byte> fogOfWarRawData) {
    this.fogOfWarRawData = fogOfWarRawData;
  }
}
