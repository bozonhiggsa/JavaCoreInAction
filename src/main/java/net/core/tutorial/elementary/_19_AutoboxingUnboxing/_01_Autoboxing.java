package net.core.tutorial.elementary._19_AutoboxingUnboxing;

/**

 Каждому примитивному типу в Java соответствует класс-обёртка:
 byte – Byte extends Number extends Object;
 short – Short extends Number extends Object;
 int – Integer extends Number extends Object;
 long – Long extends Number extends Object;
 float – Float extends Number extends Object;
 double – Double extends Number extends Object;
 char – Character extends Object;
 boolean – Boolean extends Object;
 void (псевдотип) – Void extends Object.

 Autoboxing (автоупаковка).
 Это автоматическая инкапсуляция примитивного типа в эквивалентную ему класс-обёртку всякий раз,
 когда требуется объект данного типа.

 Autoboxing происходит:
 - при присвоении значения примитивного типа переменной соответствующего класса-обёртки;
 - при передаче примитивного типа в параметр метода, ожидающего соответствующий ему класс-обёртку.

 */

public class _01_Autoboxing {

    public static void main(String[] args) {

        // До JDK 1.5 необходимо было явно указывать преобразование примитивного типа к типу класса-обёртки
        Integer iOb = new Integer(7);
        Double dOb = new Double(7.0);
        Character cOb = new Character('a');
        Boolean bOb = new Boolean(true);

        someMethod(new Integer(7));

        // Начиная с JDK 1.5 автоупаковка происходит автоматически
        Integer iOb2 = 7; // неявно вызывается Integer.valueOf(int i)
        Double dOb2 = 7.0; // неявно вызывается Double.valueOf(double i)
        Character cOb2 = 'a'; // неявно вызывается Character.valueOf(char i)
        Boolean bOb2 = true; // неявно вызывается Boolean.valueOf(boolean i)

        someMethod(7);

    }

    public static void someMethod(Integer iOb) {
        System.out.println("Integer");
    }
}
