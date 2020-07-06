package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.List;

public class FBuilding extends GameStruct {
  //  public override String StructName => throw new System.NotImplementedException();
//
  @StructPropertyAttr("Buildables")
  private List<ObjectReference> buildables = new ArrayList<>();

  public List<ObjectReference> getBuildables() {
    return buildables;
  }

  public void setBuildables(List<ObjectReference> buildables) {
    this.buildables = buildables;
  }
}
