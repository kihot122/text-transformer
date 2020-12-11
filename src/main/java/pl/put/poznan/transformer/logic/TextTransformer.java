package pl.put.poznan.transformer.logic;
import java.util.*;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;
    private Map<String, String> abbriviations;

    public TextTransformer(String[] transforms) {
        abbriviations = new HashMap<>();

        abbriviations.put("mgr", "magister");
        abbriviations.put("Mgr", "Magister");
        abbriviations.put("MGR", "MAGISTER");

        abbriviations.put("dr", "doktor");
        abbriviations.put("Dr", "Doktor");
        abbriviations.put("DR", "DOKTOR");

        abbriviations.put("np.", "na przykład");
        abbriviations.put("Np.", "Na przykład");
        abbriviations.put("NP.", "NA PRZYKŁAD");

        abbriviations.put("prof.", "profesor");
        abbriviations.put("Prof.", "Profesor");
        abbriviations.put("PROF..", "PROFESOR");

        abbriviations.put("inż.", "inżynier");
        abbriviations.put("Inż.", "Inżynier");
        abbriviations.put("INŻ.", "INŻYNIER");

        abbriviations.put("hab.", "habilitowany");
        abbriviations.put("Hab.", "Habilitowany");
        abbriviations.put("HAB.", "HABILITOWANY");

        abbriviations.put("itp.", "i tym podobne");
        abbriviations.put("Itp.", "I tym podobne");
        abbriviations.put("ITP.", "I TYM PODOBNE");

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

    public String[] words = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
    public String readInt(String text){
        String[] array = text.split(" ");
        String IntToWords = "";
        for(int i = 0; i < array.length; i++){
            String tmp = array[i];
            if(Character.isDigit(tmp.charAt(0))){
                int number = Integer.parseInt(tmp);
                if (number >= 10000)
                    return text;
                while(number > 0){
                    if(tmp.length() == 4){
                        if(tmp.charAt(0) == '1'){
                            IntToWords += "tysiąc ";
                            number -= 1000;
                            tmp = tmp.substring(1);
                        }
                        else if(tmp.charAt(0) == '2' || tmp.charAt(0) == '3' || tmp.charAt(0) == '4'){
                            IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + " tysiące ";
                            number -= Integer.parseInt(String.valueOf(tmp.charAt(0))) * 1000;
                            tmp = tmp.substring(1);
                        }
                        else{
                            IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + " tysięcy ";
                            number -= Integer.parseInt(String.valueOf(tmp.charAt(0))) * 1000;
                            tmp = tmp.substring(1);
                        }
                    }
                    else if(tmp.length() == 3){
                        if(tmp.charAt(0) == '1'){
                            IntToWords += "sto ";
                            number -= 100;
                            tmp = tmp.substring(1);
                        }
                        else if(tmp.charAt(0) == '2'){
                            IntToWords += "dwieście ";
                            number -= 200;
                            tmp = tmp.substring(1);
                        }
                        else if(tmp.charAt(0) == '3' || tmp.charAt(0) == '4'){
                            IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + "sta ";
                            number -= Integer.parseInt(String.valueOf(tmp.charAt(0))) * 100;
                            tmp = tmp.substring(1);
                        }
                        else{
                            IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + "set ";
                            number -= Integer.parseInt(String.valueOf(tmp.charAt(0))) * 100;
                            tmp = tmp.substring(1);
                        }
                    }
                    else if (tmp.length() == 2){
                        if(tmp.charAt(0) == '1'){
                            if(tmp.charAt(1) == '0'){
                                IntToWords += "dziesięć ";
                                number -= 10;
                            }
                            else if(tmp.charAt(1) == '1'){
                                IntToWords += "jedenaście ";
                                number -= 11;
                            }
                            else if(tmp.charAt(1) == '4'){
                                IntToWords += "czternaście ";
                                number -= 14;
                            }
                            else if(tmp.charAt(1) == '5'){
                                IntToWords += "piętnaście ";
                                number -= 15;
                            }
                            else if(tmp.charAt(1) == '6'){
                                IntToWords += "szesnaście ";
                                number -= 11;
                            }
                            else if(tmp.charAt(1) == '9'){
                                IntToWords += "dziewiętnaście ";
                                number -= 19;
                            }
                            else{
                                IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + "naście ";
                                number -= Integer.parseInt(String.valueOf(tmp.charAt(1))) - 10;
                            }
                        }
                        else if(tmp.charAt(0) == '2'){
                            if(tmp.charAt(1) == '0'){
                                IntToWords += "dwadzieścia ";
                                number -= 20;
                                tmp = tmp.substring(1);
                            }
                        }
                        else if(tmp.charAt(0) == '3'|| tmp.charAt(0) == '4'){
                            if(tmp.charAt(0) == '3' || tmp.charAt(1) == '0'){
                                IntToWords += "trzydzieści ";
                                number -= 30;
                                tmp = tmp.substring(1);
                            }
                            else if (tmp.charAt(0) == '4' || tmp.charAt(1) == '0'){
                                IntToWords += "czterdzieści ";
                                number -= 40;
                                tmp = tmp.substring(1);
                            }
                        }
                        else{
                                IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1] + "dziesiąt ";
                                number -= Integer.parseInt(String.valueOf(tmp.charAt(0))) * 10;
                                tmp = tmp.substring(1);
                        }
                    }
                    else if (tmp.length() == 1){
                        IntToWords += words[Integer.parseInt(String.valueOf(tmp.charAt(0))) - 1];
                        number -= Integer.parseInt(String.valueOf(tmp.charAt(0)));
                    }
                }
                array[i] = IntToWords;
            }
        }
        String result = "";
        for (int i = 0; i < array.length; i++){
            result += array[i] + " ";
        }
        return result;
    }
}