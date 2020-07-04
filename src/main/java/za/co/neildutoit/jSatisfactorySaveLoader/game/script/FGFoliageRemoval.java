package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FRemovedInstanceArray;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.Box;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Script/FactoryGame.FGFoliageRemoval")
public class FGFoliageRemoval extends SaveActor {
  @SaveProperty("mRemovedInstances")
  private FRemovedInstanceArray removedInstances;

  @SaveProperty("mLevelName")
  private String levelName;

  @SaveProperty("mFoliageTypeName")
  private String foliageTypeName;

  @SaveProperty("mLevelBounds")
  private Box levelBounds;

  public FRemovedInstanceArray getRemovedInstances() {
    return removedInstances;
  }

  public void setRemovedInstances(FRemovedInstanceArray removedInstances) {
    this.removedInstances = removedInstances;
  }

  public String getLevelName() {
    return levelName;
  }

  public void setLevelName(String levelName) {
    this.levelName = levelName;
  }

  public String getFoliageTypeName() {
    return foliageTypeName;
  }

  public void setFoliageTypeName(String foliageTypeName) {
    this.foliageTypeName = foliageTypeName;
  }

  public Box getLevelBounds() {
    return levelBounds;
  }

  public void setLevelBounds(Box levelBounds) {
    this.levelBounds = levelBounds;
  }
}
