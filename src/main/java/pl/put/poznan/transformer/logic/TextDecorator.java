package pl.put.poznan.transformer.logic;

public class TextDecorator implements IText{
    protected IText textInput;

    public TextDecorator(IText textInput){
        this.textInput = textInput;
    }

    @Override
    public String transform() {
        return this.textInput.transform();
    }
}
