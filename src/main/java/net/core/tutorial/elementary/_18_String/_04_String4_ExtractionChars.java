package net.core.tutorial.elementary._18_String;

import java.nio.charset.Charset;

/**

 Извлечение символов из строки.

 Выборка чара по индексу
 .charAt(int index);

 Извлечение нескольких символов из строки от индекса indexOn до индекса indexEnd-1.
 Результат помещается в массив чаров sink, начиная с индекса indexOnSink.
 .getChars(int indexOn, int indexEnd, char[] sink, int indexOnSink);

 Преобразование символов строки в массив байт и возвращение ссылки на byte[].
 .getBytes();

 Преобразование символов строки в символьный массив и возвращение ссылки на char[].
 .toCharArray();

 */

public class _04_String4_ExtractionChars {

    public static void main(String[] args) {

        // Выборка чара по индексу
        String s1 = "My world";
        char ch1 = s1.charAt(5);
        System.out.println("ch1 = " + ch1);

        // Извлечение нескольких символов из строки
        String s2 = "This is a little peculiar.";
        char[] sink = {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*', '*'};
        s2.getChars(5, 16, sink, 3);
        System.out.println("sink = " + new String(sink));

        System.out.println("--------------------");

        byte[] bytes = "ABCDE".getBytes(Charset.forName("utf16"));
        System.out.println(bytes);

        System.out.println("--------------------");

        char[] chars = "ABCDE".toCharArray();
        System.out.println(new String(chars));
    }
}
