package za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.vehicle.Train;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.game.buildable.vehicle.FGVehicle;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FRailroadTrackPosition;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;

public abstract class FGRailroadVehicle extends FGVehicle {
  @SaveProperty("mIsDockedAtPlatform")
  private boolean isDockedAtPlatform;

  @SaveProperty("mIsOrientationReversed")
  private boolean isOrientationReversed;

  @SaveProperty("mTrackPosition")
  private FRailroadTrackPosition trackPosition;

  private ObjectReference nextVehicle;
  private ObjectReference peviousVehicle;

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    reader.assertNullInt32();
    setNextVehicle(reader.readObjectReference());
    setPeviousVehicle(reader.readObjectReference());
  }

  public boolean isDockedAtPlatform() {
    return isDockedAtPlatform;
  }

  public void setDockedAtPlatform(boolean dockedAtPlatform) {
    isDockedAtPlatform = dockedAtPlatform;
  }

  public boolean isOrientationReversed() {
    return isOrientationReversed;
  }

  public void setOrientationReversed(boolean orientationReversed) {
    isOrientationReversed = orientationReversed;
  }

  public FRailroadTrackPosition getTrackPosition() {
    return trackPosition;
  }

  public void setTrackPosition(FRailroadTrackPosition trackPosition) {
    this.trackPosition = trackPosition;
  }

  public ObjectReference getNextVehicle() {
    return nextVehicle;
  }

  public void setNextVehicle(ObjectReference nextVehicle) {
    this.nextVehicle = nextVehicle;
  }

  public ObjectReference getPeviousVehicle() {
    return peviousVehicle;
  }

  public void setPeviousVehicle(ObjectReference peviousVehicle) {
    this.peviousVehicle = peviousVehicle;
  }
}
