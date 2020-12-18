package pl.put.poznan.transformer.logic;

public class ToCapital extends TextDecorator {
    public ToCapital(IText text){super(text);}
    @Override
    public String transform(){
        String text = textInput.transform();
        return text.toUpperCase();
    }


}
