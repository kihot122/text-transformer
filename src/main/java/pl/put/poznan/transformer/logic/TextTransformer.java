package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String Upper(String text){
        return text.toUpperCase();
    }
    public String Lower(String text){
        return text.toLowerCase();
    }
    public String Capitalize(String text){
        String output = text.substring(0, 1).toUpperCase() + text.substring(1);
        return output;
    }

    public String reverse(String text){
        StringBuffer sbr = new StringBuffer(text);
        sbr.reverse();
        return  sbr.toString();
    }
}
