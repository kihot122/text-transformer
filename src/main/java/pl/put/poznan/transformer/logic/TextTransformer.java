package pl.put.poznan.transformer.logic;

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

        abbriviations.put("dr.", "doktor");
        abbriviations.put("Dr.", "Doktor");

        abbriviations.put("np.", "na przykład");
        abbriviations.put("Np.", "Na przykład");

        this.transforms = transforms;
    }

    public String transform(String text) {
        // of course, normally it would do something based on the transforms
        return text.toUpperCase();
    }

    public String reverse(String text) {
        StringBuffer sbr = new StringBuffer(text);
        sbr.reverse();
        return sbr.toString();
    }

    public String expandAbbriviation(String text) {
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
}