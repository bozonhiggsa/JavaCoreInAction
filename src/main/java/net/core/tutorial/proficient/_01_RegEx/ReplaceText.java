package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ihor on 13.08.2018.
 */
public class ReplaceText {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("([a-zA-Z]+) (\\d+)", Pattern.UNICODE_CASE);
        Matcher matcher = pattern.matcher("June 24, August 9, Dec 12");

        String replacedString1 = matcher.replaceFirst("Some text");
        String replacedString2 = matcher.replaceFirst("$2 of $1");
        String replacedString3 = matcher.replaceAll("$2 of $1");
        System.out.println(replacedString1);
        System.out.println(replacedString2);
        System.out.println(replacedString3);
    }
}
