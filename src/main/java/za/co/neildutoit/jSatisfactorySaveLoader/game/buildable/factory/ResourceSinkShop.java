package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

/**
 * Building where you can buy schematics with coupons
 */
@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/ResourceSinkShop/Build_ResourceSinkShop.Build_ResourceSinkShop_C")
public class ResourceSinkShop extends FGBuildableFactory {
  /**
   * The inventory that holds the purchases we made in the resource sink shop
   */
  @SaveProperty("mShopInventory")
  private ObjectReference shopInventory;

  public ObjectReference getShopInventory() {
    return shopInventory;
  }

  public void setShopInventory(ObjectReference shopInventory) {
    this.shopInventory = shopInventory;
  }
}
