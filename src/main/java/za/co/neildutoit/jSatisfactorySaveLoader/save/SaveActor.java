package za.co.neildutoit.jSatisfactorySaveLoader.save;

import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector3;
import za.co.neildutoit.jSatisfactorySaveLoader.control.Vector4;

import java.util.ArrayList;
import java.util.List;

public class SaveActor extends SaveObject {
  private SaveObjectKind objectKind = SaveObjectKind.Actor;

  /**
   * If returning true, then when loading, we are returned to the location that was stored when saving
   */
  private boolean NeedTransform;

  /**
   * Rotation in the world
   */
  private Vector4 Rotation;

  /**
   * Position in the world
   */
  private Vector3 Position;

  /**
   * Scale in the world
   */
  private Vector3 Scale;

  /**
   * Unknown use
   */
  private boolean WasPlacedInLevel;

  /**
   * Unknown related (parent?) object
   */
  private ObjectReference ParentObject;

  /**
   * List of SaveComponents belonging to this object
   */
  private List<ObjectReference> Components = new ArrayList<>();

  @Override
  public SaveObjectKind getObjectKind() {
    return objectKind;
  }

  public void setObjectKind(SaveObjectKind objectKind) {
    this.objectKind = objectKind;
  }

  public boolean isNeedTransform() {
    return NeedTransform;
  }

  public void setNeedTransform(boolean needTransform) {
    NeedTransform = needTransform;
  }

  public Vector4 getRotation() {
    return Rotation;
  }

  public void setRotation(Vector4 rotation) {
    Rotation = rotation;
  }

  public Vector3 getPosition() {
    return Position;
  }

  public void setPosition(Vector3 position) {
    Position = position;
  }

  public Vector3 getScale() {
    return Scale;
  }

  public void setScale(Vector3 scale) {
    Scale = scale;
  }

  public boolean isWasPlacedInLevel() {
    return WasPlacedInLevel;
  }

  public void setWasPlacedInLevel(boolean wasPlacedInLevel) {
    WasPlacedInLevel = wasPlacedInLevel;
  }

  public ObjectReference getParentObject() {
    return ParentObject;
  }

  public void setParentObject(ObjectReference parentObject) {
    ParentObject = parentObject;
  }

  public List<ObjectReference> getComponents() {
    return Components;
  }

  public void setComponents(List<ObjectReference> components) {
    Components = components;
  }
}
