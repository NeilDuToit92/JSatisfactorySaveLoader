package za.co.neildutoit.jSatisfactorySaveLoader.save.serialization;

public enum SerializerStage {
  // Loading
  FileOpen,
  ParseHeader,
  Decompressing,
  ReadObjects,
  ReadObjectData,
  ReadDestroyedObjects,
  BuildReferences,

  // Saving
  WriteHeader,
  WriteObjects,
  WriteObjectData,
  WriteDestroyedObjects,
  Compressing,
  FileWrite,

  Done
}