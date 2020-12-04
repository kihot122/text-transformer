package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    public String Reverse(String text){
        StringBuffer sbr = new StringBuffer(text);
        sbr.reverse();
        return  sbr.toString();
    }
    public String remove_dup(String text) {
        List<String> list = new LinkedList<>(Arrays.asList(text.split(" ")));

        for(int i = 0; i < list.size() - 1;){
            if(list.get(i).equals(list.get(i + 1))){
                list.remove(i);
                continue;
            }
            i++;
        }

        return String.join(" ", list);
    }
}
