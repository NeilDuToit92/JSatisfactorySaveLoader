package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.vehicle;

import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector3;
import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector4;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FVector;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FGWheeledVehicle extends FGVehicle {
  @SaveProperty("mCurrentFuelAmount")
  private float currentFuelAmount;

  @SaveProperty("mIsLoadingVehicle")
  private boolean isLoadingVehicle;

  @SaveProperty("mIsUnloadingVehicle")
  private boolean isUnloadingVehicle;

  @SaveProperty("mCurrentFuelClass")
  private ObjectReference currentFuelClass;

  @SaveProperty("mIsSimulated")
  private boolean isSimulated;

  @SaveProperty("mFuelInventory")
  private ObjectReference fuelInventory;

  @SaveProperty("mStorageInventory")
  private ObjectReference storageInventory;

  @SaveProperty("mTargetNodeLinkedList")
  private ObjectReference targetNodeLinkedList;

  @SaveProperty("mIsPathVisible")
  private boolean isPathVisible;

  @SaveProperty("mCurrentDestination")
  private FVector currentDestination;

  @SaveProperty("mDesiredSteering")
  private float desiredSteering;

  @SaveProperty("mSpeedLimit")
  private int speedLimit;

  @SaveProperty("mIsAutoPilotEnabled")
  private boolean isAutoPilotEnabled;

  private List<MaybeBone> maybeBones = new ArrayList<>();

  public float getCurrentFuelAmount() {
    return currentFuelAmount;
  }

  public void setCurrentFuelAmount(float currentFuelAmount) {
    this.currentFuelAmount = currentFuelAmount;
  }

  public boolean isIsLoadingVehicle() {
    return isLoadingVehicle;
  }

  public void setIsLoadingVehicle(boolean loadingVehicle) {
    isLoadingVehicle = loadingVehicle;
  }

  public boolean isUnloadingVehicle() {
    return isUnloadingVehicle;
  }

  public void setUnloadingVehicle(boolean unloadingVehicle) {
    isUnloadingVehicle = unloadingVehicle;
  }

  public ObjectReference getCurrentFuelClass() {
    return currentFuelClass;
  }

  public void setCurrentFuelClass(ObjectReference currentFuelClass) {
    this.currentFuelClass = currentFuelClass;
  }

  public boolean isIsSimulated() {
    return isSimulated;
  }

  public void setIsSimulated(boolean simulated) {
    isSimulated = simulated;
  }

  public ObjectReference getFuelInventory() {
    return fuelInventory;
  }

  public void setFuelInventory(ObjectReference fuelInventory) {
    this.fuelInventory = fuelInventory;
  }

  public ObjectReference getStorageInventory() {
    return storageInventory;
  }

  public void setStorageInventory(ObjectReference storageInventory) {
    this.storageInventory = storageInventory;
  }

  public ObjectReference getTargetNodeLinkedList() {
    return targetNodeLinkedList;
  }

  public void setTargetNodeLinkedList(ObjectReference targetNodeLinkedList) {
    this.targetNodeLinkedList = targetNodeLinkedList;
  }

  public boolean isPathVisible() {
    return isPathVisible;
  }

  public void setPathVisible(boolean pathVisible) {
    isPathVisible = pathVisible;
  }

  public FVector getCurrentDestination() {
    return currentDestination;
  }

  public void setCurrentDestination(FVector currentDestination) {
    this.currentDestination = currentDestination;
  }

  public float getDesiredSteering() {
    return desiredSteering;
  }

  public void setDesiredSteering(float desiredSteering) {
    this.desiredSteering = desiredSteering;
  }

  public int getSpeedLimit() {
    return speedLimit;
  }

  public void setSpeedLimit(int speedLimit) {
    this.speedLimit = speedLimit;
  }

  public boolean isAutoPilotEnabled() {
    return isAutoPilotEnabled;
  }

  public void setAutoPilotEnabled(boolean autoPilotEnabled) {
    isAutoPilotEnabled = autoPilotEnabled;
  }

  public List<MaybeBone> getMaybeBones() {
    return maybeBones;
  }

  public void setMaybeBones(List<MaybeBone> maybeBones) {
    this.maybeBones = maybeBones;
  }

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    int count = reader.readInt32();
    for (int i = 0; i < count; i++) {
      maybeBones.add(new MaybeBone(reader.readCharArray(), reader.readVector3(), reader.readVector4(), reader.readBytes(25)));
    }
  }

  public class MaybeBone {
    private String name;
    private Vector3 position;
    private Vector4 rotation;
    private byte[] unknown;

    public MaybeBone(String name, Vector3 position, Vector4 rotation, byte[] unknown) {
      this.name = name;
      this.position = position;
      this.rotation = rotation;
      this.unknown = unknown;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public Vector3 getPosition() {
      return position;
    }

    public void setPosition(Vector3 position) {
      this.position = position;
    }

    public Vector4 getRotation() {
      return rotation;
    }

    public void setRotation(Vector4 rotation) {
      this.rotation = rotation;
    }

    public byte[] getUnknown() {
      return unknown;
    }

    public void setUnknown(byte[] unknown) {
      this.unknown = unknown;
    }
  }
}
