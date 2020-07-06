package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains data about the research conducted
 */
@GameStructAttr("ResearchData")
public class FResearchData extends GameStruct {
//    public override String StructName => "ResearchData";

  /**
   * The schematic that holds the research data
   */
  @StructPropertyAttr("schematic")
  private ObjectReference schematic;

  /**
   * The research tree that initiated the research
   */
  @StructPropertyAttr("InitiatingResearchTree")
  private ObjectReference initiatingResearchTree;

  /**
   * The rewards that have been generated for this schematic.
   * This is used for example to store randomized alternate recipe schematics when analyzing a hard drive
   * This array can be empty since most schematics use the unlock system except hard drives that generate rewards when research is initialized
   */
  @StructPropertyAttr("PendingRewards")
  private List<ObjectReference> pendingRewards = new ArrayList<>();

  public ObjectReference getSchematic() {
    return schematic;
  }

  public void setSchematic(ObjectReference schematic) {
    this.schematic = schematic;
  }

  public ObjectReference getInitiatingResearchTree() {
    return initiatingResearchTree;
  }

  public void setInitiatingResearchTree(ObjectReference initiatingResearchTree) {
    this.initiatingResearchTree = initiatingResearchTree;
  }

  public List<ObjectReference> getPendingRewards() {
    return pendingRewards;
  }

  public void setPendingRewards(List<ObjectReference> pendingRewards) {
    this.pendingRewards = pendingRewards;
  }
}
