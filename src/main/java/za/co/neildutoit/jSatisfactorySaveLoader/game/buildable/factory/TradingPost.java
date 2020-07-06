package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.factory;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/Buildable/Factory/TradingPost/Build_TradingPost.Build_TradingPost_C")
public class TradingPost extends FGBuildableFactory {

  @SaveProperty("mGenerators")
  private List<ObjectReference> generators = new ArrayList<>();

  @SaveProperty("mStorage")
  private ObjectReference storage;

  @SaveProperty("mMAM")
  private ObjectReference mam;

  @SaveProperty("mHubTerminal")
  private ObjectReference hubTerminal;

  @SaveProperty("mWorkBench")
  private ObjectReference workBench;

  @SaveProperty("mInputInventory")
  private ObjectReference inputInventory;

  @SaveProperty("mStorageInventory")
  private ObjectReference storageInventory;

  public List<ObjectReference> getGenerators() {
    return generators;
  }

  public void setGenerators(List<ObjectReference> generators) {
    this.generators = generators;
  }

  public ObjectReference getStorage() {
    return storage;
  }

  public void setStorage(ObjectReference storage) {
    this.storage = storage;
  }

  public ObjectReference getMam() {
    return mam;
  }

  public void setMam(ObjectReference mam) {
    this.mam = mam;
  }

  public ObjectReference getHubTerminal() {
    return hubTerminal;
  }

  public void setHubTerminal(ObjectReference hubTerminal) {
    this.hubTerminal = hubTerminal;
  }

  public ObjectReference getWorkBench() {
    return workBench;
  }

  public void setWorkBench(ObjectReference workBench) {
    this.workBench = workBench;
  }

  public ObjectReference getInputInventory() {
    return inputInventory;
  }

  public void setInputInventory(ObjectReference inputInventory) {
    this.inputInventory = inputInventory;
  }

  public ObjectReference getStorageInventory() {
    return storageInventory;
  }

  public void setStorageInventory(ObjectReference storageInventory) {
    this.storageInventory = storageInventory;
  }
}
