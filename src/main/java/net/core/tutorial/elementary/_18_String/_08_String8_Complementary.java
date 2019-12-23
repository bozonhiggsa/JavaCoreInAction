package net.core.tutorial.elementary._18_String;

/**

 Дополнительные методы.

 .contains(CharSequence s1);
 возвращает true, если строка содержит указанную последовательность чаров.

 .contentEquals(CharSequence s1);
 возвращает true, если строка содержит указанную последовательность чаров.

 .contentEquals(StringBuffer s1);
 возвращает true, если строка содержит указанную последовательность чаров.

 .isEmpty();
 возвращает true, если строка не содержит символы и имеет нулевую длину.

 */

public class _08_String8_Complementary {

    public static void main(String[] args) {

        System.out.println("Hello, world!".contains("world"));
        System.out.println("Hello, world!".contentEquals("world"));
        System.out.println("Hello, world!".contentEquals("Hello, world!"));
        System.out.println("Hello, world!".isEmpty());
        System.out.println("".isEmpty());
    }
}
