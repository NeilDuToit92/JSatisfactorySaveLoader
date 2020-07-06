package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveComponent;

@SaveObjectClass("/Script/FactoryGame.FGRecipeShortcut")
public class FGRecipeShortcut extends SaveComponent {
  @SaveProperty("mRecipeToActivate")
  private ObjectReference recipeToActivate;

  public ObjectReference getRecipeToActivate() {
    return recipeToActivate;
  }

  public void setRecipeToActivate(ObjectReference recipeToActivate) {
    this.recipeToActivate = recipeToActivate;
  }
}
