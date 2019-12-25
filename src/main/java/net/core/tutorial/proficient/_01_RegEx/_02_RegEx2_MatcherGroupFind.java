package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 Из объекта Matcher можно получить индекс строки, на котором начинается согласование
 при помощи matcher.start(),
 а также индекс строки, следующий за тем, на котором заканчивается согласование
 при помощи matcher.end().

 Для извлечения согласованной строки в пределах каждой отдельной группы можно использовать метод .matcher.group()
 с аргументом в виде номера группы. Если аргумент не указывается, то он равен 0. Групой с индексом 0
 всегда считается вся согласованная часть строки.
 Порядковый номер групп определяется порядком следования (слева направо) открывающих скобок,
 т.е. группа (a(bc)) имеет номер 1, а группа (bc) имеет номер 2.

 Если в анализируемой строке имеется несколько согласований с паттерном, то найти их можно при помощи
 метода matcher.find() (возвращает true, если шаблон совпадает с любой частью анализируемой строки) и цикла while.
 На каждой итериации цикла будет обрабатываться одно совпадение с паттерном. При этом можно обработать
 и извлечь совпадения для отдельных групп, входящих в паттерн.

 */

public class _02_RegEx2_MatcherGroupFind {

    public static void main(String[] args) {

        Pattern pattern1 = Pattern.compile("([a-zA-Z]+) (\\d+).*");
        Matcher matcher1 = pattern1.matcher("June 24 and some text");

        if (matcher1.matches()) {
            System.out.println("Match at index [" + matcher1.start() +
                    ", " + matcher1.end() + ")");
            System.out.println("Match: " + matcher1.group());
            System.out.println("Match: " + matcher1.group(1));
            System.out.println("Match: " + matcher1.group(2));
        }

        System.out.println("--------------------");

        String regex2 = "([a-zA-Z]+) (\\d+)";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher("June 24 and some text, August 9 and text, Dec 12");

        while (matcher2.find()) {
            System.out.println(String.format("Match: %s at index [%d, %d]",
            matcher2.group(), matcher2.start(), matcher2.end()));
        }

        System.out.println("--------------------");

        // Если необходимо выполнить итерацию по группам сначала, то нужно предварительно сбросить Matcher
        // при помощи matcher.reset().
        matcher2.reset();
        while (matcher2.find()) {
            System.out.println(String.format("%d groups captured",
                    matcher2.groupCount()));

            System.out.println("Month: " + matcher2.group(1) + ", Day: " +
                    matcher2.group(2));

            System.out.println(String.format("Month found at[%d, %d)",
                    matcher2.start(1), matcher2.end(1)));
        }
        // Здесь метод .matcher.groupCount() позволяет определить количество групп в паттерне
        // (не считая группы с индексом 0).
        // Для каждого согласования в анализируемой строке извлекается информация,
        // соответствующая некоторой группе.
    }
}
