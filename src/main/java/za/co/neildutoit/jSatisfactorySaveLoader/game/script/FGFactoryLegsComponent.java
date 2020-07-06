package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FFeetOffset;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Script/FactoryGame.FGFactoryLegsComponent")
public class FGFactoryLegsComponent extends SaveComponent {
  @SaveProperty("mCachedFeetOffset")
  private List<FFeetOffset> cachedFeetOffset = new ArrayList<>();

  public List<FFeetOffset> getCachedFeetOffset() {
    return cachedFeetOffset;
  }

  public void setCachedFeetOffset(List<FFeetOffset> cachedFeetOffset) {
    this.cachedFeetOffset = cachedFeetOffset;
  }
}
