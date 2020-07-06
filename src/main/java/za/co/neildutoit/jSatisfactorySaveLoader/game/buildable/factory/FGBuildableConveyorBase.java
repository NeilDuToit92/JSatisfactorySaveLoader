package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.FGBuildable;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FGBuildableConveyorBase extends FGBuildable {
  public List<FConveyorBeltItem> items = new ArrayList<>();

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    int itemCount = reader.readInt32();
    for (int i = 0; i < itemCount; i++)
    {
      reader.assertNullInt32(); // probably a String
      items.add(new FConveyorBeltItem(reader.readCharArray(), reader.readObjectReference(), reader.readSingle()));
    }
  }
}
