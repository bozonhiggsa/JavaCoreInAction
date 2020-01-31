package net.core.tutorial.elementary._16_String;

/**

 Сравнение символьных строк.

 .equals(String s1);

 .equalsIgnoreCase(String s1);
 сравнение содержимого строк без учёта регистра символов

 .compareTo(String s1);
 сравнение двух строк в лексикографическом порядке, прописные (большие) буквы имеют меньший номер в UNICODE,
 т.е. следуют раньше строчных букв. Метод возвращает число int, меньшее нуля, если исходная строка
 меньше строки-аргумента. Ноль при равенстве, число больше нуля, если исходная строка больше строки-аргумента.

 .compareToIgnoreCase(String s1);

 */

public class _05_String5_Comparison {

    public static void main(String[] args) {

        System.out.println("World".equals("World"));
        System.out.println("World".equals("world"));
        System.out.println("World".equalsIgnoreCase("world"));
        System.out.println("World".compareTo("world"));
        System.out.println("world".compareTo("world"));
        System.out.println("world".compareToIgnoreCase("WORLD"));
    }
}
