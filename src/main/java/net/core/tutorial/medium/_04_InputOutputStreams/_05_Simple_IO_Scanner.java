package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;

/**

 Scanner.

 На данный момент класс Scanner представляет собой один из наиболее удобных и полных способов
 для извлечения информации практически из любых источников (строка, файл, входной поток и т.д.).

 Некоторые конструкторы класса:

 Scanner(String source)
 Scanner(File source) throws FileNotFoundException
 Scanner(File source, String charset) throws FileNotFoundException
 Scanner(InputStream source)
 Scanner(InputStream source, String charset)
 Scanner(Path source)
 Scanner(Path source, String charset)

 Здесь вторым аргументом конструктора в Scanner можно передать кодировку, в которой
 представлена символьная информация.
 Объект класса Scanner читает лексемы из источника, указанного в конструкторе.
 Лексема – это набор символов, ограниченный набором разделителей (по умолчанию пробельными символами).
 Границы лексемы определяются на основе набора разделителей. Можно задавать разделители с помощью метода

 .useDelimiter(Pattern pattern);

 или

 useDelimiter(String regex);

 где pattern и regex содержит набор разделителей в виде регулярного выражения. Например:

 scan.useDelimiter(";\\s*");

 Применение метода .useLocale(Locale loc) позволяет задавать правила чтения информации,
 принятые в заданной стране или регионе.

 В классе Scanner определены группы методов, проверяющих доступность данных конкретного
 типа для чтения. Для проверки наличия произвольной лексемы используется метод .hasNext().
 Проверка конкретного типа производится с помощью одного из методов вида boolean hasNextInt().
 Если данные указанного типа доступны, то они могут быть считаны с помощью одного из методов вида .nextInt().
 Произвольная лексема считывается методом

 String next()

 После извлечения любой лексемы текущий указатель устанавливается перед следующей лексемой.

 */
public class _05_Simple_IO_Scanner {

    private static String FILE_NAME = "text\\scan.txt";

    public static void main(String[] args) {

        scan1();
        System.out.println("-----------------");
        scan2();
    }

    public static void scan1() {

        Scanner scan = null;
        try {
            InputStreamReader streamReader = new InputStreamReader(new FileInputStream(FILE_NAME));
            scan = new Scanner(streamReader);
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    System.out.println(scan.nextInt() + " :int");
                } else if (scan.hasNextBoolean()) {
                    System.out.println(scan.nextBoolean() + " :boolean");
                } else if (scan.hasNextDouble()) {
                    System.out.println(scan.nextDouble() + " :double");
                } else {
                    System.out.println(scan.next() + " :String");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } finally {
            if (scan != null) {
                scan.close();
            }
        }
    }

    public static void scan2() {

        double sum = 0.0;
        Scanner scan = new Scanner("1,3;2,0; 8,5; 4,8;9,0; 1; 10;");
        // если заменить Locale на американскую, то результат будет иным, так как представление чисел
        // с плавающей точкой отличается.
        // использование регулярного выражения ";\\s*" указывает объекту класса Scanner,
        // что символ «;» и ноль или более пробелов следует рассмативать как разделитель.
        scan.useLocale(Locale.FRANCE);
        //scan.useLocale(Locale.US);
        scan.useDelimiter(";\\s*");
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                sum += scan.nextDouble();
            } else {
                System.out.println(scan.next());
            }
        }
        scan.close();
        System.out.printf("Сумма чисел = " + sum);
    }
}
