package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.List;

public abstract class FGCircuitConnectionComponent extends FGConnectionComponent {
  @SaveProperty("mWires")
  private List<ObjectReference> wires = new ArrayList<>();

  @SaveProperty("mNbWiresConnected")
  private byte nbWiresConnected;

  @SaveProperty("mHiddenConnections")
  private List<ObjectReference> hiddenConnections = new ArrayList<>();

  @SaveProperty("mCircuitID")
  private int circuitID;

  public List<ObjectReference> getWires() {
    return wires;
  }

  public void setWires(List<ObjectReference> wires) {
    this.wires = wires;
  }

  public byte getNbWiresConnected() {
    return nbWiresConnected;
  }

  public void setNbWiresConnected(byte nbWiresConnected) {
    this.nbWiresConnected = nbWiresConnected;
  }

  public List<ObjectReference> getHiddenConnections() {
    return hiddenConnections;
  }

  public void setHiddenConnections(List<ObjectReference> hiddenConnections) {
    this.hiddenConnections = hiddenConnections;
  }

  public int getCircuitID() {
    return circuitID;
  }

  public void setCircuitID(int circuitID) {
    this.circuitID = circuitID;
  }
}
