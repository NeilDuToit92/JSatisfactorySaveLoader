package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Subsystem to handle all circuits, connects, disconnects.
 */
@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_CircuitSubsystem.BP_CircuitSubsystem_C")
public class CircuitSubsystem extends SaveActor {
   public List<Pair> circuits = new ArrayList<>();

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    int count = reader.readInt32();
    for (int i = 0; i < count; i++)
    {
      circuits.add(new Pair(reader.readInt32(), reader.readObjectReference()));
    }
  }

  public class Pair
  {
    private int circuitID;
    private ObjectReference reference;

    public Pair(int circuitID, ObjectReference reference) {
      this.circuitID = circuitID;
      this.reference = reference;
    }
  }
}
