package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

@SaveObjectClass("/Script/FactoryGame.FGHealthComponent")
public class FGHealthComponent extends SaveComponent {
  @SaveProperty("mMaxHealth")
  private float maxHealth;

  @SaveProperty("mCurrentHealth")
  private float currentHealth;

  @SaveProperty("mRespawnHealthFactor")
  private float respawnHealthFactor;

  @SaveProperty("mIsDead")
  private boolean isDead;

  public float getMaxHealth() {
    return maxHealth;
  }

  public void setMaxHealth(float maxHealth) {
    this.maxHealth = maxHealth;
  }

  public float getCurrentHealth() {
    return currentHealth;
  }

  public void setCurrentHealth(float currentHealth) {
    this.currentHealth = currentHealth;
  }

  public float getRespawnHealthFactor() {
    return respawnHealthFactor;
  }

  public void setRespawnHealthFactor(float respawnHealthFactor) {
    this.respawnHealthFactor = respawnHealthFactor;
  }

  public boolean isDead() {
    return isDead;
  }

  public void setDead(boolean dead) {
    isDead = dead;
  }
}
