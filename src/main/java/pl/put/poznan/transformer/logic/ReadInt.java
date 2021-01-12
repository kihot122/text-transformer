package pl.put.poznan.transformer.logic;

public class ReadInt extends TextDecorator {
    protected String[] words = {"jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};

    public ReadInt(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        String text = textInput.transform();
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
                        if(tmp.charAt(0) == '0'){
                            tmp = tmp.substring(1);
                        }
                        else if(tmp.charAt(0) == '1'){
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
                            if(tmp.charAt(0) == '3'){
                                IntToWords += "trzydzieści ";
                                number -= 30;
                                tmp = tmp.substring(1);
                            }
                            else if (tmp.charAt(0) == '4'){
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
                //IntToWords = IntToWords.substring(0, IntToWords.length());
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
