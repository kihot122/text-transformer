package pl.put.poznan.transformer.logic;

public class Capitalize extends TextDecorator{


    public Capitalize(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        String text = textInput.transform();
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
}
