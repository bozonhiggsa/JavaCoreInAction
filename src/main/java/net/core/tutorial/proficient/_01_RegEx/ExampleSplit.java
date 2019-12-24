package net.core.tutorial.proficient._01_RegEx;

/**
 * Created by Ihor on 14.09.2018.
 */
public class ExampleSplit {

    public static void main(String[] args) {

        String lineSeparator = System.lineSeparator();
        String s = "sfssdvdsf\r\ndsfgdgfgsdgsdgsdgsdgd\r\ndfgdsgsdgsdgdsgd\r\ndrgdgdsgsdgdsgsdgs>";
        System.out.println(s.contains(lineSeparator));
        String[] strings = s.split(lineSeparator);
        String result = "";
        for(int i = 0; i < strings.length; i++){
            if(strings[i].equals(">")) break;
            if(strings[i].contains(">")){
                result = result + strings[i].substring(0,strings[i].length()-1) + ";"
                        + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
            }
            else{
                result = result + strings[i] + ";"
                        + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + lineSeparator;
            }
        }
        System.out.println(result);
    }
}
