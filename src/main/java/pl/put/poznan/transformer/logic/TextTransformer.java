package pl.put.poznan.transformer.logic;
import java.util.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;
    private Map<String, String> abbriviations;

    public TextTransformer(String[] transforms) {
        abbriviations = new HashMap<>();

        abbriviations.put("mgr.", "magister");
        abbriviations.put("Mgr.", "Magister");

        abbriviations.put("dr", "doktor");
        abbriviations.put("Dr", "Doktor");

        abbriviations.put("np", "na przykład");
        abbriviations.put("Np", "Na przykład");

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

    public String expandAbbreviation(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (Map.Entry<String, String> me : abbriviations.entrySet()) {
                if (words[i].equals(me.getKey())) {
                    words[i] = me.getValue();
                }
            }
        }
        return String.join(" ", words);
    }
    public String shrinkToAbbreviation(String text){
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (Map.Entry<String, String> me : abbriviations.entrySet()) {
                if (words[i].equals(me.getValue())) {
                    words[i] = me.getKey();
                }
            }
        }
        return String.join(" ", words);
    }
}