package net.core.tutorial.elementary._18_String;

/**

 Поиск в символьных строках.

 .indexOf(char ch);
 .indexOf(String s1);
 возвращает номер позиции int символа или подстроки в текущей строке. Если символ не найден, то возвращает -1.

 .indexOf(char ch, int indexFrom);
 возвращает номер позиции int символа или подстроки в текущей строке (первое появление), начиная с символа
 номер indexFrom. Если символ не найден, то возвращает -1.

 .lastIndexOf(char ch);
 .lastIndexOf(String s1);
 возвращает номер позиции int последнего использования символа или подстроки в текущей строке.

 */

public class _06_String6_SearchInStrings {

    public static void main(String[] args) {

        String message = "Laptop is on the desk";
        int index1 = message.indexOf('p');
        int index2 = message.indexOf("is on");
        System.out.println(index1);
        System.out.println(index2);
        int index3 = message.indexOf('s', 9);
        System.out.println(index3);
        String message2 = "Laptop, Laptop, small laptop";
        int index4 = message2.lastIndexOf('t');
        int index5 = message2.lastIndexOf("op");
        System.out.println(index4);
        System.out.println(index5);
    }
}
