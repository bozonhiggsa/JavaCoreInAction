package net.core.tutorial.elementary._08_PrimitiveTypes;

/**
 Приведение примитивных типов.

 В Java у каждого объекта и у каждой переменной есть свой жёстко заданный неизменяемый тип.
 Java это язык с жёсткой статической типизацией. Во время проверки типов на этапе компиляции обнаруживаются самые
 очевидные ошибки (такие ошибки как деление целого числа на нуль компилятор не считает ошибками,
 это исключительные ситуации).
 Тип переменной определяется ещё в процессе компиляции программы, тип объекта – при его создании.
 Тип нового созданного объекта и/или переменной остаются неизменными все время их жизни.
 При взаимодействии переменных двух разных типов, они должны быть сначала преобразованы к одному общему типу.

 Все дробные числа хранятся в памяти в форме: мантисса (значащая часть числа) и экспонента (степень десятки).
 Такой подход позволяет хранить гораздо большие числа, чем int, используя всего 4 байта. Но при этом мы жертвуем
 точностью. Часть памяти расходуется на хранение мантиссы (23 бита для float и 52 бита для double), поэтому такие числа
 хранят всего несколько знаков после запятой, остальные отбрасываются. Такие числа еще называют
 «числа с плавающей точкой (floating point number)». Отсюда и название типа – float.
 Тип double – это такой же тип, как и float, только в два раза длиннее – он занимает восемь байт. И предельный размер
 мантиссы и количество значащих цифр в нем больше.
 Тип int использует 31 бит для хранения модуля числа, поэтому его без потери информации можно преобразовать
 (автоматически) в double. При преобразовании int во float возможна потеря информации (часть значачих цифр отбрасывается).
 При преобразование типа long даже в double возможна потеря информации.

 Тип char – беззнаковый целочисленный тип, позволяющий представить в числовом виде символы Unicode.
 Переменной типа char можно присвоить значение целочисленной константы, если её значение в диапазоне 0-65535.
 При этом переменная будет содержать символ Unicode с кодом, который соответствует целочисленной константе.
 Значения типа char можно интерпретировать и как числа (их можно складывать и умножать) и как символы.
 Так было сделано потому, что хоть символы и имеют визуальное представление, для компьютера они в первую очередь
 просто числа. И работать с ними как с числами гораздо удобнее. Тип char строго положительный – отрицательных значений
 он хранить не может.

 Для процессора удобно работать с числами из 32 разрядов (4 байта) или из 64 разрядов (8 байт). Поэтому любая
 арифметическая операция с числами типов byte, short, char, int даст тип int (один из видов полиморфизма -
 перегрузка операторов).
 Арифметическая операция с любым из вышеперечисленных типов, а также long, даст long.
 Арифметическая операция с любым из вышеперечисленных типов, а также float, даст float.
 Арифметическая операция с любым из вышеперечисленных типов, а также double, даст double.
 Основные типы – это int и float (по 4 байта), а также long и double (по 8 байт).

 */

public class _01_PrimitiveTypes1 {

    // 1 Byte
    byte byteValueMin = Byte.MIN_VALUE;
    byte byteValueMax = Byte.MAX_VALUE;
    // 2 Bytes
    short shortValueMin = Short.MIN_VALUE;
    short shortValueMax = Short.MAX_VALUE;
    // 4 Bytes
    int intValueMin = Integer.MIN_VALUE;
    int intValueMax = Integer.MAX_VALUE;
    // 8 Bytes
    long longValueMin = Long.MIN_VALUE;
    long longValueMax = Long.MAX_VALUE;
    // 4 Bytes
    float floatValueMin = Float.MIN_VALUE;
    float floatValueMax = Float.MAX_VALUE;
    // 8 Bytes
    double doubleValueMin = Double.MIN_VALUE;
    double doubleValueMax = Double.MAX_VALUE;
    // 2 Bytes
    char charValueMin = Character.MIN_VALUE;
    char charValueMax = Character.MAX_VALUE;
    // 1 Bit (in fact 1 Byte)
    boolean booleanValue;

    public static void main(String[] args) {

        _01_PrimitiveTypes1 obj = new _01_PrimitiveTypes1();

        System.out.println("Min value for byte type is: " + obj.byteValueMin + ", Max value is: " + obj.byteValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for short type is: " + obj.shortValueMin + ", Max value is: " + obj.shortValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for int type is: " + obj.intValueMin + ", Max value is: " + obj.intValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for long type is: " + obj.longValueMin + ", Max value is: " + obj.longValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for float type is: " + obj.floatValueMin + ", Max value is: " + obj.floatValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for double type is: " + obj.doubleValueMin + ", Max value is: " + obj.doubleValueMax);
        System.out.println("------------------------------");
        System.out.println("Min value for char type is: " + obj.charValueMin + ", Max value is: " + obj.charValueMax);
        System.out.println("------------------------------");
        System.out.println("Min code point value for char type is: " + Character.MIN_CODE_POINT);
        System.out.println("Max code point value for char type is: " + Character.MAX_CODE_POINT);
        System.out.println("Code point value for char 'w': " + Character.codePointAt("flow".toCharArray(), 3));
        System.out.println("Code point value for char 'w': " + (int)'w');
        System.out.println("Char for code point = 119 is: " + (char)119);
        System.out.println("------------------------------");
        System.out.println("Default value for boolean type is: " + obj.booleanValue);
        System.out.println("------------------------------");

        byte p = 20;
        byte b = 4;
        //byte c = p + b; // ошибка на этапе компиляции - результат операции имеет тип int
        byte c = (byte)(p + b);
        System.out.println("Value c = " + c);
        System.out.println("------------------------------");

        final byte pp = 20;
        final byte bb = 4;
        // Финальные переменные являются константами, а поэтому будут вычислены уже на этапе компиляции:
        byte cc = pp + bb;
        // если бы в выражении была хотя бы одна переменная (не финальная константа), то компилятор выдал бы ошибку)
        System.out.println("Value cc = " + cc);
        System.out.println("------------------------------");
    }
}
