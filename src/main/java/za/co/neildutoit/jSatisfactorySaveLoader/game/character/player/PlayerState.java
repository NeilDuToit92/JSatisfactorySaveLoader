package za.co.neildutoit.jSatisfactorySaveLoader.game.character.player;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.ERepresentationType;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FHotbarsArray;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FMessageData;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FRemovedInstanceArray;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.RecipeAmountStruct;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Character/Player/BP_PlayerState.BP_PlayerState_C")
public class PlayerState extends SaveActor {

  //    private static readonly Logger log = LogManager.GetCurrentClassLogger();
//
  @SaveProperty("mHotbarShortcuts")
  private List<ObjectReference> hotbarShortcuts = new ArrayList<>();

  @SaveProperty("mHotbars")
  private FHotbarsArray hotBars;

  @SaveProperty("mNewRecipes")
  private List<ObjectReference> newRecipes = new ArrayList<>();

  @SaveProperty("mOwnedPawn")
  private ObjectReference ownedPawn;

  @SaveProperty("mHasReceivedInitialItems")
  private boolean hasReceivedInitialItems;

  @SaveProperty("mHasSetupDefaultShortcuts")
  private boolean hasSetupDefaultShortcuts;

  @SaveProperty("mTutorialSubsystem")
  private ObjectReference tutorialSubsystem;

  @SaveProperty("mMessageData")
  private List<FMessageData> messageData = new ArrayList<>();

  @SaveProperty("mRememberedFirstTimeEquipmentClasses")
  private List<ObjectReference> rememberedFirstTimeEquipmentClasses = new ArrayList<>();

  @SaveProperty("mNumArmSlots")
  private int numArmSlots;

  @SaveProperty("mOnlyShowAffordableRecipes")
  private boolean onlyShowAffordableRecipes;

  @SaveProperty("mCollapsedItemCategories")
  private List<ObjectReference> collapsedItemCategories = new ArrayList<>();

  @SaveProperty("mFilteredOutMapTypes")
  private List<ERepresentationType> filteredOutMapTypes = new ArrayList<>();

  @SaveProperty("mFilteredOutCompassTypes")
  private List<ERepresentationType> filteredOutCompassTypes = new ArrayList<>();

  @SaveProperty("mShoppingList")
  private List<RecipeAmountStruct> shoppingList = new ArrayList<>();

  @SaveProperty("mLastSchematicTierInUI")
  private int lastSchematicTierInUI;

  private byte[] userID;

  public List<ObjectReference> getHotbarShortcuts() {
    return hotbarShortcuts;
  }

  public void setHotbarShortcuts(List<ObjectReference> hotbarShortcuts) {
    this.hotbarShortcuts = hotbarShortcuts;
  }

  public FHotbarsArray getHotBars() {
    return hotBars;
  }

  public void setHotBars(FHotbarsArray hotBars) {
    this.hotBars = hotBars;
  }

  public List<ObjectReference> getNewRecipes() {
    return newRecipes;
  }

  public void setNewRecipes(List<ObjectReference> newRecipes) {
    this.newRecipes = newRecipes;
  }

  public ObjectReference getOwnedPawn() {
    return ownedPawn;
  }

  public void setOwnedPawn(ObjectReference ownedPawn) {
    this.ownedPawn = ownedPawn;
  }

  public boolean isHasReceivedInitialItems() {
    return hasReceivedInitialItems;
  }

  public void setHasReceivedInitialItems(boolean hasReceivedInitialItems) {
    this.hasReceivedInitialItems = hasReceivedInitialItems;
  }

  public boolean isHasSetupDefaultShortcuts() {
    return hasSetupDefaultShortcuts;
  }

  public void setHasSetupDefaultShortcuts(boolean hasSetupDefaultShortcuts) {
    this.hasSetupDefaultShortcuts = hasSetupDefaultShortcuts;
  }

  public ObjectReference getTutorialSubsystem() {
    return tutorialSubsystem;
  }

  public void setTutorialSubsystem(ObjectReference tutorialSubsystem) {
    this.tutorialSubsystem = tutorialSubsystem;
  }

  public List<FMessageData> getMessageData() {
    return messageData;
  }

  public void setMessageData(List<FMessageData> messageData) {
    this.messageData = messageData;
  }

  public List<ObjectReference> getRememberedFirstTimeEquipmentClasses() {
    return rememberedFirstTimeEquipmentClasses;
  }

  public void setRememberedFirstTimeEquipmentClasses(List<ObjectReference> rememberedFirstTimeEquipmentClasses) {
    this.rememberedFirstTimeEquipmentClasses = rememberedFirstTimeEquipmentClasses;
  }

  public int getNumArmSlots() {
    return numArmSlots;
  }

  public void setNumArmSlots(int numArmSlots) {
    this.numArmSlots = numArmSlots;
  }

  public boolean isOnlyShowAffordableRecipes() {
    return onlyShowAffordableRecipes;
  }

  public void setOnlyShowAffordableRecipes(boolean onlyShowAffordableRecipes) {
    this.onlyShowAffordableRecipes = onlyShowAffordableRecipes;
  }

  public List<ObjectReference> getCollapsedItemCategories() {
    return collapsedItemCategories;
  }

  public void setCollapsedItemCategories(List<ObjectReference> collapsedItemCategories) {
    this.collapsedItemCategories = collapsedItemCategories;
  }

  public List<ERepresentationType> getFilteredOutMapTypes() {
    return filteredOutMapTypes;
  }

  public void setFilteredOutMapTypes(List<ERepresentationType> filteredOutMapTypes) {
    this.filteredOutMapTypes = filteredOutMapTypes;
  }

  public List<ERepresentationType> getFilteredOutCompassTypes() {
    return filteredOutCompassTypes;
  }

  public void setFilteredOutCompassTypes(List<ERepresentationType> filteredOutCompassTypes) {
    this.filteredOutCompassTypes = filteredOutCompassTypes;
  }

  public List<RecipeAmountStruct> getShoppingList() {
    return shoppingList;
  }

  public void setShoppingList(List<RecipeAmountStruct> shoppingList) {
    this.shoppingList = shoppingList;
  }

  public int getLastSchematicTierInUI() {
    return lastSchematicTierInUI;
  }

  public void setLastSchematicTierInUI(int lastSchematicTierInUI) {
    this.lastSchematicTierInUI = lastSchematicTierInUI;
  }

  public byte[] getUserID() {
    return userID;
  }

  public void setUserID(byte[] userID) {
    this.userID = userID;
  }

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
//      if (length != 18)
//        log.Warn($"Expected to read 18 bytes for PlayerState native data but got {length} bytes");

    setUserID(reader.readBytes(length));
  }
}
