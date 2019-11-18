package net.core.tutorial.elementary._09_BitwiseOperators;

/**

 Битовые логические и сдвиговые операции.

 Битовые логические операции применяются побитно к целочисленным переменным/константам.

 | побитовое ИЛИ (а также булева логическая операция ИЛИ по полной схеме)
 & побитовое И (а также булева логическая операция И по полной схеме)
 ^ побитовое XOR (а также булева логическая операция XOR)
 ~ отрицание (унарный оператор, применяется к целочисленной переменной/константе,
 не используется с булевыми переменными/константами).

 Приоритет битовых логических операций:
 ~
 &
 ^
 |

 << сдвиг влево
 Все биты смещаются влево. Двоичный код числа дополняется нулем справа. Операция используется для быстрого умножения на 2.
 Если оператор применяется к числу, умножение на 2 которого будет больше максимального значения int (2147483647),
 то в результате будет отрицательное число. Это происходит потому, что крайний левый бит, который отвечает за знак числа,
 выставляется в единицу, что соответствует отрицательным числам.

 >> сдвиг вправо
 Все биты смещаются вправо. Двоичный код числа дополняется нулем слева, если число положительное и единицей, если отрицательное.
 Операция используется для быстрого деления на 2. Если делится нечетное число, то остаток отбрасывается для положительных
 чисел и увеличивается до целого для отрицательных.

 >>> беззнаковый сдвиг вправо
 Все биты смещаются вправо, число слева дополняется нулем, даже если операция выполняется с отрицательными числами.
 Отсюда и название оператора – беззнаковый. В результате применения оператора всегда получается положительное число, т.к. в Java
 крайний левый бит отвечает за знак числа. Операция так же, как и знаковый оператор сдвига вправо, соответствует делению
 числа на два за исключением первого сдвига в отрицательном числе.

 */

public class _01_BitwiseOperators1 {

    public static void main(String[] args) {

        final byte value1 = 12;
        final byte value2 = 5;
        System.out.println("Двоичное представление десятичного " + value1 + ": " + Integer.toBinaryString(value1));
        System.out.println("Двоичное представление десятичного " + value2 + ": " + Integer.toBinaryString(value2));
        System.out.println("В результате операции & получено десятичное " + (value1 & value2) + ": " + Integer.toBinaryString(value1 & value2));
        System.out.println("В результате операции | получено десятичное " + (value1 | value2) + ": " + Integer.toBinaryString(value1 | value2));
        System.out.println("----------------------------------");

        byte num1 = 127;
        System.out.println("Двоичное представление десятичного " + num1 + ": " + Integer.toBinaryString(num1));
        System.out.println("В результате операции ~ получено десятичное " + (~num1) + ": " + Integer.toBinaryString(~num1));
        byte num2 = -127;
        System.out.println("Двоичное представление десятичного " + num2 + ": " + Integer.toBinaryString(num2));
        System.out.println("В результате операции ~ получено десятичное " + (~num2) + ": " + Integer.toBinaryString(~num2));

        System.out.println("----------------------------------");

        byte num3 = -123;
        System.out.println("Двоичное представление десятичного " + num3 + ": " + Integer.toBinaryString(num3));
        System.out.println("В результате операции << получено десятичное " + (num3<<1) + ": " + Integer.toBinaryString(num3<<1));

        System.out.println("----------------------------------");

        byte num4 = -123;
        System.out.println("Двоичное представление десятичного " + num4 + ": " + Integer.toBinaryString(num4));
        System.out.println("В результате операции >> получено десятичное " + (num4>>1) + ": " + Integer.toBinaryString(num4>>1));

        System.out.println("----------------------------------");

        byte num5 = -123;
        System.out.println("Двоичное представление десятичного " + num5 + ": " + Integer.toBinaryString(num5));
        System.out.println("В результате операции >>> получено десятичное " + (num5>>>1) + ": " + Integer.toBinaryString(num5>>>1));

        System.out.println("----------------------------------");

        // Важно помнить, что когда количество сдвигов достигает количества разрядов, то следующий сдвиг вернет
        // значение в исходное состояние
        int num6 = 0x80000000;
        System.out.println("Двоичное представление 16-тиричного 0x80000000, десятичного " + num6 + ": " + Integer.toBinaryString(num6));
        System.out.println("В результате операции >>1 получено десятичное " + (num6>>1) + ": " + Integer.toBinaryString(num6>>1));
        System.out.println("В результате операции >>2 получено десятичное " + (num6>>2) + ": " + Integer.toBinaryString(num6>>2));
        System.out.println("В результате операции >>31 получено десятичное " + (num6>>31) + ": " + Integer.toBinaryString(num6>>31));
        System.out.println("В результате операции >>32 получено десятичное " + (num6>>32) + ": " + Integer.toBinaryString(num6>>32));

        System.out.println("----------------------------------");

        // Приведение чисел к соответствующему типу данных.
        // При использовании побитовых операций с типами данных byte/short числа сначала приводятся к типу int,
        // а если одно из чисел – long, то к long
        int number1 = Integer.MAX_VALUE;
        long number2 = Long.MAX_VALUE;
        System.out.println("Двоичное представление десятичного int = " + number1 + ": " + Integer.toBinaryString(number1));
        System.out.println("Двоичное представление десятичного long = " + number2 + ": " + Long.toBinaryString(number2));
        System.out.println("В результате операции number1&number2 получено десятичное " + (number1 & number2) + ": " + Long.toBinaryString(number1 & number2));
        System.out.println("В результате операции number2&number2 получено десятичное " + (number2 & number2) + ": " + Long.toBinaryString(number2 & number2));

        System.out.println("----------------------------------");

        //При сужении типа данных, левая часть битов просто отбрасывается, например:
        long fullNumber = -9223372032559808513L;
        int cuttingNumber = (int) fullNumber;
        System.out.println("Двоичное представление десятичного long = " + fullNumber + ": " + Long.toBinaryString(fullNumber));
        System.out.println("Двоичное представление урезанного long в виде десятичного int = " + cuttingNumber + ": " + Integer.toBinaryString(cuttingNumber));
    }
}