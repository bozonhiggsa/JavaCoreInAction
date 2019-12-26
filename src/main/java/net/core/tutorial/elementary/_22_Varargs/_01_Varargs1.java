package net.core.tutorial.elementary._22_Varargs;

import java.util.Arrays;
import java.util.List;

/**

 Varargs.
 Позволяет использовать любое количество аргументов в методе.

 Например, библиотека Arrays содержит метод

 public static <T> List<T> asList(T... a) {
 return new ArrayList<>(a);
 }

 Данный метод возвращает реализацию List фиксированного размера. С помощью метода можно неявно создать
 ArrayList и задать его значения тем же способом, который обычно используется для массивов. Например:

 List<Integer> list = Arrays.asList(1, 12, 24);
 или
 List<String> list = Arrays.asList(“Hello”, “By”, “Welcome”);

 Varargs может быть только один из аргументов и только последний из аргументов. Если Varargs это
 последний из аргументов, то при вызове метода его можно не вводить в качестве конкретного аргумента
 (как будто это массив нулевой длины).

 Varargs это всё равно, что аргумент метода в виде массива неопределённой длины.
 При этом метод можно вызвать с разным количеством аргументов.

 */

public class _01_Varargs1 {

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 12, 24);
        List<String> list2 = Arrays.asList("Hello", "By", "Welcome", "See you later!");
        System.out.println(list1);
        System.out.println(list2);

        System.out.println("---------------------");

        new _01_Varargs1().someMethod("Red", 1, 2, 3 ,4);
        new _01_Varargs1().someMethod("Blue", 100, 300);
        new _01_Varargs1().someMethod("Yellow", new int[]{22, 33, 44});
        new _01_Varargs1().someMethod("Orange");


    }

    public void someMethod(String label, int... numbers){

        for (int number: numbers) {
            System.out.println(label + ": " + number);
        }
        System.out.println("---------------------");
    }
}
