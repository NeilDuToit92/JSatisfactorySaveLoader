package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_GameState.BP_GameState_C")
public class FGGameState extends SaveActor {
  @SaveProperty("mTimeSubsystem")
  private ObjectReference timeSubsystem;

  @SaveProperty("mStorySubsystem")
  private ObjectReference storySubsystem;

  @SaveProperty("mRailroadSubsystem")
  private ObjectReference railroadSubsystem;

  @SaveProperty("mCircuitSubsystem")
  private ObjectReference circuitSubsystem;

  @SaveProperty("mRecipeManager")
  private ObjectReference recipeManager;

  @SaveProperty("mSchematicManager")
  private ObjectReference schematicManager;

  @SaveProperty("mGamePhaseManager")
  private ObjectReference gamePhaseManager;

  @SaveProperty("mResearchManager")
  private ObjectReference researchManager;

  @SaveProperty("mTutorialIntroManager")
  private ObjectReference tutorialIntroManager;

  @SaveProperty("mActorRepresentationManager")
  private ObjectReference actorRepresentationManager;

  @SaveProperty("mMapManager")
  private ObjectReference mapManager;

  @SaveProperty("mPipeSubsystem")
  private ObjectReference pipeSubsystem;

  @SaveProperty("mUnlockSubsystem")
  private ObjectReference unlockSubsystem;

  @SaveProperty("mResourceSinkSubsystem")
  private ObjectReference resourceSinkSubsystem;

  @SaveProperty("mScannableResources")
  private List<ObjectReference> scannableResources = new ArrayList<>();

  /**
   * This array keeps track of what map areas have been visited this game
   */
  @SaveProperty("mVisitedMapAreas")
  private List<ObjectReference> visitedMapAreas = new ArrayList<>();

  /**
   * All items we have picked up that also are relevant to know if we picked up
   */
  @SaveProperty("mPickedUpItems")
  private List<ObjectReference> pickedUpItems = new ArrayList<>();

  /**
   * Cheat boolean for having no cost for stuff
   */
  @SaveProperty("mCheatNoCost")
  private boolean cheatNoCost;

  /**
   * Cheat boolean for not requiring power
   */
  @SaveProperty("mCheatNoPower")
  private boolean cheatNoPower;

  @SaveProperty("mIsMapUnlocked")
  private boolean isMapUnlocked;

  @SaveProperty("mNumAdditionalInventorySlots")
  private int numAdditionalInventorySlots;

  @SaveProperty("mIsBuildingEfficiencyUnlocked")
  private boolean isBuildingEfficiencyUnlocked;

  @SaveProperty("mIsBuildingOverclockUnlocked")
  private boolean isBuildingOverclockUnlocked;

  /**
   * There can only be one trading post in the game, so we keep track it here so that we also can replicate it to client
   */
  @SaveProperty("mIsTradingPostBuilt")
  private boolean isTradingPostBuilt;

  /**
   * The first time you build a trading post we want the landing animation to play
   */
  @SaveProperty("mHasInitalTradingPostLandAnimPlayed")
  private boolean hasInitalTradingPostLandAnimPlayed;

  /**
   * There can only be one space elevator in the game, so we keep track it here so that we also can replicate it to client
   */
  @SaveProperty("mIsSpaceElevatorBuilt")
  private boolean isSpaceElevatorBuilt;

  /**
   * The total play time when loaded this save
   */
  @SaveProperty("mPlayDurationWhenLoaded")
  private int playDurationWhenLoaded;

  @SaveProperty("mReplicatedSessionName")
  private String replicatedSessionName;

  /**
   * Track if a hub part is needed for adding to player inventory when they respawn
   */
  @SaveProperty("mForceAddHubPartOnSpawn")
  private boolean forceAddHubPartOnSpawn;

  @SaveProperty("mNumAdditionalArmEquipmentSlots")
  private int numAdditionalArmEquipmentSlots;

  @SaveProperty("mReplicatedOnlineSessionName")
  private String replicatedOnlineSessionName;

