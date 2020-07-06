package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.game.StructPropertyAttr;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;

@GameStructAttr("MessageData")
public class FMessageData extends GameStruct {
//  public override String StructName => "MessageData";

  @StructPropertyAttr("WasRead")
  private boolean wasRead;

  @StructPropertyAttr("MessageClass")
  private ObjectReference messageClass;

  public boolean isWasRead() {
    return wasRead;
  }

  public void setWasRead(boolean wasRead) {
    this.wasRead = wasRead;
  }

  public ObjectReference getMessageClass() {
    return messageClass;
  }

  public void setMessageClass(ObjectReference messageClass) {
    this.messageClass = messageClass;
  }
}
