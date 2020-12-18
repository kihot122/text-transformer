package pl.put.poznan.transformer.logic;

public class InputString implements IText {


    protected String text;


    public String getText() {
        return text;
    }

    public InputString(String text){
        this.text = text;
    }

    @Override
    public String transform() {
        return this.text;
    }
}
