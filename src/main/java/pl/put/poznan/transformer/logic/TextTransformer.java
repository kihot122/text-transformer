package pl.put.poznan.transformer.logic;
import java.util.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String upper(String text){
        return text.toUpperCase();
    }
    public String lower(String text){
        return text.toLowerCase();
    }
    public String capitalize(String text){
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    public String reverse(String text){
        StringBuilder sbr = new StringBuilder(text);
        sbr.reverse();
        return sbr.toString();
    }

}
