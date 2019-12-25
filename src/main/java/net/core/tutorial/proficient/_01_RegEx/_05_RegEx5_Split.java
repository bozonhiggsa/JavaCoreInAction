package net.core.tutorial.proficient._01_RegEx;

/**

 В классе String имеется метод

 String[] split(String regex)

 который позволяет разделить исходную строку на массив подстрок вокруг согласований
 с регулярным выражением (не включая согласования). Можно использовать второй аргумент для
 ограничения максимального количества возвращаемых подстрок.

 */

public class _05_RegEx5_Split {

    public static void main(String[] args) {

        String lineSeparator = System.lineSeparator();
        String message = "A third\r\nis not\r\ngiven!\r\nIsn't it?>";
        System.out.println(message.contains(lineSeparator));
        String[] strings = message.split(lineSeparator);
        String result = "";
        for(int i = 0; i < strings.length; i++){
            if(strings[i].equals(">")) break;
            if(strings[i].contains(">")){
                result = result + strings[i].substring(0,strings[i].length()-1) + " ; "
                        + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
            }
            else{
                result = result + strings[i] + " ; "
                        + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + lineSeparator;
            }
        }
        System.out.println(result);
    }
}
