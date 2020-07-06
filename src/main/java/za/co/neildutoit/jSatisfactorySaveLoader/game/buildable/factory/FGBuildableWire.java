package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.FGBuildable;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

public abstract class FGBuildableWire extends FGBuildable {
  private ObjectReference nextConnection;
  private ObjectReference previousConnection;

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    setNextConnection(reader.readObjectReference());
    setPreviousConnection(reader.readObjectReference());
  }

  public ObjectReference getNextConnection() {
    return nextConnection;
  }

  public void setNextConnection(ObjectReference nextConnection) {
    this.nextConnection = nextConnection;
  }

  public ObjectReference getPreviousConnection() {
    return previousConnection;
  }

  public void setPreviousConnection(ObjectReference previousConnection) {
    this.previousConnection = previousConnection;
  }
}
