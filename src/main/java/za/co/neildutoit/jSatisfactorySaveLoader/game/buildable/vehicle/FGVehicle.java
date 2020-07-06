package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.vehicle;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FItemAmount;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FLinearColor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

public abstract class FGVehicle extends SaveActor {
  @SaveProperty("mHealthComponent")
  private ObjectReference healthComponent;

  /**
   * Recipe this building was built with, e.g. used for refunds and stats.
   */
  @SaveProperty("mBuiltWithRecipe")
  private ObjectReference builtWithRecipe;

  @SaveProperty("mDismantleRefund")
  private List<FItemAmount> dismantleRefund = new ArrayList<>();

  /**
   * The primary color of this buildable
   */
  @SaveProperty("mPrimaryColor")
  private FLinearColor PrimaryColor;

  /**
   * The primary color of this buildable
   */
  @SaveProperty("mSecondaryColor")
  private FLinearColor SecondaryColor;

  public ObjectReference getHealthComponent() {
    return healthComponent;
  }

  public void setHealthComponent(ObjectReference healthComponent) {
    this.healthComponent = healthComponent;
  }

  public ObjectReference getBuiltWithRecipe() {
    return builtWithRecipe;
  }

  public void setBuiltWithRecipe(ObjectReference builtWithRecipe) {
    this.builtWithRecipe = builtWithRecipe;
  }

  public List<FItemAmount> getDismantleRefund() {
    return dismantleRefund;
  }

  public void setDismantleRefund(List<FItemAmount> dismantleRefund) {
    this.dismantleRefund = dismantleRefund;
  }

  public FLinearColor getPrimaryColor() {
    return PrimaryColor;
  }

  public void setPrimaryColor(FLinearColor primaryColor) {
    PrimaryColor = primaryColor;
  }

  public FLinearColor getSecondaryColor() {
    return SecondaryColor;
  }

  public void setSecondaryColor(FLinearColor secondaryColor) {
    SecondaryColor = secondaryColor;
  }
}
