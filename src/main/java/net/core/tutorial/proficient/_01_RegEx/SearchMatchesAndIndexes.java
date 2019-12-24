package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ihor on 12.08.2018.
 */
public class SearchMatchesAndIndexes {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("([a-zA-Z]+) (\\d+)");
        Matcher matcher = pattern.matcher("June 24");
        if (matcher.matches()) {
            System.out.println("Match at index [" + matcher.start() +
                    ", " + matcher.end() + ")");
            System.out.println("Match: " + matcher.group());
            System.out.println("Match: " + matcher.group(1));
            System.out.println("Match: " + matcher.group(2));
        }

        Pattern pattern2 = Pattern.compile("\\bport\\b");
        Matcher matcher2 = pattern2.matcher("sdc port sdc");
        if (matcher2.find()) {
            System.out.println("Match at index [" + matcher2.start() +
                    ", " + matcher2.end() + ")" + " " + matcher2.group());
        }
    }
}
