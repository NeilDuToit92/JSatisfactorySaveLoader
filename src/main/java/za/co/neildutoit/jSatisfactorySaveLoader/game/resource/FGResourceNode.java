package za.co.neildutoit.jSatisfactorySaveLoader.game.resource;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Resource/BP_ResourceNode.BP_ResourceNode_C")
public class FGResourceNode extends SaveActor {
  @SaveProperty("mResourcesLeft")
  private int resourcesLeft;

  @SaveProperty("mIsOccupied")
  private boolean isOccupied;

  @SaveProperty("mRevealedOnMapBy")
  private List<ObjectReference> revealedOnMapBy = new ArrayList<>();

  @SaveProperty("mDoSpawnParticle")
  private boolean doSpawnParticle;

  public int getResourcesLeft() {
    return resourcesLeft;
  }

  public void setResourcesLeft(int resourcesLeft) {
    this.resourcesLeft = resourcesLeft;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void setOccupied(boolean occupied) {
    isOccupied = occupied;
  }

  public List<ObjectReference> getRevealedOnMapBy() {
    return revealedOnMapBy;
  }

  public void setRevealedOnMapBy(List<ObjectReference> revealedOnMapBy) {
    this.revealedOnMapBy = revealedOnMapBy;
  }

  public boolean isDoSpawnParticle() {
    return doSpawnParticle;
  }

  public void setDoSpawnParticle(boolean doSpawnParticle) {
    this.doSpawnParticle = doSpawnParticle;
  }
}
