package za.co.neildutoit.jSatisfactorySaveLoader.game.structs;

public class StructPropertyAttribute {
//  [AttributeUsage(AttributeTargets.Property)]
//  public class StructPropertyAttribute : Attribute

  /**
   * Serialized name of the property
   */
  private String name;

  public StructPropertyAttribute(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
