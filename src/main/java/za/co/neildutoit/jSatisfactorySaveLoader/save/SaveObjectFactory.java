package za.co.neildutoit.jSatisfactorySaveLoader.save;

import org.reflections.Reflections;
import za.co.neildutoit.jSatisfactorySaveLoader.game.SaveObjectClass;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveObjectFactory {
  private static List<String> missingTypes = new ArrayList<>();

  private final static Logger LOGGER = Logger.getLogger(SaveObjectFactory.class.getName());

  Map<String, Class<?>> loadedClasses = new HashMap<>();

  //TODO: Make this cache
  private Class<?> getClazzByAnnotation(String classNameToMatch) {

    if (loadedClasses.containsKey(classNameToMatch)) {
      return loadedClasses.get(classNameToMatch);
    }

    Reflections reflections = new Reflections("za.co.neildutoit.jSatisfactorySaveLoader.game");
    Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(SaveObjectClass.class);
    System.out.println(classNameToMatch);
    for (Class<?> clazz : annotated) {
      if (clazz.getAnnotation(SaveObjectClass.class) != null) {
        String className = clazz.getAnnotation(SaveObjectClass.class).value();
        if (classNameToMatch.trim().equals(className.trim())) {
          loadedClasses.put(classNameToMatch, clazz);
          return clazz;
        }
      }
    }
    return null;
  }

  /**
   * Attempt to instantiate the matching class for this type, or return a dynamic object when missing
   *
   * @param kind
   * @param className
   * @return
   */
  public SaveObject createFromClass(SaveObjectKind kind, String className) throws IllegalAccessException, InstantiationException {
    Class<?> clazz = getClazzByAnnotation(className);
    if (clazz == null) {
      if (!missingTypes.contains(className)) {
        missingTypes.add(className);
      }
      LOGGER.log(Level.INFO, "Unknown className " + className);
      //TODO        throw new NotImplementedException($"Unknown className " + className);
      throw new NotImplementedException();
    } else {
      switch (kind) {
        case Actor:
          return (SaveActor) clazz.newInstance();
        case Component:
          return (SaveComponent) clazz.newInstance();
        default:
//TODO        throw new NotImplementedException($"Unknown SaveObject kind {kind}");
          throw new NotImplementedException();
      }
    }
  }
}
