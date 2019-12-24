package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ihor on 13.08.2018.
 */
public class SimpleMatch {

    public static void main(String[] args) {

        //String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";
        //String regex = "(?miu)^CanDY$\r\n^ВоВа$";
        //String regex = "(?Um)^([\\s\\w&&[\\D]&&[^_]]+)$";
        //String regex = "(?U)\\b([\\w&&[\\D]&&[^_]])\\b";
        //String regex = "([\\s]?[\\.]?[\\d\\.]+[\\s]?)";
        String regex = "(?Um)^([\\s,\\w&&[\\D]&&[^_]]+)$\\r?\\n";
        Pattern pattern = Pattern.compile("(?m)^(.+)$");
        //boolean isMatch1 = Pattern.matches(regex, "ihor.v.savchenko@gmail.com");
       // boolean isMatch2 = Pattern.matches(regex, "some text");
        String input = "When I was younger\n" +
                "I never needed\n" +
                "Прощай, со всех вокзалов поезда\n" +
                "уходят в Дальние Края\n";
        Matcher matcher = pattern.matcher(input);
        boolean isMatch = Pattern.matches(regex, "When I was younger\n" +
                "I never needed\n" +
                "Прощай, со всех вокзалов поезда\n" +
                "уходят в Дальние Края\n");

        System.out.println("Match is " + isMatch);
        int count = 0;
        while(matcher.find()){
            System.out.println(count++);
            System.out.println(matcher.group(1));
            if(count==3) break;
        }
    }
}
