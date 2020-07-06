package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

/**
 * Connection base used to link generic pipes together
 */
public class FGPipeConnectionComponentBase extends FGConnectionComponent {
  /**
   * Connection to another component. If this is set we're connected.
   */
  @SaveProperty("mConnectedComponent")
  private ObjectReference connectedComponent;

  public ObjectReference getConnectedComponent() {
    return connectedComponent;
  }

  public void setConnectedComponent(ObjectReference connectedComponent) {
    this.connectedComponent = connectedComponent;
  }
}
