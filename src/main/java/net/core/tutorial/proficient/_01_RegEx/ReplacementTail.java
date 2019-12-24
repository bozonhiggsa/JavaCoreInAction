package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ihor on 09.09.2018.
 */
public class ReplacementTail {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat two cats in the cat's yard");
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "dog");
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}
