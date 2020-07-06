package za.co.neildutoit.jSatisfactorySaveLoader.game.recipes.research;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FResearchCost;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FResearchData;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.FResearchTime;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

/**
 * The research manager handles everything research related
 */
@SaveObjectClass("/Game/FactoryGame/Recipes/Research/BP_ResearchManager.BP_ResearchManager_C")
public class ResearchManager extends SaveActor {
  @SaveProperty("mResearchCosts")
  private List<FResearchCost> ResearchCosts = new ArrayList<>();

  @SaveProperty("mUnlockedResearchTrees")
  private List<ObjectReference> UnlockedResearchTrees = new ArrayList<>();

  /**
   * What research has been conducted and is complete.
   */
  @SaveProperty("mCompletedResearch")
  private List<FResearchData> CompletedResearch = new ArrayList<>();

  /**
   * Used save the current ongoing research, saved research is restarted on load
   */
  @SaveProperty("mSavedOngoingResearch")
  private List<FResearchTime> SavedOngoingResearch = new ArrayList<>();

  public List<FResearchCost> getResearchCosts() {
    return ResearchCosts;
  }

  public void setResearchCosts(List<FResearchCost> researchCosts) {
    ResearchCosts = researchCosts;
  }

  public List<ObjectReference> getUnlockedResearchTrees() {
    return UnlockedResearchTrees;
  }

  public void setUnlockedResearchTrees(List<ObjectReference> unlockedResearchTrees) {
    UnlockedResearchTrees = unlockedResearchTrees;
  }

  public List<FResearchData> getCompletedResearch() {
    return CompletedResearch;
  }

  public void setCompletedResearch(List<FResearchData> completedResearch) {
    CompletedResearch = completedResearch;
  }

  public List<FResearchTime> getSavedOngoingResearch() {
    return SavedOngoingResearch;
  }

  public void setSavedOngoingResearch(List<FResearchTime> savedOngoingResearch) {
    SavedOngoingResearch = savedOngoingResearch;
  }
}
