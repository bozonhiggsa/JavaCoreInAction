package net.core.tutorial.elementary._06_Constructors;

/**
 Конструкторы.

 Конструкторы – это специальные методы, назначением которых является создание объектов класса.
 В отличие от обычных методов конструкторы ничего не возвращают (даже void) и
 не могут быть final, static, abstract, synchronized, native.
 Уровень доступа конструктора может быть public или default.

 В Java у каждого класса есть хотя бы один конструктор. Если конструктор не сделать явно, то JVM во время
 компиляции сама добавит конструктор по умолчанию (без аргументов), из которого будет вызываться конструктор
 без аргументов предка (через super()).
 Конструктор без аргументов выделяет для полей объекта класса область памяти в Heap и инициализирует их значениями
 по умолчанию. Когда создаётся объект класса через new – выделяется область памяти для хранения всех полей, которые есть
 у данного класса, а также всех полей, которые есть у его предков. Затем обязательно вызываются конструкторы всех предков,
 начиная с самого старшего предка. Последовательно вызываемые конструкторы инициализируют значения полей своих классов.
 В конце вызывается конструктор данного класса, который инициализирует значения своих собственных переменных.

 В результате в объекте наследника имеются инициализированные поля его самого, а также всех его предков. И эти поля могут
 иметь одинаковые имена, но содержать разные значения.

 */

public class _01_Constructors1 {

    public static void main(String[] args) {

        Parent1 parent = new Parent1(100);
        System.out.println("value from Parent1 = " + parent.value);
        Child1 child1 = new Child1(3, 30);
        System.out.println("value from Child1 = " + child1.value + ", number from Child1 = " + child1.number);
        Child2 child2 = new Child2(70);
        System.out.println("value from Child2 = " + child2.value);
    }
}

class Parent1 {

    int value;

    Parent1(int value) {
        this.value = value;
        System.out.println("-----------------");
        System.out.println("Constructor of Parent1 is invoked");
        System.out.println("-----------------");
    }
}

class Child1 extends Parent1 {

    int number;

    Child1(int value, int number) {
        super(value);
        this.number = number;
        System.out.println("Constructor of Child1 is invoked");
        System.out.println("-----------------");
    }
}

class Child2 extends Parent1 {

    int value = 12;

    Child2(int value) {
        super(value);
        System.out.println("Constructor of Child2 is invoked");
        System.out.println("-----------------");
    }
}