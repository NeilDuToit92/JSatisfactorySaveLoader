package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

public abstract class FGBuildableResourceExtractor extends FGBuildableFactory {

  /**
   * How much time we have left of the start up time for the extraction process (mExtractStartupTime).
   */
  @SaveProperty("mExtractStartupTimer")
  private float extractStartupTimer;

  /**
   * DEPRICATED - Only used for old save support. Use mExtractableResource instead.
   * The resource node we want to extract from.
   */
  @SaveProperty("mExtractResourceNode")
  @Deprecated
  private ObjectReference extractResourceNode;

  @SaveProperty("mExtractableResource")
  private ObjectReference extractableResource;

  /**
   * Current extract progress in the range [0, 1]
   */
  @SaveProperty("mCurrentExtractProgress")
  private float currentExtractProgress;

  /**
   * Our output inventory
   */
  @SaveProperty("mOutputInventory")
  public ObjectReference outputInventory;

  public float getExtractStartupTimer() {
    return extractStartupTimer;
  }

  public void setExtractStartupTimer(float extractStartupTimer) {
    this.extractStartupTimer = extractStartupTimer;
  }

  public ObjectReference getExtractResourceNode() {
    return extractResourceNode;
  }

  public void setExtractResourceNode(ObjectReference extractResourceNode) {
    this.extractResourceNode = extractResourceNode;
  }

  public ObjectReference getExtractableResource() {
    return extractableResource;
  }

  public void setExtractableResource(ObjectReference extractableResource) {
    this.extractableResource = extractableResource;
  }

  public float getCurrentExtractProgress() {
    return currentExtractProgress;
  }

  public void setCurrentExtractProgress(float currentExtractProgress) {
    this.currentExtractProgress = currentExtractProgress;
  }

  public ObjectReference getOutputInventory() {
    return outputInventory;
  }

  public void setOutputInventory(ObjectReference outputInventory) {
    this.outputInventory = outputInventory;
  }
}
