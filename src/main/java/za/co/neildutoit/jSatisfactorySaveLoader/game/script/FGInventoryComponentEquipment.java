package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@SaveObjectClass("/Script/FactoryGame.FGInventoryComponentEquipment")
public class FGInventoryComponentEquipment extends FGInventoryComponent {
  @SaveProperty("mEquipmentInSlot")
  private ObjectReference equipmentInSlot;

  @SaveProperty("mActiveEquipmentIndex")
  private int activeEquipmentIndex;

  public ObjectReference getEquipmentInSlot() {
    return equipmentInSlot;
  }

  public void setEquipmentInSlot(ObjectReference equipmentInSlot) {
    this.equipmentInSlot = equipmentInSlot;
  }

  public int getActiveEquipmentIndex() {
    return activeEquipmentIndex;
  }

  public void setActiveEquipmentIndex(int activeEquipmentIndex) {
    this.activeEquipmentIndex = activeEquipmentIndex;
  }
}
