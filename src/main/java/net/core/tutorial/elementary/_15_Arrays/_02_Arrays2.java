package net.core.tutorial.elementary._15_Arrays;

import java.util.Arrays;
import java.util.List;

/**

 Методы утилитарного класса java.util.Arrays

 Класс содержит статические утилитарные методы для работы с массивами, такие как сортировка и поиск по массиву.
 Также содержит статическую фабрику (паттерн Abstract Factory) (метод .asList()), чтобы можно было создавать List
 на основе массива.

 Содержит набор перегруженных методов .sort() для массивов всех примитивных типов данных. Для каждого типа есть по
 две реализации метода – с одним аргументом (массивом), а также с указанием начального и конечного индекса в массиве,
 по которым надо  сортировать. Во всех случаях вызывается метод быстрой сортировки DualPivotQuicksort.sort().

 Для сортировки массивов объектов имеется набор перегруженных методов .sort() на основе метода сортировки
 слиянием LegacyMergeSort(). Также есть типизированный дженериками метод .sort() на основе LegacyMergeSort()
 и с использованием Comparator.

 Имеется метод бинарного поиска .BinarySearch() для массивов всех примитивных типов данных и объектов, а также метод,
 типизированный дженериками с использованием Comparator. Есть по две реализации каждого метода – с одним аргументом
 (массивом), а также с указанием начального и конечного индекса в массиве, по которым надо сортировать.

 Имеется набор перегруженных методов .equals() для массивов всех примитивных типов данных и объектов, сравнивающий
 объекты по содержимому. Возвращается boolean.

 Имеется набор перегруженных методов вида:
 .fill(int[] a, int val);
 для массивов всех примитивных типов данных и объектов, позволяющий вставить фиксированное значение val во все
 элементы массива. Имеется и другая реализация, где указывается начальный и конечный индекс массива,
 куда будет выполняться вставка значений val.

 Имеется набор перегруженных методов вида:
 .copyOf(int[] original, int newLength);
 для массивов всех примитивных типов данных, а также метод типизированный дженериками. Возвращает копию
 оригинального массива, которая имеет указанную длину. При этом лишние ячейки могут отсекаться, или избыточные
 могут заполняться нулями.

 Имеется набор перегруженных методов вида:
 .copyOfRange(int[] original, int from, int to);
 для массивов всех примитивных типов данных, а также метод типизированный дженериками. Возвращает копию
 оригинального массива от указанного начального до указанного конечного индекса минус 1.

 Имеется набор перегруженных методов:
 .hashCode();
 для массивов всех примитивных типов данных и объектов. Возвращает 0 если аргумент равен null, или int хэш код,
 рассчитанный по содержимому массива (по Блоху). Поэтому, если, например, массив int[] поместить в hashSet, то при
 сравнении двух сетов массивов, они будут сравниваться по содержимому (сначала по хеш коду, а затем, имеющие
 одинаковый хеш код, по .equals()).

 .deepHashCode(Object[] obj) – сам определяет тип аргумента через instanceof и использует подходящий метод.

 .deepEquals(Object[] a, Object[] b) – статический метод, сравнение содержимого двух массивов. Сам определяет тип аргумента
 через instanceof и использует подходящий метод.

 Имеется набор перегруженных методов вида:
 .toString(int[] a);
 для массивов всех примитивных типов данных и объектов. Возвращает красивую String для каждого типа данных, полученную при
 помощи StringBuilder, а для массива объектов ещё и String.valueOf(a[i]).

 .deepToString(Object[] a) – сам определяет тип аргумента через instanceof и использует подходящий метод.

 */
public class _02_Arrays2 {

    public static void main(String[] args) {

        // Метод возвращает типизированный дженериками List<T> = new ArrayList<>(a)
        // и позволяет задавать List таким же удобным способом, каким задаётся налету массив:
        List<String> list = Arrays.asList("A", "BB", "CCC");

        int[] numbersInArray = {10, 5, 7, 9, 14, -5, 0, -12};
        System.out.println("Исходный массив: " + Arrays.toString(numbersInArray));
        Arrays.sort(numbersInArray);

        System.out.println("Отсортированный массив: " + Arrays.toString(numbersInArray));
        System.out.println("------------------------------ ");

        String[] stringsInArray = {"I am", "You are", "He is", "They are", "We are", "Aren't yet"};
        System.out.println("Исходный массив: " + Arrays.toString(stringsInArray));
        Arrays.sort(stringsInArray);

        System.out.println("Отсортированный массив: " + Arrays.toString(stringsInArray));
        System.out.println("------------------------------ ");

        // Метод binarySearch возвращает индекс позиции в массиве, на которой располагается искомое значение.
        // Метод имеет смысл применять к отсортированному массиву.
        // Если массив не содержит заданного значения, то метод вернёт отрицательное число, модуль которого минус 1
        // укажет индекс позицции, на которой следует расположить заданное число, чтобы не нарушить сортировки
        System.out.println("Массив содержит заданное число на позиции " + Arrays.binarySearch(numbersInArray, 9));
        System.out.println("Массив содержит заданное число на позиции " + Arrays.binarySearch(numbersInArray, 11));
        System.out.println("------------------------------ ");

        int[] numbersInArray2 = {10, 5, 7, 9, 14, -5, 0, -12};
        Arrays.sort(numbersInArray2);
        System.out.println("Сравнение по ссылкам двух массивов даёт " + numbersInArray.equals(numbersInArray2));
        System.out.println("Сравнение по содержимому двух массивов даёт " + Arrays.equals(numbersInArray, numbersInArray2));
        System.out.println("------------------------------ ");

        Arrays.fill(numbersInArray2, 100);
        System.out.println("Массив заполнен одинаковыми значениями: " + Arrays.toString(numbersInArray2));
        System.out.println("------------------------------ ");

        int[] numbersInArray3 = Arrays.copyOf(numbersInArray2, 5);
        System.out.println("Копирование массива в массив меньшей длины: " + Arrays.toString(numbersInArray3));
        int[] numbersInArray4 = Arrays.copyOf(numbersInArray2, 20);
        System.out.println("Копирование массива в массив большей длины: " + Arrays.toString(numbersInArray4));

        // Копирование части массива начиная с указаного начального индекса и до конечного индекса минус 1
        int[] numbersInArray5 = Arrays.copyOfRange(numbersInArray, 3, 7);
        System.out.println("Копирование части массива: " + Arrays.toString(numbersInArray5));
        System.out.println("------------------------------ ");

        // Хэш коды одинаковых по содержанию массивов равны при сравнении с использованием Arrays.hashcode()
        String[] stringsInArray2 = {"I am", "You are", "He is", "They are", "We are", "Aren't yet"};
        System.out.println("Хэш коды разных массивов равны? : " + (stringsInArray.hashCode() == stringsInArray2.hashCode()));
        System.out.println("Хэш коды разных массивов с разным содержанием равны? : " + (Arrays.hashCode(stringsInArray) == Arrays.hashCode(stringsInArray2)));
        Arrays.sort(stringsInArray2);
        System.out.println("Хэш коды разных массивов с одинаковым содержанием равны? : " + (Arrays.hashCode(stringsInArray) == Arrays.hashCode(stringsInArray2)));
        System.out.println("------------------------------ ");
    }
}