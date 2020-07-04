package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions;

import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.GameStruct;

public interface IStructPropertyValue {
  GameStruct getData();
  void setData(GameStruct gameStruct);
}
