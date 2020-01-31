package net.core.tutorial.elementary._16_String;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**

 Объект String – это потокобезопасный (thread-safe) объект, т.к. он immutable.
 В классе String имеются методы для сравнения и объединения символьных строк,
 поиска в них подстрок и изменения регистра символов.
 Классы String, StringBuffer и StringBuilder реализуют интерфейс CharSequence, в котором объявлены методы:
 .length();
 .charAt(int index); – выборка чара по индексу
 .subSequence(int start, int end); – возвращает подстроку, делегирует работу методу .substring()
 .toString();
 Класс String также реализует интерфейс Comparable, в котором объявлен метод .compareTo(T o).

 */

public class _01_String1_Constructors {

    public static void main(String[] args) {

        // Варианты конструкторов:
        // Создание пустой строки. Данный конструктор лучше не использовать, т.к. всегда создаётся новый объект.
        String s1 = new String();

        // Инициализация строки символами из массива chars от символа с номером index,
        // длина фрагмента – numberChars. Символы между пустыми ячейками слипаются
        char[] chars = new char[10];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[7] = 'c';
        chars[8] = 'd';
        chars[9] = 'e';
        String s2 = new String(chars);
        System.out.println("s2 = " + s2);
        String s3 = new String(chars, 1, 3);
        System.out.println("s3 = " + s3);

        // Создание строки из массива байт с использованием дефолтной кодировки (UTF-8 для IntelliJ IDEA)
        byte[] bytes = {0x57, 0x6f, 0x72, 0x6c, 0x64};
        String s4 = new String(bytes);
        System.out.println("s4 = " + s4);

        // Можно задать кодировку в явном виде:
        String s5 = new String(bytes, Charset.forName("utf-8"));
        System.out.println("s5 = " + s5);
        String s6 = null;
        try {
            s6 = new String(bytes,"latin1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("s6 = " + s6);
        String s7 = new String(bytes, Charset.forName("cp1251"));
        System.out.println("s7 = " + s7);

        byte[] bytes2 = {(byte)0xCA, (byte)0xEE, (byte)0xE4};
        String s8 = new String(bytes2, Charset.forName("cp1251"));
        System.out.println("s8 = " + s8);
        String s9 = new String(bytes2, Charset.forName("UTF-8"));
        System.out.println("s9 = " + s9);

        // Копирующий конструктор. Создаёт новый объект String, в котором содержаться те же символы,
        // что и в объекте, переданном в аргументе.
        // До Java 6 использовался для того, чтобы на основе результата выполнения .substring(),
        // который передавался в конструктор в виде аргумента, создать новый объект,
        // не связанный с исходной строкой. В Java 7 .substring() и так создаёт новый независимый объект,
        // поэтому копирующий конструктор больше не актуален.
        String s10 = new String(s8);

        // Строка это immutable object, поэтому любые манипуляции со строкой не могут изменить исходную строку:
        String s11 = "abc";
        System.out.println("s11 = " + s11.concat("def"));
        System.out.println("s11 = " + s11);

        String s12 = "abcdef";
        System.out.println("s12 = " + s12.replace('b', 'g'));
        System.out.println("s12 = " + s12);
    }
}
