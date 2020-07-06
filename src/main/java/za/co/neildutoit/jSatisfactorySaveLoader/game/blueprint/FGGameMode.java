package za.co.neildutoit.jSatisfactorySaveLoader.game.blueprint;

import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveProperty;
import za.co.neildutoit.jSatisfactorySaveLoader.save.ObjectReference;
import za.co.neildutoit.jSatisfactorySaveLoader.save.SaveActor;
import za.co.neildutoit.jSatisfactorySaveLoader.save.custom.BinaryReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SaveObjectClass("/Game/FactoryGame/-Shared/Blueprint/BP_GameMode.BP_GameMode_C")
public class FGGameMode extends SaveActor {
  /**
   * Last autosave was this id
   */
  @SaveProperty("mLastAutosaveId")
  private byte lastAutosaveId;

  @SaveProperty("mSessionId")
  @Deprecated
  private int sessionId_DEPRECATED;

  @SaveProperty("mSessionIDString")
  @Deprecated
  private String sessionIDString_DEPRECATED;

  /**
   * The name of the session we are playing
   */
  @SaveProperty("mSaveSessionName")
  private String SaveSessionName;

  /**
   * Selected starting point
   */
  @SaveProperty("mStartingPointTagName")
  private String StartingPointTagName;

  private List<ObjectReference> playerStates = new ArrayList<>();

  public void deserializeNativeData(BinaryReader reader, int length) throws IOException {
    int count = reader.readInt32();
    for (int i = 0; i < count; i++) {
      playerStates.add(reader.readObjectReference());
    }
  }

  public byte getLastAutosaveId() {
    return lastAutosaveId;
  }

  public void setLastAutosaveId(byte lastAutosaveId) {
    this.lastAutosaveId = lastAutosaveId;
  }

  public int getSessionId_DEPRECATED() {
    return sessionId_DEPRECATED;
  }

  public void setSessionId_DEPRECATED(int sessionId_DEPRECATED) {
    this.sessionId_DEPRECATED = sessionId_DEPRECATED;
  }

  public String getSessionIDString_DEPRECATED() {
    return sessionIDString_DEPRECATED;
  }

  public void setSessionIDString_DEPRECATED(String sessionIDString_DEPRECATED) {
    this.sessionIDString_DEPRECATED = sessionIDString_DEPRECATED;
  }

  public String getSaveSessionName() {
    return SaveSessionName;
  }

  public void setSaveSessionName(String saveSessionName) {
    SaveSessionName = saveSessionName;
  }

  public String getStartingPointTagName() {
    return StartingPointTagName;
  }

  public void setStartingPointTagName(String startingPointTagName) {
    StartingPointTagName = startingPointTagName;
  }

  public List<ObjectReference> getPlayerStates() {
    return playerStates;
  }

  public void setPlayerStates(List<ObjectReference> playerStates) {
    this.playerStates = playerStates;
  }
}
