package net.core.tutorial.elementary._08_PrimitiveTypes;

/**

 Примеры приведения примитивных типов

 */
public class _04_PrimitiveTypes4 {

    public static void main(String[] args) {

        // Арифметические операции с целыми числами могут привести к выходу за пределы диапазона
        // и автоматическому циклическому сдвигу
        System.out.println("Integer.MAX_VALUE + 1 = " + (Integer.MAX_VALUE + 1));
        System.out.println("Short.MAX_VALUE + 1 = " + (Short.MAX_VALUE + 1)); // сложение short + int даст int
        System.out.println("Long.MAX_VALUE + 1 = " + (Long.MAX_VALUE + 1));
        System.out.println("--------------------------");

        // Арифметические операции с вещественными типами при выходе числа за пределы диапазона могут привести
        // к получению Infinity или –Infinity. Также может быть получено NaN (не число).
        // При вычислениях при помощи вещественных чисел результат может отличаться от ожидаемого
        // (например, не 0.9, а 0.8999999999).
        System.out.println("Double.MAX_VALUE + Double.MAX_VALUE = " + (Double.MAX_VALUE + Double.MAX_VALUE));
        System.out.println("Double.MAX_VALUE - 3*Double.MAX_VALUE = " + (Double.MAX_VALUE - 3*Double.MAX_VALUE));
        System.out.println("0.9 / 0 = " + (0.9/0));
        System.out.println("0.0 / 0 = " + (0.0/0));
        System.out.println("--------------------------");

        // В то же время деление целого числа на нуль приводит к ArithmeticException
        try{
            int a = 99;
            int b = a / 0;
        }
        catch (ArithmeticException e){
            System.out.println("Перехвачено исключение ArithmeticException");
        }

        System.out.println("--------------------------");

        //При делении целочисленных чисел остаток отбрасывается.
        //Для получения остатка при делении целых вещественных типов можно использовать оператор %
        System.out.println("Результат деления 7/2 = " + (7/2));
        System.out.println("Результат деления 11%3 = " + (11%3));

        System.out.println("--------------------------");

        // Инкремент/декремент применяется только к переменной целого или вещественного типа, не к числу и не к выражению.
        // И при его использовании автоматически выполняется приведение типа (при необходимости).

        byte x = 1;
        x++; // эквивалентно x = (byte) (x+1);
        System.out.println("x = " + x);

        int y = 2;
        y+=2.5; // эквивалентно x = (int) (x+2.5);
        System.out.println("y = " + y);  // ответ 4, т.к. дробная часть отбрасывается

        // При инкременте/декременте важную роль играет расположение оператора
        System.out.println("x++ = " + (x++));  // сначала вычисления, а затем инкремент
        System.out.println("++y = " + (++y));  // сначала инкремент, а затем вычисления
    }
}
