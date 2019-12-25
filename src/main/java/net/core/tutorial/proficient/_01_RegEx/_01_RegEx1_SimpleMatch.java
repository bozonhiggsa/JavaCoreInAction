package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 Простейшим способом определить, согласована ли строка с паттерном, является вызов
 статического метода .matches() из класса Pattern:

 boolean isMatch = Pattern.matches(String regex, String inputStr);

 Более функциональный подход, позволяющий определить в частности, в каком месте строка согласуется
 с паттерном или к какой группе принадлежит согласуемая часть строки, заключается в следующем:

 1.	Инстанциируется паттерн (класс Pattern не имеет публичного конструктора и
 его объекты создаются при помощи статического метода в классе Pattern):

 Pattern pattern = Pattern.compile(String regex);

 2.	Созданный паттерн используется для создания объекта Matcher (класс Matcher не имеет публичного
 конструктора и его объекты создаются при помощи статического метода в классе Pattern):

 Matcher matcher = pattern.matcher(String inputStr);

 3.	Из объекта Matcher вызывается метод .matches(), возвращающий true, если шаблон соответствует
 всей анализируемой строке, иначе false.

 */

public class _01_RegEx1_SimpleMatch {

    public static void main(String[] args) {

        String regex1 = "[\\w\\s]+";
        String inputStr1 = "Some text some digits 1 2 3 4 545646 underscore _";
        System.out.println("Полная строка согласована с паттерном: " + Pattern.matches(regex1, inputStr1));
        String regex2 = "(?U)[\\w\\s]+";
        String inputStr2 = "Some text some digits 1 2 3 4 545646 underscore _ привет";
        System.out.println("Полная строка согласована с паттерном: " + Pattern.matches(regex2, inputStr2));

        String regex3 = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
        System.out.println("Email digit34n+%op-x_@gmail.9-9.com согласован с паттерном: " + Pattern.matches(regex3, "digit34n+%op-x_@gmail.9-9.com"));

        System.out.println("--------------------");

        String regex4 = "(?mui)^([a-zа-я\\s]+)$\\r\\n^([a-zа-я\\s]+)$\\r\\n^([a-zа-я\\s]+)$";
        String inputStr4 = "Some english text\r\nНекоторый текст\r\nОпять строка";
        System.out.println("Многострочная строка:\r\n" + inputStr4 +
                "\r\nсогласована с паттерном: " + Pattern.matches(regex4, inputStr4));

        System.out.println("--------------------");

        String regex5 = "(?U)([-\\s,\\w&&[\\D]&&[^_]]+)";
        String inputStr5 = "Некоторый русско-английский текст, без цифр и underscore";
        System.out.println("Полная строка согласована с паттерном: " + Pattern.matches(regex5, inputStr5));

        String regex6 = "(?Uui)\\b([\\w&&[\\D]&&[^_]]+)\\b";
        String inputStr6 = "ОдноРусскоАнглийскоеСловоБезDigitsAndUnderscore";
        System.out.println("Полная строка:\r\nОдноРусскоАнглийскоеСловоБезDigitsAndUnderscore\r\n"
                +"согласована с паттерном: " + Pattern.matches(regex6, inputStr6));

        System.out.println("--------------------");

        String regex7 = "(([\\s]+)?([\\.]+)?([\\d\\.]+)([\\s]+)?)";
        String inputStr7 = "   4646.5464    ";
        System.out.println("Полная строка:\r\n  ..  .. 4646.5464    \r\n"
                +"согласована с паттерном: " + Pattern.matches(regex7, inputStr7));

        System.out.println("--------------------");

        String regex8 = "(?Um)^([\\s,\\w&&[\\D]&&[^_]]+)$\\r?\\n";
        String inputStr8 = "Некоторая строка без цифр и подчёркиваний \n";
        System.out.println("Полная строка:\r\nНекоторая строка без цифр и подчёркиваний \n"
                +"согласована с паттерном: " + Pattern.matches(regex8, inputStr8));

        System.out.println("--------------------");

        // Если паттерн содержит группу, то эта группа по своему номеру сама может включаться в этот же паттерн:
        String regex9 = "(aab)\\s\\1";
        System.out.println("Строка:\r\naab aab\r\nсогласована с паттерном: " + Pattern.matches(regex9, "aab aab"));

        System.out.println("--------------------");

        String regex10 = "(?m)^(.+)$";
        Pattern pattern10 = Pattern.compile(regex10);
        String inputStr10 = "45иврп%;кDFGyt 323!@!$@!$@%ert$%&%~gdh/./.[][]['l;";
        Matcher matcher10 = pattern10.matcher(inputStr10);
        System.out.println("Полная строка из произвольных символов:\r\n" + inputStr10 + "\r\nсогласована с паттерном: "
                + matcher10.matches());
    }
}
