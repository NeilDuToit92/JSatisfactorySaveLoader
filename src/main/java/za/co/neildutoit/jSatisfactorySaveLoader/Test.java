package za.co.neildutoit.jSatisfactorySaveLoader;

import za.co.neildutoit.jSatisfactorySaveLoader.save.serialization.SatisfactorySaveSerializer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.zip.DataFormatException;

public class Test {
  public static void main(String[] args) throws IOException, DataFormatException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
    SatisfactorySaveSerializer serializer = new SatisfactorySaveSerializer();
//    serializer.deserialize(new File("EAGame_autosave_2.sav"));
    serializer.deserialize(new File("BreakMe.sav"));
  }
}
