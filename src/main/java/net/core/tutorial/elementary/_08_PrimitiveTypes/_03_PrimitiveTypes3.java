package net.core.tutorial.elementary._08_PrimitiveTypes;

/**

 Целые числа можно записывать в различных системах счисления:
 - как восьмиричное число. Первый символ 0, например, 053 (может быть и больше нулей слева).
 Присвоение такого восьмиричного числа переменной int приведёт к автоматическому преобразованию в десятичное 43.

 - как 16-тиричное число. Первые символы 0x, например, 0x0053 (правильным будет написать и так 0x053, 0x53).
 Присвоение такого 16-ти ричного числа переменной int приведёт к автоматическому преобразованию в десятичное 83.

 - как двоичное число. Первые символы 0b, например, 0b01111. Присвоение такого двоичного числа переменной int
 приведёт к автоматическому преобразованию в десятичное 15.

 Вещественные числа можно записать в экспоненциальной форме (с использование десятичной или бинарной
 экспоненты и десятичных или 16-тиричных чисел соответственно).
 Например:
 1.23e23 ===1.23*10^23        // число в формате Double
 1.23e23D ===1.23*10^23       // число в формате Double
 1.23e-23F === 1.23*10^(-23)  // число в формате Float
 0x24p1                       // число в формате Double
 0x31.23p-3F === ((3*16^1) + (1*16^0) + (2*16^-1) + (3*16^-2)) * 2^(-3)  // число в формате Float

 Методы:
 -	Integer.toBinaryString(int i);
 -	Integer.toHexString(int i);
 -	Integer.toOctalString(int i)
 позволяют записать число в различных системах счисления.

 */
public class _03_PrimitiveTypes3 {

    public static void main(String[] args) {

        double value1 = 1.23e23;
        double value2 = 1.23e23D;
        float value3 = 1.23e-23F;
        double value4 = 0x24p1;
        float value5 = 0x31.23p-3F;
        int value6 = 053;
        int value7 = 0x0053;
        int value8 = 0b01111;

        System.out.println("Value1 = " + value1 + ", Value2 = " + value2 + ", Value3 = " + value3
                + ", Value4 = " + value4 + ", Value5 = " + value5);
        System.out.println("Value6 = " + value6 + ", Value7 = " + value7 + ", Value8 = " + value8);
        System.out.println("----------------------");

        System.out.println("Integer.toBinaryString(-300) = " + Integer.toBinaryString(-300));
        System.out.println("Integer.toHexString(-300) = " + Integer.toHexString(-300));
        System.out.println("Integer.toOctalString(0300) = " + Integer.toOctalString(-300));

        System.out.println("----------------------");

        // Сложение любого типа со строкой даёт строку. В том числе:
        Integer num = null;
        System.out.println("5" + num);
        System.out.println("5" + 7 + 8);

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four);
    }
}
