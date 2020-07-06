package za.co.neildutoit.jSatisfactorySaveLoader.game.character.creature.enemy;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@SaveObjectClass("/Game/FactoryGame/Character/Creature/Enemy/CrabHatcher/Char_CrabHatcher.Char_CrabHatcher_C")
public class CrabHatcher extends FGEnemy {
  @SaveProperty("mOwningSpawner")
  private ObjectReference owningSpawner;

  public ObjectReference getOwningSpawner() {
    return owningSpawner;
  }

  public void setOwningSpawner(ObjectReference owningSpawner) {
    this.owningSpawner = owningSpawner;
  }
}
