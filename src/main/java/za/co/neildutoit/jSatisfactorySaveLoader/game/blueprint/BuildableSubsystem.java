package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;


import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FColor;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FLinearColor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsystem responsible for spawning and maintaining buildables.
 */
@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_BuildableSubsystem.BP_BuildableSubsystem_C")
public class BuildableSubsystem extends SaveActor {
  public final int BUILDABLE_COLORS_MAX_SLOTS = 16;

/**
 * DEPRECATED - Use Linear Color instead
 */
  @SaveProperty("mColorSlotsPrimary")
  @Deprecated
  private FColor[] colorSlotsPrimary;

  /**
   * DEPRECATED - Use Linear Color instead
   */
  @SaveProperty("mColorSlotsSecondary")
  @Deprecated
  private FColor[] colorSlotsSecondary;

  @SaveProperty("mColorSlotsPrimary_Linear")
  private List<FLinearColor> ColorSlotsPrimary_Linear = new ArrayList<>();

  @SaveProperty("mColorSlotsSecondary_Linear")
  private List<FLinearColor> colorSlotsSecondary_Linear = new ArrayList<>();

  public FColor[] getColorSlotsPrimary() {
    return colorSlotsPrimary;
  }

  public void setColorSlotsPrimary(FColor[] colorSlotsPrimary) {
    this.colorSlotsPrimary = colorSlotsPrimary;
  }

  public FColor[] getColorSlotsSecondary() {
    return colorSlotsSecondary;
  }

  public void setColorSlotsSecondary(FColor[] colorSlotsSecondary) {
    this.colorSlotsSecondary = colorSlotsSecondary;
  }

  public List<FLinearColor> getColorSlotsPrimary_Linear() {
    return ColorSlotsPrimary_Linear;
  }

  public void setColorSlotsPrimary_Linear(List<FLinearColor> colorSlotsPrimary_Linear) {
    ColorSlotsPrimary_Linear = colorSlotsPrimary_Linear;
  }

  public List<FLinearColor> getColorSlotsSecondary_Linear() {
    return colorSlotsSecondary_Linear;
  }

  public void setColorSlotsSecondary_Linear(List<FLinearColor> colorSlotsSecondary_Linear) {
    this.colorSlotsSecondary_Linear = colorSlotsSecondary_Linear;
  }
}
