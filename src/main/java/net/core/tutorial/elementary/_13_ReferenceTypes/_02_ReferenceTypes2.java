package net.core.tutorial.elementary._13_ReferenceTypes;

import java.io.Serializable;

/**

 Для избежания ошибок при приведении ссылочных типов переменных можно использовать оператор instanceof,
 который имеет вид:
 a instanceof B
 object instanceof name_of_type
 Оператор instanceof вернет значение true, если:
 1. переменная а хранит ссылку на объект класса B.
 2. переменная а хранит ссылку на объект класса наследника от B (т.е. здесь B предок).
 3. переменная а хранит ссылку на объект, класс которого реализует интерфейс B.
 Иначе оператор instanceof вернет значение false.
 Таким образом, instanceof вернёт true и в случае сужения типа и в случае реализации объектом интерфейса,
 а false вернёт в случае, когда расширяемся чрезмерно (т.е. когда B – наследник), а также в случае,
 если вообще нет прямой родственной связи.

 */

public class _02_ReferenceTypes2 {

    public static void main(String[] args) {

        B1 b1 = new B2();
        B2 b2 = new B2();
        B3 b3 = new B3();
        B4 b4 = new B4();
        System.out.println("Переменная b1 хранит ссылку на экземпляр класса B2: " + (b1 instanceof B2) );
        System.out.println("Переменная b2 хранит ссылку на экземпляр класса B3: " + (b2 instanceof B3) );
        System.out.println("Переменная b3 хранит ссылку на экземпляр класса B3: " + (b3 instanceof B3) );
        System.out.println("Переменная b3 хранит ссылку на экземпляр класса B1: " + (b3 instanceof B1) );
        System.out.println("Переменная b4 хранит ссылку на реализацию интерфейса Serializable: " + (b4 instanceof Serializable) );

        System.out.println("---------------------------------------------");
        Object o = 123; // После появления Autoboxing это больше не является ошибкой
        System.out.println(o.toString());

        try{
            float f = (float) o;   // ошибка!!!
        }
        catch (ClassCastException e){
            System.out.println("Возникло исключение ClassCastException - тип Integer не является наследником типа Float");
        }

        // Нельзя приводить массивы примитивных типов. Например:
        // long[] arr = new int[] {1, 2, 3};  // ошибка компиляции

        // Но можно использовать полиморфизм применительно к массивам ссылочных типов:
        System.out.println("---------------------------------------------");
        B1[] arrB1 = new B3[10];
        System.out.println(arrB1);
    }
}

class B1 {}

class B2 extends B1 {}

class B3 extends B2 {}

class B4 implements Serializable {}