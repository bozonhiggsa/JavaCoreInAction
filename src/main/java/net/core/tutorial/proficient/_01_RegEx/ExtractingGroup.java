package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ihor on 13.08.2018.
 */
public class ExtractingGroup {

    public static void main(String[] args) {

        String lineSeparator = System.lineSeparator();
        //String regex = "([a-zA-Z]+) (\\d+)";
        //String regex = "(?U)(\\p{javaUpperCase}([\\w\\s" + lineSeparator + ",]+)\\.)";
        String regex = "(?s)(\\p{javaUpperCase}(.+?)\\.)";
        Pattern pattern = Pattern.compile(regex);
        /*Matcher matcher = pattern.matcher("Класс должен разбирать текстовый файл и возвращать предложения из файла. Под предложением " + lineSeparator +
                "понимать последовательность, которая начинается с большой буквы " + lineSeparator +
        "и заканчивается точкой." + lineSeparator +
        "Исходный файл брать небольшим по " + lineSeparator +
        "размеру. Достаточно несколько строк и несколько предложений.");*/
        Matcher matcher = pattern.matcher("Класс должен разбирать. Под предложением " + lineSeparator +
                "понимать. Du hast mich gefragt." + lineSeparator +
                "и заканчивается точкой." + lineSeparator +
                "Du hast mich gefragt " + lineSeparator +
                "und ich hab nichts gesagt.");

        while (matcher.find()) {
            /*System.out.println(String.format("Match: %s at index [%d, %d]",
                    matcher.group(), matcher.start(), matcher.end()));*/
            System.out.println(1);
            System.out.println(matcher.group(1));
        }

        /*matcher.reset();
        while (matcher.find()) {
            System.out.println(String.format("%d groups captured",
                    matcher.groupCount()));

            System.out.println("Month: " + matcher.group(1) + ", Day: " +
                    matcher.group(2));

            System.out.println(String.format("Month found at[%d, %d)",
                    matcher.start(1), matcher.end(1)));
        }*/
    }
}
