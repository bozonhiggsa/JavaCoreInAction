package net.core.tutorial.elementary._18_String;

/**

 При конкатенации строк с примитивными типами данных последние автоматически преобразуются в String
 (в удобочитаемую форму) при помощи конкретного (для данного типа данных) перегруженного static метода .valueOf().
 Данный метод можно вызвать и самостоятельно, если требуется получить строковое представление разных
 примитивных типов или массива чаров.

 Метод .valueOf() определён в классе String для примитивных типов данных, а также для массива чаров и объекта.
 Для объектов метод .valueOf() вызывает метод .toString() соответствующего объекта
 (проще самому вызвать .toString()).

 Кроме этого, метод .valueOf() определён для всех классов-обёрток базовых типов.
 Если необходимо создать объект Integer, то лучше использовать Integer.valueOf(int a) вместо конструктора
 new Integer(int a), чтобы задействовать кэш.
 Также полезны методы для всех классов обёрток, такие как метод Integer.valueOf(String s),
 который парсит строку (при помощи метода .parseInt()) и возвращает Integer.

 */

public class _03_String3_ValueOf {

    public static void main(String[] args) {

        // Конкатенация строки с примитивными типами данных или с объектом любого класса (и даже с null)
        // всегда даёт строку:
        int age=9;
        String s1 = "Ему " + age + " лет.";
        System.out.println(s1 + null);

        System.out.println("------------------------");

        String s2 = String.valueOf(0xFF);
        System.out.println("s2 = " + s2);
        char[] chars = {'a', 'b', 'c'};
        String s3 = String.valueOf(chars);
        System.out.println("s3 = " + s3);
        String s4 = String.valueOf(-34.4);
        System.out.println("s4 = " + s4);

        System.out.println("------------------------");

        int number1 = Integer.valueOf(100);
        int number2 = Integer.valueOf("333");
        System.out.println("number1 = " + number1 + ", number2 = " + number2);

    }
}
