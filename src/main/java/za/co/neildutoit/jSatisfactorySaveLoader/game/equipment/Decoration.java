package za.co.neildutoit.jSatisfactorySaveLoader.game.equipment;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;

@SaveObjectClass("/Game/FactoryGame/Equipment/Decoration/BP_Decoration.BP_Decoration_C")
public class Decoration extends SaveActor {

  /**
   * The descriptor of this decoration
   */
  @SaveProperty("mDecorationDescriptor")
  private ObjectReference decorationDescriptor;

  public ObjectReference getDecorationDescriptor() {
    return decorationDescriptor;
  }

  public void setDecorationDescriptor(ObjectReference decorationDescriptor) {
    this.decorationDescriptor = decorationDescriptor;
  }
}
