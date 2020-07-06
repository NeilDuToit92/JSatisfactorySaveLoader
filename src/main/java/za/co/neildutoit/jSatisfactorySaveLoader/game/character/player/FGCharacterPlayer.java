package za.co.neildutoit.jSatisfactorySaveLoader.game.character.player;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.character.FGCharacterBase;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FVector;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@SaveObjectClass("/Game/FactoryGame/Character/Player/Char_Player.Char_Player_C")
public class FGCharacterPlayer extends FGCharacterBase {

  private final int MAX_SAFE_GROUND_POS_BUFFER_SIZE = 3;

  @SaveProperty("mBuildGun")
  private ObjectReference buildGun;

  @SaveProperty("mResourceScanner")
  private ObjectReference resourceScanner;

  @SaveProperty("mResourceMiner")
  private ObjectReference resourceMiner;

  @SaveProperty("mLastSafeGroundPositions")
  private FVector[] lastSafeGroundPositions = new FVector[MAX_SAFE_GROUND_POS_BUFFER_SIZE];
//  private FVector lastSafeGroundPositions = new FVector();

  @SaveProperty("mLastSafeGroundPositionLoopHead")
  private int lastSafeGroundPositionLoopHead;

  @SaveProperty("mInventory")
  private ObjectReference inventory;

  @SaveProperty("mBeltSlot")
  private ObjectReference beltSlot;

  @SaveProperty("mSavedDrivenVehicle")
  private ObjectReference savedDrivenVehicle;

  @SaveProperty("mFlashlightOn")
  private boolean flashlightOn;

  public ObjectReference getBuildGun() {
    return buildGun;
  }

  public void setBuildGun(ObjectReference buildGun) {
    this.buildGun = buildGun;
  }

  public ObjectReference getResourceScanner() {
    return resourceScanner;
  }

  public void setResourceScanner(ObjectReference resourceScanner) {
    this.resourceScanner = resourceScanner;
  }

  public ObjectReference getResourceMiner() {
    return resourceMiner;
  }

  public void setResourceMiner(ObjectReference resourceMiner) {
    this.resourceMiner = resourceMiner;
  }

//  public FVector[] getLastSafeGroundPositions() {
//    return lastSafeGroundPositions;
//  }
//
//  public void setLastSafeGroundPositions(FVector[] lastSafeGroundPositions) {
//    this.lastSafeGroundPositions = lastSafeGroundPositions;
//  }


  public FVector[] getLastSafeGroundPositions() {
    return lastSafeGroundPositions;
  }

  public void setLastSafeGroundPositions(FVector[] lastSafeGroundPositions) {
    this.lastSafeGroundPositions = lastSafeGroundPositions;
  }

  public int getLastSafeGroundPositionLoopHead() {
    return lastSafeGroundPositionLoopHead;
  }

  public void setLastSafeGroundPositionLoopHead(int lastSafeGroundPositionLoopHead) {
    this.lastSafeGroundPositionLoopHead = lastSafeGroundPositionLoopHead;
  }

  public ObjectReference getInventory() {
    return inventory;
  }

  public void setInventory(ObjectReference inventory) {
    this.inventory = inventory;
  }

  public ObjectReference getBeltSlot() {
    return beltSlot;
  }

  public void setBeltSlot(ObjectReference beltSlot) {
    this.beltSlot = beltSlot;
  }

  public ObjectReference getSavedDrivenVehicle() {
    return savedDrivenVehicle;
  }

  public void setSavedDrivenVehicle(ObjectReference savedDrivenVehicle) {
    this.savedDrivenVehicle = savedDrivenVehicle;
  }

  public boolean isFlashlightOn() {
    return flashlightOn;
  }

  public void setFlashlightOn(boolean flashlightOn) {
    this.flashlightOn = flashlightOn;
  }
}
