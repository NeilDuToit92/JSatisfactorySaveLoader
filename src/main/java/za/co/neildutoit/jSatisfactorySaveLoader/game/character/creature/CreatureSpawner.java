package za.co.neildutoit.jSatisfactorySaveLoader.game.character.creature;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FSpawnData;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Character/Creature/BP_CreatureSpawner.BP_CreatureSpawner_C")
public class CreatureSpawner extends SaveActor {

  /**
   * Indicates if we have spawned our enemies
   */
  @SaveProperty("mIsActive")
  private boolean isActive;

  /**
   * Structure for keeping all data saved about enemies spawned
   */
  @SaveProperty("mSpawnData")
  private List<FSpawnData> spawnData = new ArrayList<>();

  /**
   * cached value to see if spawner is near a base
   */
  @SaveProperty("mCachedIsNearBase")
  private boolean cachedIsNearBase;

  /**
   * Indicates that this spawner has been deactivated and want to destroy its creatures
   */
  @SaveProperty("mIsPendingDestroy")
  private boolean isPendingDestroy;

  @SaveProperty("mRandomSeed")
  private int randomSeed;

  @SaveProperty("mSpawnerDistance")
  private float spawnerDistance;

  public boolean isIsActive() {
    return isActive;
  }

  public void setIsActive(boolean active) {
    isActive = active;
  }

  public List<FSpawnData> getSpawnData() {
    return spawnData;
  }

  public void setSpawnData(List<FSpawnData> spawnData) {
    this.spawnData = spawnData;
  }

  public boolean isCachedIsNearBase() {
    return cachedIsNearBase;
  }

  public void setCachedIsNearBase(boolean cachedIsNearBase) {
    this.cachedIsNearBase = cachedIsNearBase;
  }

  public boolean isPendingDestroy() {
    return isPendingDestroy;
  }

  public void setPendingDestroy(boolean pendingDestroy) {
    isPendingDestroy = pendingDestroy;
  }

  public int getRandomSeed() {
    return randomSeed;
  }

  public void setRandomSeed(int randomSeed) {
    this.randomSeed = randomSeed;
  }

  public float getSpawnerDistance() {
    return spawnerDistance;
  }

  public void setSpawnerDistance(float spawnerDistance) {
    this.spawnerDistance = spawnerDistance;
  }
}
