package za.co.neildutoit.jSatisfactorySaveLoader.game.schematics.progression;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FSchematicCost;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Schematics/Progression/BP_SchematicManager.BP_SchematicManager_C")
public class SchematicManager extends SaveActor {
  @SaveProperty("mAvailableSchematics")
  private List<ObjectReference> availableSchematics = new ArrayList<>();

  @SaveProperty("mPurchasedSchematics")
  private List<ObjectReference> purchasedSchematics = new ArrayList<>();

  @SaveProperty("mPaidOffSchematic")
  private List<FSchematicCost> paidOffSchematic = new ArrayList<>();

  @SaveProperty("mActiveSchematic")
  private ObjectReference activeSchematic;

  @SaveProperty("mShipLandTimeStampSave")
  private float shipLandTimeStampSave;

  public List<ObjectReference> getAvailableSchematics() {
    return availableSchematics;
  }

  public void setAvailableSchematics(List<ObjectReference> availableSchematics) {
    this.availableSchematics = availableSchematics;
  }

  public List<ObjectReference> getPurchasedSchematics() {
    return purchasedSchematics;
  }

  public void setPurchasedSchematics(List<ObjectReference> purchasedSchematics) {
    this.purchasedSchematics = purchasedSchematics;
  }

  public List<FSchematicCost> getPaidOffSchematic() {
    return paidOffSchematic;
  }

  public void setPaidOffSchematic(List<FSchematicCost> paidOffSchematic) {
    this.paidOffSchematic = paidOffSchematic;
  }

  public ObjectReference getActiveSchematic() {
    return activeSchematic;
  }

  public void setActiveSchematic(ObjectReference activeSchematic) {
    this.activeSchematic = activeSchematic;
  }

  public float getShipLandTimeStampSave() {
    return shipLandTimeStampSave;
  }

  public void setShipLandTimeStampSave(float shipLandTimeStampSave) {
    this.shipLandTimeStampSave = shipLandTimeStampSave;
  }
}
