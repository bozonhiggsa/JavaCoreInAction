package net.core.tutorial.elementary._08_PrimitiveTypes;

/**

 При сужении примитивного типа мы должны явно показать компилятору, что мы не ошиблись и отбрасывание части числа
 сделано намеренно. Для этого используется оператор приведения типа - имя типа в круглых скобках. Он действует
 только на число/переменную, которое идет непосредственно за ним.
 При преобразовании из целых чисел в дробные, могут отбрасываться самые младшие части числа. Но т.к. смысл дробного
 числа в том, чтобы хранить приблизительное значение, то такое присваивание разрешается.
 char занимает 2 байта, как и short, но свободно преобразовывать (без явного приведения типа) из одного типа в другой
 нельзя: при преобразовывании значения из short в char, всегда будут теряться значения < 0. При преобразовывании
 из char в short будут теряться значения > 32767.

 */
public class _02_PrimitiveTypes2 {

    public static void main(String[] args) {

        // Расширение примитивного типа происходит автоматически.
        // Компилятор автоматически преобразовывает целые числа в тип, указанный в качестве типа переменной,
        // если эти числа умещаются в его диапазон. Поэтому возможны такие конструкции:

        byte value1 = 120;
        byte value2 = 'd';
        char charValue = 100;
        long value3 = 100000;
        //long value4 = 10000000000; // ошибка - число выходит за пределы int
        long value4 = 10000000000L;
        short value5 = value1;
        float value6 = Integer.MAX_VALUE;

        System.out.println("Value1 = " + value1 + ", Value2 = " + value2 + ", Value3 = " + value3
                + ", Value4 = " + value4 + ", Value5 = " + value5 + ", Value6 = " + value6);

        System.out.println("charValue = " + charValue);

        charValue = (char) value5;
        System.out.println("charValue = " + charValue);
    }
}
