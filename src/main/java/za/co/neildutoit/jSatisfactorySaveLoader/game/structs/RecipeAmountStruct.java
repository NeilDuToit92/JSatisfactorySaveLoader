package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@GameStructAttr("RecipeAmountStruct")
public class RecipeAmountStruct extends GameStruct {
  //  public override String StructName => "RecipeAmountStruct";
//
//  // TODO: wat
//
  @StructPropertyAttr("Recipe_3_9675A43D4FEC0E33CE84EA9FCEF0E903")
  private ObjectReference recipe;

  @StructPropertyAttr("Amount_6_262F181A4A294617FCD1F496A451BA13")
  private int amount;

  public ObjectReference getRecipe() {
    return recipe;
  }

  public void setRecipe(ObjectReference recipe) {
    this.recipe = recipe;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }
}
