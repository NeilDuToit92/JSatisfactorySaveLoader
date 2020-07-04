package za.co.neildutoit.jSatisfactorySaveLoader.save.properties.arrayValues;

import za.co.neildutoit.jSatisfactorySaveLoader.save.TextEntry;
import za.co.neildutoit.jSatisfactorySaveLoader.save.properties.abstractions.ITextPropertyValue;

public class TextArrayValue implements ITextPropertyValue, IArrayElement
{
//  public Type BackingType => typeof(TextEntry);

  public TextEntry text;

  @Override
  public TextEntry getText() {
    return text;
  }

  @Override
  public void setText(TextEntry text) {
    this.text = text;
  }

//  public void ArraySerialize(BinaryWriter writer)
//  {
//    throw new NotImplementedException();
//  }
}
