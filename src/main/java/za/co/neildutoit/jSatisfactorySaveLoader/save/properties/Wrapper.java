package za.co.neildutoit.jSatisfactorySaveLoader.save.properties;

import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import za.co.neildutoit.jSatisfactorySaveLoader.game.structs.StructPropertyAttribute;

public class Wrapper {
  private PropertyInfo property;
  private StructPropertyAttribute attribute;

  public PropertyInfo getProperty() {
    return property;
  }

  public void setProperty(PropertyInfo property) {
    this.property = property;
  }

  public StructPropertyAttribute getAttribute() {
    return attribute;
  }

  public void setAttribute(StructPropertyAttribute attribute) {
    this.attribute = attribute;
  }
}
