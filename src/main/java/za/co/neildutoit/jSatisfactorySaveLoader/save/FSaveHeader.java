package za.co.neildutoit.jSatisfactorySaveLoader.save;

import za.co.neildutoit.jSatisfactorySaveLoader.game.enums.ESessionVisibility;

public class FSaveHeader {
  /**
   * Header version number
   */
  private FSaveHeaderVersion headerVersion;

  /**
   * Save version number
   */
  private FSaveCustomVersion saveVersion;

  /**
   * Save build number
   * Should indicate the build of the game that generated this save, but is currently always 66297
   */
  private int buildVersion;

  /**
   * The name of what appears to be the root object of the save.
   * Seems to always be "Persistent_Level"
   */
  private String mapName;

  /**
   * An URL style list of arguments of the session.
   * Contains the startloc, sessionName and Visibility
   */
  private String mapOptions;

  /**
   * Name of the saved game as entered when creating a new game
   */
  private String sessionName;

  /**
   * Amount of seconds spent in this save
   */
  private int playDuration;

  /**
   * Unix timestamp of when the save was saved
   */
  private long saveDateTime;

  /**
   * The session visibility of the game.
   * Only valid for saves with HeaderVersion >= AddedSessionVisibility
   */
  private ESessionVisibility sessionVisibility;

  public FSaveHeader(FSaveHeaderVersion headerVersion, FSaveCustomVersion saveVersion, int buildVersion, String mapName, String mapOptions, String sessionName, int playDuration, long saveDateTime) {
    this.headerVersion = headerVersion;
    this.saveVersion = saveVersion;
    this.buildVersion = buildVersion;
    this.mapName = mapName;
    this.mapOptions = mapOptions;
    this.sessionName = sessionName;
    this.playDuration = playDuration;
    this.saveDateTime = saveDateTime;
  }

  //  {
//    get
//    {
//      if (!SupportsSessionVisibility)
//        throw new InvalidOperationException($"{nameof(SessionVisibility)} is not supported for this save version");
//
//      return sessionVisibility;
//    }
//    set
//    {
//      if (!SupportsSessionVisibility)
//        throw new InvalidOperationException($"{nameof(SessionVisibility)} is not supported for this save version");
//
//      sessionVisibility = value;
//    }
//  }

  /**
   * Helper property that indicates if this save header supports SessionVisibility
   */
  public boolean supportsSessionVisibility() {
    return headerVersion.ordinal() >= FSaveHeaderVersion.AddedSessionVisibility.ordinal();
  }

  /**
   * Helper property that indicates if this save is compressed
   */
  public boolean isCompressed() {
    return saveVersion.ordinal() >= FSaveCustomVersion.SaveFileIsCompressed.ordinal();
  }


  public FSaveHeaderVersion getHeaderVersion() {
    return headerVersion;
  }

  public void setHeaderVersion(FSaveHeaderVersion headerVersion) {
    this.headerVersion = headerVersion;
  }

  public FSaveCustomVersion getSaveVersion() {
    return saveVersion;
  }

  public void setSaveVersion(FSaveCustomVersion saveVersion) {
    this.saveVersion = saveVersion;
  }

  public int getBuildVersion() {
    return buildVersion;
  }

  public void setBuildVersion(int buildVersion) {
    this.buildVersion = buildVersion;
  }

  public String getMapName() {
    return mapName;
  }

  public void setMapName(String mapName) {
    this.mapName = mapName;
  }

  public String getMapOptions() {
    return mapOptions;
  }

  public void setMapOptions(String mapOptions) {
    this.mapOptions = mapOptions;
  }

  public String getSessionName() {
    return sessionName;
  }

  public void setSessionName(String sessionName) {
    this.sessionName = sessionName;
  }

  public int getPlayDuration() {
    return playDuration;
  }

  public void setPlayDuration(int playDuration) {
    this.playDuration = playDuration;
  }

  public long getSaveDateTime() {
    return saveDateTime;
  }

  public void setSaveDateTime(long saveDateTime) {
    this.saveDateTime = saveDateTime;
  }

  public ESessionVisibility getSessionVisibility() {
    return sessionVisibility;
  }

  public void setSessionVisibility(ESessionVisibility sessionVisibility) {
    this.sessionVisibility = sessionVisibility;
  }
}
