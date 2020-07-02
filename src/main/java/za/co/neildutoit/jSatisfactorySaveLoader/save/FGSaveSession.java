package za.co.neildutoit.jSatisfactorySaveLoader.save;

import java.util.ArrayList;
import java.util.List;

public class FGSaveSession {

  /**
   * Save header which contains information like the version and map info
   */
  private FSaveHeader header;

  /**
   * Objects contained within this save
   */
  private List<SaveObject> objects = new ArrayList<>();

  /**
   * List of object references of all destroyed/collected objects in the world (nut/berry bushes, slugs, etc)
   */
  private List<ObjectReference> destroyedActors;

  /**
   * Tries to find an object with the specified type, instantiates it, adds it to the <see cref="Objects"/> list and returns the instance.
   *
   * <param name="type">The full type path of the object to add</param>
   * <returns></returns>
   */
  public SaveObject addObject(String type) {
    throw new UnsupportedOperationException();
  }

//  /**
//   * Instantiates an object of the specified type, adds it to the <see cref="Objects"/> list and returns the instance
//   *
//   * <typeparam name="T">The SaveObject to add</typeparam>
//   * <returns></returns>
//   */
//  public T AddObject<T>()
//  where T :
//
//  SaveObject {
//    throw new NotImplementedException();
//  }


  /**
   * Finds the specified object and tries to remove all traces of it.
   * This includes child components which are also deleted and any <see cref="ObjectReference"/> pointing to this object is cleared.
   *
   * <param name="instance"></param>
   * <returns>True if object was found and removed, false if not found</returns>
   */
  public boolean RemoveObject(String instance) {
    throw new UnsupportedOperationException();
  }

  /**
   * Finds the specified object and tries to remove all traces of it.
   * This includes child components which are also deleted and any <see cref="ObjectReference"/> pointing to this object is cleared.
   *
   * @param obj
   * @return true if object was found and removed, false if not found
   */
  public boolean RemoveObject(SaveObject obj) {
    throw new UnsupportedOperationException();
  }

  public FGSaveSession(FSaveHeader header) {
    this.header = header;
  }

  public FSaveHeader getHeader() {
    return header;
  }

  public void setHeader(FSaveHeader header) {
    this.header = header;
  }

  public List<SaveObject> getObjects() {
    return objects;
  }

  public void setObjects(List<SaveObject> objects) {
    this.objects = objects;
  }

  public List<ObjectReference> getDestroyedActors() {
    return destroyedActors;
  }

  public void setDestroyedActors(List<ObjectReference> destroyedActors) {
    this.destroyedActors = destroyedActors;
  }
}
