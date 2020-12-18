package pl.put.poznan.transformer.logic;

import java.util.Map;

public class ExpandAbbriviation extends TextDecorator{
    Abbriviations abbriviations;
    public ExpandAbbriviation(IText textInput,Abbriviations abbriviations) {
        super(textInput);
        this.abbriviations = abbriviations;

    }
    @Override
    public String transform(){
        String text = textInput.transform();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            for (Map.Entry<String, String> me : abbriviations.getAbbriviations().entrySet()) {
                if (words[i].equals(me.getKey())) {
                    words[i] = me.getValue();
                }
            }
        }
        return String.join(" ", words);
    }
}
