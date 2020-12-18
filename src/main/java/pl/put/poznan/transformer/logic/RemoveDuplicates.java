package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RemoveDuplicates extends TextDecorator{
    public RemoveDuplicates(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        String text = textInput.transform();
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
