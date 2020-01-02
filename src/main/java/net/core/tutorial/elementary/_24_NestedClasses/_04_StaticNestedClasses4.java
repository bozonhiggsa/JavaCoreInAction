package net.core.tutorial.elementary._24_NestedClasses;

/**

 static nested классы.

 static nested класс может содержать как статические, так и нестатические переменные и методы.

 К статическим переменным и методам static nested класса можно обратиться просто по имени данного класса
 (не создавая его объект), а можно от имени одного из его объектов. Помня, что значение статической переменной
 является общим для всех объектов данного класса.
 К нестатическим переменным и методам static nested класса можно обратиться только создав его объект (можно анонимный).
 Синтаксис создания объекта static nested класса Engine:

 Ship.Engine obj = new Ship.Engine();

 Объект static nested класса можно создать даже в том случае, если объект внешнего класса не создан.
 Поэтому static nested класс не видит напрямую нестатических переменных внешнего класса, ведь объекта внешнего
 класса может не быть. А статические переменные видит напрямую, ведь они инициализируются вне зависимости
 от создания объекта.
 Практически, поскольку static nested класс не имеет прямого доступа к нестатическим переменным внешнего класса,
 то весь его функционал опирается лишь на его внутреннюю логику и внутренние поля.

 static nested классы имеют право наследовать другие классы, реализовывать интерфейсы и выступать
 в роли объектов наследования.

 Если класс вложен в интерфейс, то он становится статическим по умолчанию.

 */

public class _04_StaticNestedClasses4 {

    public static void main(String[] args) {

        SomeInterface.SomeStaticNestedClass1 staticNestedClass1 = new SomeInterface.SomeStaticNestedClass1();
        staticNestedClass1.printField();

        System.out.println("----------------------");

        Ship2.Engine2 engine2 = new Ship2.Engine2("Volvo");
        engine2.launch();
        System.out.println(Ship2.Engine2.name);

        Ship2 ship2 = new Ship2();
        ship2.init();
    }
}

interface SomeInterface {

    int num = 1001;

    class SomeStaticNestedClass1 {

        public void printField() {
            System.out.println("I have access to static field of external class or interface, num = " + num);
        }
    }

}

class Ship2 {

    private Engine2 eng = new Engine2("Reno");
    private static int speed = 100;

    public static class Engine2 {

        public static String name;

        public Engine2(String name) {

            Engine2.name = name;
        }

        public void launch() {
            System.out.println("Запуск двигателя");
            System.out.println("Скорость: " + speed);
        }

        @Override
        public String toString() {
            return "Engine2{}";
        }
    }

    public void init() {
        eng.launch();
        System.out.println(Engine2.name);
    }
}
