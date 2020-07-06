package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

/**
 * Connection used to link pipelines together
 */
@SaveObjectClass("/Script/FactoryGame.FGPipeConnectionComponent")
public class FGPipeConnectionComponent extends FGPipeConnectionComponentBase {
  /**
   * The inventory of this connection. This can be null in many cases.
   */
  @SaveProperty("mConnectionInventory")
  private ObjectReference connectionInventory;

  /**
   * The inventory index utilized by this connection ( -1 for none specified ).
   */
  @SaveProperty("mInventoryAccessIndex")
  private int inventoryAccessIndex;

  /**
   * The network this connection is connected to. INDEX_NONE if not connected.
   */
  @SaveProperty("mPipeNetworkID")
  private int pipeNetworkID;

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

  public int getPipeNetworkID() {
    return pipeNetworkID;
  }

  public void setPipeNetworkID(int pipeNetworkID) {
    this.pipeNetworkID = pipeNetworkID;
  }
}
