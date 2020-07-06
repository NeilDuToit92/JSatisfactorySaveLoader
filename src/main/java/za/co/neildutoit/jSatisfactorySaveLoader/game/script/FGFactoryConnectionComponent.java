package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.EFactoryConnectionDirection;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

/**
 * This component is used on factories to connect to.
 */
@SaveObjectClass("/Script/FactoryGame.FGFactoryConnectionComponent")
public class FGFactoryConnectionComponent extends FGConnectionComponent {

  /**
   * Direction for this connection.
   */
  @SaveProperty("mDirection")
  public EFactoryConnectionDirection direction;

  /**
   *      Connection to another component. If this is set we're connected.
   */
  @SaveProperty("mConnectedComponent")
  public ObjectReference connectedComponent;

  /**
   * The inventory of this connection
   */
  @SaveProperty("mConnectionInventory")
  public ObjectReference connectionInventory;

  /**
   * The inventory index utilized by this connection ( -1 for none specified )
   */
  @SaveProperty("mInventoryAccessIndex")
  public int inventoryAccessIndex;

  public EFactoryConnectionDirection getDirection() {
    return direction;
  }

  public void setDirection(EFactoryConnectionDirection direction) {
    this.direction = direction;
  }

  public ObjectReference getConnectedComponent() {
    return connectedComponent;
  }

  public void setConnectedComponent(ObjectReference connectedComponent) {
    this.connectedComponent = connectedComponent;
  }

  public ObjectReference getConnectionInventory() {
    return connectionInventory;
  }

  public void setConnectionInventory(ObjectReference connectionInventory) {
    this.connectionInventory = connectionInventory;
  }

  public int getInventoryAccessIndex() {
    return inventoryAccessIndex;
  }

  public void setInventoryAccessIndex(int inventoryAccessIndex) {
    this.inventoryAccessIndex = inventoryAccessIndex;
  }
}
