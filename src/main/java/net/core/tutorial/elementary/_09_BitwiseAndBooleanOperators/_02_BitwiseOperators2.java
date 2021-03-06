package net.core.tutorial.elementary._09_BitwiseAndBooleanOperators;

/**

 Использование маски.

 Одним из приемов работы с битовыми данными является использование маски. Маска позволяет получать значения
 только определенных битов в последовательности. Например, у нас есть маска 00100100, она позволяет нам получать
 из последовательности только те биты, которые в ней установлены. В данном случае это 3-й и 7-й разряд.
 Для этого достаточно выполнить побитовое И с нашей маской и неким числом:

 01010101
 &
 00100100
 =
 00000100

 Хранение в одной целочисленной переменной нескольких значений.

 При помощи битовых сдвигов можно хранить в одной целочисленной переменной несколько значений меньшей длины.
 Например, в первых нескольких битах можно хранить одно число, в следующих битах – другое. Требуется только
 знать, на сколько бит выполняется сдвиг и сколько бит занимает хранимое число. Для записи используется
 логическое ИЛИ, для получения – И.
 В примере в одном числе сохраняются три значения – возраст, рост, вес, а затем считываются из него.
 Недостатком такой системы является необходимость помнить, что хранимые значения не должны превышать количество бит,
 которые определены для них. Например, если в примере одно из значений будет превышать число 255, то мы
 получим ошибочный результат.

 */

public class _02_BitwiseOperators2 {

    public static void main(String[] args) {

        int age, height, weight, combined, mask;
        age = 28; //00011100
        System.out.println("Двоичное представление десятичного age = " + age + ": " + Integer.toBinaryString(age));
        height = 185; //10111001
        System.out.println("Двоичное представление десятичного height = " + height + ": " + Integer.toBinaryString(height));
        weight = 80; //01010000
        System.out.println("Двоичное представление десятичного weight = " + weight + ": " + Integer.toBinaryString(weight));
        combined = (age) | (height << 8) | (weight << 16); //00000000 01010000 10111001 00011100
        System.out.println("Двоичное представление десятичного combined = " + combined + ": " + Integer.toBinaryString(combined));

        mask = 0b11111111;

        System.out.println("----------------------------------------");

        // Извлечение данных из общего int
        System.out.println("Извлечение данных из общего int:");
        System.out.printf("age: %d, height: %d, weight: %d",
                mask & combined,
                mask & combined >>> 8,
                mask & combined >>> 16);
    }
}