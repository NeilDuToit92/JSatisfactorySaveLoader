package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

@SaveObjectClass("/Script/FactoryGame.FGPowerInfoComponent")
public class FGPowerInfoComponent extends SaveComponent {
  @SaveProperty("mTargetConsumption")
  private float targetConsumption;

  @SaveProperty("mBaseProduction")
  private float baseProduction;

  @SaveProperty("mDynamicProductionCapacity")
  private float dynamicProductionCapacity;

  public float getTargetConsumption() {
    return targetConsumption;
  }

  public void setTargetConsumption(float targetConsumption) {
    this.targetConsumption = targetConsumption;
  }

  public float getBaseProduction() {
    return baseProduction;
  }

  public void setBaseProduction(float baseProduction) {
    this.baseProduction = baseProduction;
  }

  public float getDynamicProductionCapacity() {
    return dynamicProductionCapacity;
  }

  public void setDynamicProductionCapacity(float dynamicProductionCapacity) {
    this.dynamicProductionCapacity = dynamicProductionCapacity;
  }
}
