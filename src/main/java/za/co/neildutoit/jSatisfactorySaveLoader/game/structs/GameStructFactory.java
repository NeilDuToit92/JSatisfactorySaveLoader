package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

import org.reflections.Reflections;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import za.co.neildutoit.jSatisfactorySaveLoader.game.GameStructAttr;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameStructFactory {
  private static List<String> missingTypes = new ArrayList<>();

  private final static Logger LOGGER = Logger.getLogger(GameStructFactory.class.getName());

  static Map<String, Class<?>> loadedClasses = new HashMap<>();

  private static Class<?> getClazzByAnnotation(String classNameToMatch) {
    if (loadedClasses.containsKey(classNameToMatch)) {
      return loadedClasses.get(classNameToMatch);
    }

    Reflections reflections = new Reflections("za.co.neildutoit.jSatisfactorySaveLoader.game");
    Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(GameStructAttr.class);
    for (Class<?> clazz : annotated) {
      if (clazz.getAnnotation(GameStructAttr.class) != null) {
        String className = clazz.getAnnotation(GameStructAttr.class).value();
        if (classNameToMatch.trim().equals(className.trim())) {
          loadedClasses.put(classNameToMatch, clazz);
          return clazz;
        }
      }
    }
    return null;
  }

  public static GameStruct createFromType(String structName) throws IllegalAccessException, InstantiationException {
    Class<?> clazz = getClazzByAnnotation(structName);
    if (clazz == null) {
      if (!missingTypes.contains(structName)) {
        missingTypes.add(structName);
      }
      LOGGER.log(Level.INFO, "Unknown structName " + structName);
      //TODO        throw new NotImplementedException($"Unknown className " + className);
      throw new NotImplementedException();
    } else {
      return (GameStruct) clazz.newInstance();
    }
  }
}
