package net.core.tutorial.medium._01_RegEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 При создании объекта паттерна при помощи Pattern.compile(String regex) в качестве второго аргумента
 можно передать набор флагов, задающих режим использования паттерна. Набор флагов задаётся в виде int,
 но каждый из них можно записать отдельно в виде 16-тиричного числа в различные разряды данного int. Например:

 Pattern.CASE_INSENSITIVE – паттерн нечувствителен к разряду ASCII символов во входной строке. Код режима i;

 Pattern.UNICODE_CASE – этот режим дополняет (используется совместно) режим CASE_INSENSITIVE, так чтобы паттерн
 был нечувствителен к разряду любых символов UNICODE. Код режима u. Сам по себе режим ничего не даёт,
 но используется в связке iu;

 Pattern.COMMENTS – пробельные символы игнорируются, после # можно писать комментарий, который также игнорируется.
 Код режима x;

 Pattern.DOTALL – метасимвол (.) включает в себя \n. Код режима s;

 Pattern.MULTILINE – многострочный режим. В данном режиме метасимволы ^ и $ означают начало и конец подстроки,
 отделённой от других символов при помощи \r и/или \n. И метасимвол ^ можно размещать сразу после \r и/или \n,
 а метасимвол $ можно размещать перед \r и/или \n Код режима m.
 Если режим не включён, то началом и концом строки считается начало и конец всей полной Java строки;

 Pattern.UNICODE_CHARACTER_CLASS – этот режим позволяет паттерны, согласованные с латиницей,
 распространить на согласование с другими национальными языками. Код режима U. Например, метасимвол \\w в этом
 режиме будет согласоваться также с кириллическими символами.

 Или можно предворять паттерн регулярного выражения
 (?код_режима)

 Например:

 "(?x)a    bc   #comment"  // согласуется со строкой "abс"

 Можно включать несколько режимов одновременно:

 (?ius)

 */
public class _06_RegEx6_Modes {

    public static void main(String[] args) {

        String lineSeparator = System.lineSeparator();
        // Паттерн согласуется с частью строки, которая начинается с заглавной буквы и заканчивается точкой.
        // При использовании режима (?s) и (.+?) разделители строк будут восприниматься как часть строки.
        String regex1 = "(?s)(\\p{javaUpperCase}(.+?)\\.)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher("Класс должен разбирать. Под предложением " + lineSeparator +
                "понимать. Du hast mich gefragt." + lineSeparator +
                "и заканчивается точкой." + lineSeparator +
                "Du hast mich gefragt " + lineSeparator +
                "und ich hab nichts gesagt.");

        while (matcher1.find()) {
            System.out.println("----------------");
            System.out.println(matcher1.group(1));
        }
        System.out.println("----------------");

        // Без использования режима (?s) и при использовании (.+?) разделители строк будут разделять строки.
        String regex2 = "(\\p{javaUpperCase}(.+?)\\.)";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher("Класс должен разбирать. Под предложением " + lineSeparator +
                "понимать. Du hast mich gefragt." + lineSeparator +
                "и заканчивается точкой." + lineSeparator +
                "Du hast mich gefragt " + lineSeparator +
                "und ich hab nichts gesagt.");

        while (matcher2.find()) {
            System.out.println("----------------");
            System.out.println(matcher2.group(1));
        }

        System.out.println("----------------");

        // Использование режима (?x) позволяет использовать в паттерне пробелы и комментарии,
        // которые будут игнорироваться
        String regex3 = "([\\w]+)   #comment";
        Pattern pattern3 = Pattern.compile(regex3, Pattern.COMMENTS);
        Matcher matcher3 = pattern3.matcher("Abc 234242 def 6464564 fgh 45647474");

        while (matcher3.find()) {
            System.out.println(matcher3.group(1));
        }

    }
}