  private List<ObjectReference> playerStates = new ArrayList<>();

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    int count = reader.readInt32();
    for (int i = 0; i < count; i++)
    {
      playerStates.add(reader.readObjectReference());
    }
  }

  public ObjectReference getTimeSubsystem() {
    return timeSubsystem;
  }

  public void setTimeSubsystem(ObjectReference timeSubsystem) {
    this.timeSubsystem = timeSubsystem;
  }

  public ObjectReference getStorySubsystem() {
    return storySubsystem;
  }

  public void setStorySubsystem(ObjectReference storySubsystem) {
    this.storySubsystem = storySubsystem;
  }

  public ObjectReference getRailroadSubsystem() {
    return railroadSubsystem;
  }

  public void setRailroadSubsystem(ObjectReference railroadSubsystem) {
    this.railroadSubsystem = railroadSubsystem;
  }

  public ObjectReference getCircuitSubsystem() {
    return circuitSubsystem;
  }

  public void setCircuitSubsystem(ObjectReference circuitSubsystem) {
    this.circuitSubsystem = circuitSubsystem;
  }

  public ObjectReference getRecipeManager() {
    return recipeManager;
  }

  public void setRecipeManager(ObjectReference recipeManager) {
    this.recipeManager = recipeManager;
  }

  public ObjectReference getSchematicManager() {
    return schematicManager;
  }

  public void setSchematicManager(ObjectReference schematicManager) {
    this.schematicManager = schematicManager;
  }

  public ObjectReference getGamePhaseManager() {
    return gamePhaseManager;
  }

  public void setGamePhaseManager(ObjectReference gamePhaseManager) {
    this.gamePhaseManager = gamePhaseManager;
  }

  public ObjectReference getResearchManager() {
    return researchManager;
  }

  public void setResearchManager(ObjectReference researchManager) {
    this.researchManager = researchManager;
  }

  public ObjectReference getTutorialIntroManager() {
    return tutorialIntroManager;
  }

  public void setTutorialIntroManager(ObjectReference tutorialIntroManager) {
    this.tutorialIntroManager = tutorialIntroManager;
  }

  public ObjectReference getActorRepresentationManager() {
    return actorRepresentationManager;
  }

  public void setActorRepresentationManager(ObjectReference actorRepresentationManager) {
    this.actorRepresentationManager = actorRepresentationManager;
  }

  public ObjectReference getMapManager() {
    return mapManager;
  }

  public void setMapManager(ObjectReference mapManager) {
    this.mapManager = mapManager;
  }

  public ObjectReference getPipeSubsystem() {
    return pipeSubsystem;
  }

  public void setPipeSubsystem(ObjectReference pipeSubsystem) {
    this.pipeSubsystem = pipeSubsystem;
  }

  public ObjectReference getUnlockSubsystem() {
    return unlockSubsystem;
  }

  public void setUnlockSubsystem(ObjectReference unlockSubsystem) {
    this.unlockSubsystem = unlockSubsystem;
  }

  public ObjectReference getResourceSinkSubsystem() {
    return resourceSinkSubsystem;
  }

  public void setResourceSinkSubsystem(ObjectReference resourceSinkSubsystem) {
    this.resourceSinkSubsystem = resourceSinkSubsystem;
  }

  public List<ObjectReference> getScannableResources() {
    return scannableResources;
  }

  public void setScannableResources(List<ObjectReference> scannableResources) {
    this.scannableResources = scannableResources;
  }

  public List<ObjectReference> getVisitedMapAreas() {
    return visitedMapAreas;
  }

  public void setVisitedMapAreas(List<ObjectReference> visitedMapAreas) {
    this.visitedMapAreas = visitedMapAreas;
  }

  public List<ObjectReference> getPickedUpItems() {
    return pickedUpItems;
  }

  public void setPickedUpItems(List<ObjectReference> pickedUpItems) {
    this.pickedUpItems = pickedUpItems;
  }

  public boolean isIsCheatNoCost() {
    return cheatNoCost;
  }

  public void setIsCheatNoCost(boolean cheatNoCost) {
    this.cheatNoCost = cheatNoCost;
  }

  public boolean isIsCheatNoPower() {
    return cheatNoPower;
  }

  public void setIsCheatNoPower(boolean cheatNoPower) {
    this.cheatNoPower = cheatNoPower;
  }

  public boolean isIsMapUnlocked() {
    return isMapUnlocked;
  }

  public void setIsMapUnlocked(boolean mapUnlocked) {
    isMapUnlocked = mapUnlocked;
  }

  public int getNumAdditionalInventorySlots() {
    return numAdditionalInventorySlots;
  }

  public void setNumAdditionalInventorySlots(int numAdditionalInventorySlots) {
    this.numAdditionalInventorySlots = numAdditionalInventorySlots;
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

  public boolean isIsTradingPostBuilt() {
    return isTradingPostBuilt;
  }

  public void setIsTradingPostBuilt(boolean tradingPostBuilt) {
    isTradingPostBuilt = tradingPostBuilt;
  }

  public boolean isHasInitalTradingPostLandAnimPlayed() {
    return hasInitalTradingPostLandAnimPlayed;
  }

  public void setHasInitalTradingPostLandAnimPlayed(boolean hasInitalTradingPostLandAnimPlayed) {
    this.hasInitalTradingPostLandAnimPlayed = hasInitalTradingPostLandAnimPlayed;
  }

  public boolean isIsSpaceElevatorBuilt() {
    return isSpaceElevatorBuilt;
  }

  public void setIsSpaceElevatorBuilt(boolean spaceElevatorBuilt) {
    isSpaceElevatorBuilt = spaceElevatorBuilt;
  }

  public int getPlayDurationWhenLoaded() {
    return playDurationWhenLoaded;
  }

  public void setPlayDurationWhenLoaded(int playDurationWhenLoaded) {
    this.playDurationWhenLoaded = playDurationWhenLoaded;
  }

  public String getReplicatedSessionName() {
    return replicatedSessionName;
  }

  public void setReplicatedSessionName(String replicatedSessionName) {
    this.replicatedSessionName = replicatedSessionName;
  }

  public boolean isIsForceAddHubPartOnSpawn() {
    return forceAddHubPartOnSpawn;
  }

  public void setIsForceAddHubPartOnSpawn(boolean forceAddHubPartOnSpawn) {
    this.forceAddHubPartOnSpawn = forceAddHubPartOnSpawn;
  }

  public int getNumAdditionalArmEquipmentSlots() {
    return numAdditionalArmEquipmentSlots;
  }

  public void setNumAdditionalArmEquipmentSlots(int numAdditionalArmEquipmentSlots) {
    this.numAdditionalArmEquipmentSlots = numAdditionalArmEquipmentSlots;
  }

  public String getReplicatedOnlineSessionName() {
    return replicatedOnlineSessionName;
  }

  public void setReplicatedOnlineSessionName(String replicatedOnlineSessionName) {
    this.replicatedOnlineSessionName = replicatedOnlineSessionName;
  }

  public List<ObjectReference> getPlayerStates() {
    return playerStates;
  }

  public void setPlayerStates(List<ObjectReference> playerStates) {
    this.playerStates = playerStates;
  }
}
