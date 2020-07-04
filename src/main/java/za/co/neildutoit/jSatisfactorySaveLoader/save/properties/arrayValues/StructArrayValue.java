package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.IStructPropertyValue;

public class StructArrayValue implements IStructPropertyValue, IArrayElement {
//  public Type BackingType => Data.GetType();

  private GameStruct data;

  @Override
  public GameStruct getData() {
    return data;
  }

  @Override
  public void setData(GameStruct data) {
    this.data = data;
  }

//  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
