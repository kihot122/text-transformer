package pl.put.poznan.transformer.logic;

public class ToLower extends TextDecorator{
    public ToLower(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        String text = textInput.transform();
        return text.toLowerCase();
    }
}
