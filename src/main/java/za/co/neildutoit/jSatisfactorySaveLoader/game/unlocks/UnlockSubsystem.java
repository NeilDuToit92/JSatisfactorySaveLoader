package za.co.neildutoit.jSatisfactorySaveLoader.game.unlocks;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsystem responsible for handling unlocks that you get when purchasing/research a schematic
 */
@SaveObjectClass("/Game/FactoryGame/Unlocks/BP_UnlockSubsystem.BP_UnlockSubsystem_C")
public class UnlockSubsystem extends SaveActor {
  /**
   * These are the resources the players can use their scanner to find
   */
  @SaveProperty("mScannableResources")
  private List<ObjectReference> scannableResources = new ArrayList<>();

  /**
   * Did the player unlock the minimap?
   */
  @SaveProperty("mIsMapUnlocked")
  private boolean isMapUnlocked;

  /**
   * Is the building efficiency display unlocked
   */
  @SaveProperty("mIsBuildingEfficiencyUnlocked")
  private boolean isBuildingEfficiencyUnlocked;

  /**
   * Is the building overclocking unlocked
   */
  @SaveProperty("mIsBuildingOverclockUnlocked")
  private boolean isBuildingOverclockUnlocked;

  /**
   * The highest total number of inventory slots that any player have ever had, saved for save compatibility and rebalancing
   */
  @SaveProperty("mNumTotalInventorySlots")
  private int numTotalInventorySlots;

  /**
   *  The highest total number of arm equipment slots that any player have ever had, saved for save compatibility and rebalancing
   */
  @SaveProperty("mNumTotalArmEquipmentSlots")
  private int numTotalArmEquipmentSlots;

  public List<ObjectReference> getScannableResources() {
    return scannableResources;
  }

  public void setScannableResources(List<ObjectReference> scannableResources) {
    this.scannableResources = scannableResources;
  }

  public boolean isIsMapUnlocked() {
    return isMapUnlocked;
  }

  public void setIsMapUnlocked(boolean mapUnlocked) {
    isMapUnlocked = mapUnlocked;
  }

  public boolean isIsBuildingEfficiencyUnlocked() {
    return isBuildingEfficiencyUnlocked;
  }

  public void setIsBuildingEfficiencyUnlocked(boolean buildingEfficiencyUnlocked) {
    isBuildingEfficiencyUnlocked = buildingEfficiencyUnlocked;
  }

  public boolean isIsBuildingOverclockUnlocked() {
    return isBuildingOverclockUnlocked;
  }

  public void setIsBuildingOverclockUnlocked(boolean buildingOverclockUnlocked) {
    isBuildingOverclockUnlocked = buildingOverclockUnlocked;
  }

  public int getNumTotalInventorySlots() {
    return numTotalInventorySlots;
  }

  public void setNumTotalInventorySlots(int numTotalInventorySlots) {
    this.numTotalInventorySlots = numTotalInventorySlots;
  }

  public int getNumTotalArmEquipmentSlots() {
    return numTotalArmEquipmentSlots;
  }

  public void setNumTotalArmEquipmentSlots(int numTotalArmEquipmentSlots) {
    this.numTotalArmEquipmentSlots = numTotalArmEquipmentSlots;
  }
}
