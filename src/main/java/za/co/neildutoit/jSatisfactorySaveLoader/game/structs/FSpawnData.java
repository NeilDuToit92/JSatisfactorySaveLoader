package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FVector;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@GameStructAttr("SpawnData")
public class FSpawnData extends GameStruct {
//  public override String StructName => "SpawnData";

  //        [StructProperty("SpawnLocation")]
  private FVector spawnLocation;

  //        [StructProperty("Creature")]
  private ObjectReference creature;

  //        [StructProperty("WasKilled")]
  private boolean wasKilled;

  //        [StructProperty("KilledOnDayNr")]
  private int killedOnDayNr;

  //        [StructProperty("CreatureClassOverride")]
  private ObjectReference creatureClassOverride;

  //        [StructProperty("SpawnWeight")]
  private float spawnWeight;

  public FVector getSpawnLocation() {
    return spawnLocation;
  }

  public void setSpawnLocation(FVector spawnLocation) {
    this.spawnLocation = spawnLocation;
  }

  public ObjectReference getCreature() {
    return creature;
  }

  public void setCreature(ObjectReference creature) {
    this.creature = creature;
  }

  public boolean isWasKilled() {
    return wasKilled;
  }

  public void setWasKilled(boolean wasKilled) {
    this.wasKilled = wasKilled;
  }

  public int getKilledOnDayNr() {
    return killedOnDayNr;
  }

  public void setKilledOnDayNr(int killedOnDayNr) {
    this.killedOnDayNr = killedOnDayNr;
  }

  public ObjectReference getCreatureClassOverride() {
    return creatureClassOverride;
  }

  public void setCreatureClassOverride(ObjectReference creatureClassOverride) {
    this.creatureClassOverride = creatureClassOverride;
  }

  public float getSpawnWeight() {
    return spawnWeight;
  }

  public void setSpawnWeight(float spawnWeight) {
    this.spawnWeight = spawnWeight;
  }
}
