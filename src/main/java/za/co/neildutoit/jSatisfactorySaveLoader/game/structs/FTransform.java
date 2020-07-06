package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FQuat;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.natives.FVector;

@GameStructAttr("Transform")
public class FTransform extends GameStruct {
  //  public override String StructName => "Transform";

  @StructPropertyAttr("Rotation")
  private FQuat rotation;

  @StructPropertyAttr("Translation")
  private FVector translation;

  @StructPropertyAttr("Scale3D")
  private FVector scale3D;

  public FQuat getRotation() {
    return rotation;
  }

  public void setRotation(FQuat rotation) {
    this.rotation = rotation;
  }

  public FVector getTranslation() {
    return translation;
  }

  public void setTranslation(FVector translation) {
    this.translation = translation;
  }

  public FVector getScale3D() {
    return scale3D;
  }

  public void setScale3D(FVector scale3D) {
    this.scale3D = scale3D;
  }
}
