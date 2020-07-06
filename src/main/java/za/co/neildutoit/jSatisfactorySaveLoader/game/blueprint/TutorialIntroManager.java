package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.EIntroTutorialSteps;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_TutorialIntroManager.BP_TutorialIntroManager_C")
public class TutorialIntroManager extends SaveActor {

  @SaveProperty("mTradingPostBuilt")
  private boolean tradingPostBuilt;

  /**
   * Array of pending tutorial IDs that should be shown when possible ( no other widgets on screen etc )
   */
  @SaveProperty("mPendingTutorial")
  private EIntroTutorialSteps pendingTutorial;

  /**
   * Indicates if the player has completed the introduction tutorial
   */
  @SaveProperty("mHasCompletedIntroTutorial")
  private boolean hasCompletedIntroTutorial;

  /**
   * Indicates that the introduction sequence is done (right now, drop pod sequence)
   */
  @SaveProperty("mHasCompletedIntroSequence")
  private boolean hasCompletedIntroSequence;

  /**
   * Cached reference of trading post
   */
  @SaveProperty("mTradingPost")
  private ObjectReference TradingPost;

  @SaveProperty("mDidPickUpIronOre")
  private boolean didPickUpIronOre;

  /**
   * Checks if we have dismantled the drop pod
   */
  @SaveProperty("mDidDismantleDropPod")
  private boolean didDismantleDropPod;

  /**
   * Checks if we equipped the stun spear
   */
  @SaveProperty("mDidEquipStunSpear")
  private boolean didEquipStunSpear;

  /**
   * Bool for the step 1 schematic
   */
  @SaveProperty("mDidStep1Upgrade")
  private boolean didStep1Upgrade;

  /**
   * Bool for the step 1.5 schematic
   */
  @SaveProperty("mDidStep1_5Upgrade")
  private boolean didStep1_5Upgrade;

  /**
   * Bool for the step 2 schematic
   */
  @SaveProperty("mDidStep2Upgrade")
  private boolean didStep2Upgrade;

  /**
   * Bool for the step 3 schematic
   */
  @SaveProperty("mDidStep3Upgrade")
  private boolean didStep3Upgrade;

  /**
   * Bool for the step 4 schematic
   */
  @SaveProperty("mDidStep4Upgrade")
  private boolean didStep4Upgrade;

  /**
   * Bool for the step5 schematic
   */
  @SaveProperty("mDidStep5Upgrade")
  private boolean didStep5Upgrade;

  /**
   * The upgrade level we have on our trading post
   */
  @SaveProperty("mTradingPostLevel")
  private int tradingPostLevel;

  public boolean isTradingPostBuilt() {
    return tradingPostBuilt;
  }

  public void setTradingPostBuilt(boolean tradingPostBuilt) {
    this.tradingPostBuilt = tradingPostBuilt;
  }

  public EIntroTutorialSteps getPendingTutorial() {
    return pendingTutorial;
  }

  public void setPendingTutorial(EIntroTutorialSteps pendingTutorial) {
    this.pendingTutorial = pendingTutorial;
  }

  public boolean isHasCompletedIntroTutorial() {
    return hasCompletedIntroTutorial;
  }

  public void setHasCompletedIntroTutorial(boolean hasCompletedIntroTutorial) {
    this.hasCompletedIntroTutorial = hasCompletedIntroTutorial;
  }

  public boolean isHasCompletedIntroSequence() {
    return hasCompletedIntroSequence;
  }

  public void setHasCompletedIntroSequence(boolean hasCompletedIntroSequence) {
    this.hasCompletedIntroSequence = hasCompletedIntroSequence;
  }

  public ObjectReference getTradingPost() {
    return TradingPost;
  }

  public void setTradingPost(ObjectReference tradingPost) {
    TradingPost = tradingPost;
  }

  public boolean isDidPickUpIronOre() {
    return didPickUpIronOre;
  }

  public void setDidPickUpIronOre(boolean didPickUpIronOre) {
    this.didPickUpIronOre = didPickUpIronOre;
  }

  public boolean isDidDismantleDropPod() {
    return didDismantleDropPod;
  }

  public void setDidDismantleDropPod(boolean didDismantleDropPod) {
    this.didDismantleDropPod = didDismantleDropPod;
  }

  public boolean isDidEquipStunSpear() {
    return didEquipStunSpear;
  }

  public void setDidEquipStunSpear(boolean didEquipStunSpear) {
    this.didEquipStunSpear = didEquipStunSpear;
  }

  public boolean isDidStep1Upgrade() {
    return didStep1Upgrade;
  }

  public void setDidStep1Upgrade(boolean didStep1Upgrade) {
    this.didStep1Upgrade = didStep1Upgrade;
  }

  public boolean isDidStep1_5Upgrade() {
    return didStep1_5Upgrade;
  }

  public void setDidStep1_5Upgrade(boolean didStep1_5Upgrade) {
    this.didStep1_5Upgrade = didStep1_5Upgrade;
  }

  public boolean isDidStep2Upgrade() {
    return didStep2Upgrade;
  }

  public void setDidStep2Upgrade(boolean didStep2Upgrade) {
    this.didStep2Upgrade = didStep2Upgrade;
  }

  public boolean isDidStep3Upgrade() {
    return didStep3Upgrade;
  }

  public void setDidStep3Upgrade(boolean didStep3Upgrade) {
    this.didStep3Upgrade = didStep3Upgrade;
  }

  public boolean isDidStep4Upgrade() {
    return didStep4Upgrade;
  }

  public void setDidStep4Upgrade(boolean didStep4Upgrade) {
    this.didStep4Upgrade = didStep4Upgrade;
  }

  public boolean isDidStep5Upgrade() {
    return didStep5Upgrade;
  }

  public void setDidStep5Upgrade(boolean didStep5Upgrade) {
    this.didStep5Upgrade = didStep5Upgrade;
  }

  public int getTradingPostLevel() {
    return tradingPostLevel;
  }

  public void setTradingPostLevel(int tradingPostLevel) {
    this.tradingPostLevel = tradingPostLevel;
  }
}
