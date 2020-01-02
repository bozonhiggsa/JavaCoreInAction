package net.core.tutorial.elementary._24_NestedClasses;

/**

 При таком создании объекта внутреннего класса Engine при инициализации переменной внешнего класса Ship
 нет реального отличия от использования какого-либо другого внешнего класса, кроме того, что inner класс
 был объявлен внутри класса Ship. Использование объекта inner класса вне своего внешнего класса возможно
 только при наличии доступа (видимости) и при объявлении ссылки в виде:

 Ship.Engine obj = new Ship().new Engine();

 Основное отличие заключается в больших возможностях ограничения видимости nested класса по сравнению с обычным
 внешним классом. nested класс может быть объявлен как private, что обеспечивает его полную невидимость вне
 класса-владельца и надежное сокрытие реализации. В этом случае ссылку obj объявить было бы нельзя.
 Создать объект такого класса можно было бы только в методах и логических блоках внешнего класса.

 Практически, поскольку inner класс имеет прямой доступ к переменным внешнего класса, то его функционал
 может использовать эти переменные. Как, например, inner класс Itr в классе ArrayList. Класс Itr имеет доступ
 к внутренним параметрам класса ArrayList, благодаря чему имеет возможность реализовать интерфейс Iterator
 применительно именно к данной коллекции.

 */

public class _03_InnerClasses3 {

    public static void main(String[] args) {

        Ship.Engine obj = new Ship().new Engine();
        obj.launch();

        Ship ship = new Ship();
        ship.init();

        System.out.println("-----------------");

        WarShip.SpecialEngine specialEngine = new WarShip().new SpecialEngine();
        System.out.println(specialEngine);

        System.out.println("-----------------");

        Motor motor = new Motor(new Ship());
        System.out.println(motor);
    }
}

class Ship {

    // поля и конструкторы
    private Engine eng = new Engine();

    // abstract, final, private, protected, public – допустимы при объявлении inner класса
    public class Engine { // определение внутреннего класса
        // поля и методы
        public void launch() {
            System.out.println("Запуск двигателя");
        }

        @Override
        public String toString() {
            return "Engine{}";
        }
    }// конец объявления внутреннего класса

    public void init() {//  метод внешнего класса
        eng.launch();
    }
}

// Внутренние классы имеют право наследовать другие классы, реализовывать интерфейсы и выступать в роли
// объектов наследования. Допустимо наследование следующего вида:
class WarShip extends Ship {

    protected class SpecialEngine extends Engine {

        @Override
        public String toString() {
            return "SpecialEngine{}";
        }
    }
}

// Если некоторый класс наследуется от inner класса, то в своём конструкторе он должен получить ссылку
// на объект внешнего класса (применительно к inner классу), что позволит ему получить доступ к объекту класса,
// от которого он наследуется
class Motor extends Ship.Engine {

    public Motor(Ship obj) {
        obj.super();
    }
}