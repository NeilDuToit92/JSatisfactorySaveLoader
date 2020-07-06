package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Script/FactoryGame.FGRecipeManager")
public class FGRecipeManager extends SaveActor {
  @SaveProperty("mAvailableRecipes")
  private List<ObjectReference> availableRecipes = new ArrayList<>();

  public List<ObjectReference> getAvailableRecipes() {
    return availableRecipes;
  }

  public void setAvailableRecipes(List<ObjectReference> availableRecipes) {
    this.availableRecipes = availableRecipes;
  }
}
