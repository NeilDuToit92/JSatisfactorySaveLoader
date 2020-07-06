package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base for circuit implementations.
 */
public abstract class FGCircuit extends SaveComponent {
  /**
   * The id used to identify this circuit.
   */
  @SaveProperty("mCircuitID")
  private int circuitID;

  /**
   * List of all the components (nodes) in this circuit.
   */
  @SaveProperty("mComponents")
  private List<ObjectReference> components = new ArrayList<>();

  public int getCircuitID() {
    return circuitID;
  }

  public void setCircuitID(int circuitID) {
    this.circuitID = circuitID;
  }

  public List<ObjectReference> getComponents() {
    return components;
  }

  public void setComponents(List<ObjectReference> components) {
    this.components = components;
  }
}
