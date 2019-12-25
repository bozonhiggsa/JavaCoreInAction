package net.core.tutorial.proficient._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 Метод

 matcher.appendReplacement(StringBuffer sb, String replacement);

 позволяет добавить в StringBuffer строку, на основании которой был создан matcher,
 и заменить в ней все согласования на строку, данную в аргументе.
 При этом в StringBuffer будет добавлена часть исходной строки, включая последнее согласование.

 Если требуется добавить в StringBuffer оставшуюся часть строки, то можно использовать метод

 matcher.appendTail(StringBuffer sb);

 */

public class _04_RegEx4_AppendReplacement {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("cat");
        Matcher matcher = pattern.matcher("One cat, two cats. When you pull the cat's tail.");
        StringBuffer sb = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(sb, "dog");
        }
        System.out.println(sb.toString());
        System.out.println("---------------------");
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
