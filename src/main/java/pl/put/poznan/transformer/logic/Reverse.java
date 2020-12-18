package pl.put.poznan.transformer.logic;

public class Reverse extends TextDecorator{
    public Reverse(IText textInput) {
        super(textInput);
    }
    public String transform(){
        String text = textInput.transform();
        StringBuilder sbr = new StringBuilder(text);
        sbr.reverse();
        return sbr.toString();
    }
}
