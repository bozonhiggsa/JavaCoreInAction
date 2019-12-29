package net.core.tutorial.medium._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 Важным применением регулярных выражений является нахождение и замена части строки согласно паттерну.
 Для этого используются методы matcher.replaceFirst(String inputStr) и matcher.replaceAll(String inputStr).
 Оба метода сначала сбрасывают Matcher в начало, а уже затем начинают поиск.

 */

public class _03_RegEx3_MatcherReplace {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("([a-z]+) (\\d+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("June 24, August 9, Dec 12");

        String replacedString1 = matcher.replaceFirst("Some text");
        // При помощи $numberOfGroup можно выполнять замену в согласовнном тексте
        // с использованием содержимого групп
        String replacedString2 = matcher.replaceFirst("$2 of $1");
        String replacedString3 = matcher.replaceAll("$2 of $1");
        System.out.println(replacedString1);
        System.out.println(replacedString2);
        System.out.println(replacedString3);
    }
}
