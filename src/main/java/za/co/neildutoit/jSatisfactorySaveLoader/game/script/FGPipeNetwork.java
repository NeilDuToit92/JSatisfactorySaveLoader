package za.co.neildutoit.jSatisfactorySaveLoader.game.script;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Script/FactoryGame.FGPipeNetwork")
public class FGPipeNetwork extends SaveActor {
  /**
   * Unique id of this network, assigned at spawn.
   * Note: This is not persistent between play sessions.
   */
  @SaveProperty("mPipeNetworkID")
  private int pipeNetworkID;
  /**
   * The type of liquid in this network.
   */
  @SaveProperty("mFluidDescriptor")
  private ObjectReference fluidDescriptor;

  /**
   * Compiled during save, and Interface classes are extracted on load. Stores the mFluidIntegrants in a UPROPERTY type
   */
  @SaveProperty("mFluidIntegrantScriptInterfaces")
  private List<ObjectReference> fluidIntegrantScriptInterfaces = new ArrayList<>();

  public int getPipeNetworkID() {
    return pipeNetworkID;
  }

  public void setPipeNetworkID(int pipeNetworkID) {
    this.pipeNetworkID = pipeNetworkID;
  }

  public ObjectReference getFluidDescriptor() {
    return fluidDescriptor;
  }

  public void setFluidDescriptor(ObjectReference fluidDescriptor) {
    this.fluidDescriptor = fluidDescriptor;
  }

  public List<ObjectReference> getFluidIntegrantScriptInterfaces() {
    return fluidIntegrantScriptInterfaces;
  }

  public void setFluidIntegrantScriptInterfaces(List<ObjectReference> fluidIntegrantScriptInterfaces) {
    this.fluidIntegrantScriptInterfaces = fluidIntegrantScriptInterfaces;
  }
}
