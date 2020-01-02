package net.core.tutorial.elementary._24_NestedClasses;

import java.io.Serializable;

/**

 inner классы.

 Каждый объект inner класса неявно содержит ссылку на объект своего внешнего (enclosing) класса.
 Т.е. объект inner класса может существовать только тогда, когда создан объект его внешнего класса.

 inner класс не может содержать статических полей (за исключением констант final static) и статических методов.

 Если имеется объект внешнего класса, то может и не быть объектов его inner классов. Поэтому, чтобы из
 внешнего класса обратиться к переменной или методу его inner класса, надо сначала создать объект inner класса.
 Но если внутри внешнего класса создан объект inner класса, то внутри внешнего класса можно обращаться
 в том числе к приватным полям и методам inner класса.

 У одного объекта внешнего класса может быть много объектов внутренних классов (как одинаковых, так и разных типов).
 inner класс считается частью внешнего класса и имеет полный доступ к его переменным и методам,
 в том числе приватным.

 */

public class _02_InnerClasses2 {

    public static void main(String[] args) {

        EnclosingClass enclosingClass = new EnclosingClass();
        enclosingClass.accessToInnerObjects();

        System.out.println("---------------------------");

        System.out.println("If Enclosing Class is Cloneable: " + (enclosingClass instanceof Cloneable));
        EnclosingClass.InnerClass1 innerClass1 = new EnclosingClass(555, "This is enclosing class")
                .new InnerClass1(-99, "This is inner class 1");
        EnclosingClass.InnerClass2 innerClass2 = new EnclosingClass(777, "This is enclosing class")
                .new InnerClass2(-88, "This is inner class 2");
        System.out.println("If inner class 1 is Cloneable: " + (innerClass1 instanceof Cloneable));
        System.out.println("If inner class 1 is Serializable: " + (innerClass1 instanceof Serializable));
        System.out.println("If inner class 2 is Cloneable: " + (innerClass2 instanceof Cloneable));
        System.out.println("If inner class 2 is Serializable: " + (innerClass2 instanceof Serializable));
        System.out.println("If inner class 2 is AutoCloseable: " + (innerClass2 instanceof AutoCloseable));

        System.out.println("---------------------------");

        innerClass1.printFields();
        innerClass2.printFields();

        System.out.println("---------------------------");

        System.out.println(innerClass1.getInnerMessage1());
        System.out.println(innerClass1.getInnerNumber1());
        System.out.println(innerClass2.getInnerMessage2());
        System.out.println(innerClass2.getInnerNumber2());
    }
}

class EnclosingClass implements Cloneable {

    private int number;
    private String message;

    public EnclosingClass() {
    }

    public EnclosingClass(int number, String message) {
        this.number = number;
        this.message = message;
    }

    public void accessToInnerObjects() {

        EnclosingClass.InnerClass1 innerClass1 = new EnclosingClass(20, "This is enclosing class")
                .new InnerClass1(333, "This is inner class 1");
        EnclosingClass.InnerClass2 innerClass2_1 = new EnclosingClass(30, "This is enclosing class")
                .new InnerClass2(444, "This is inner class 2");
        EnclosingClass.InnerClass2 innerClass2_2 = new EnclosingClass(40, "This is enclosing class")
                .new InnerClass2(555, "This is inner class 2 too");
        System.out.println(String.format("Fields of inner class 1: %d, %d, %s", EnclosingClass.InnerClass1.constantNumber,
                innerClass1.innerNumber1, innerClass1.innerMessage1));
        System.out.println(String.format("Fields of inner class 2: %d, %s", innerClass2_1.innerNumber2,
                innerClass2_1.innerMessage2));
        System.out.println(String.format("Fields of inner class 2: %d, %s", innerClass2_2.innerNumber2,
                innerClass2_2.innerMessage2));
        System.out.println(String.format("External fields: %d, %s", number, message));
    }

    class InnerClass1 implements Serializable {

        private static final int constantNumber = 100;
        private int innerNumber1;
        private String innerMessage1;

        public InnerClass1(int innerNumber1, String innerMessage1) {
            this.innerNumber1 = innerNumber1;
            this.innerMessage1 = innerMessage1;
        }

        public int getInnerNumber1() {
            return innerNumber1;
        }

        public String getInnerMessage1() {
            return innerMessage1;
        }

        public void printFields() {

            System.out.println(String.format("My fields: %d, %d, %s", constantNumber, innerNumber1, innerMessage1));
            System.out.println(String.format("External fields: %d, %s", number, message));
        }
    }

    class InnerClass2 implements AutoCloseable {

        private int innerNumber2;
        private String innerMessage2;

        public InnerClass2(int innerNumber2, String innerMessage2) {
            this.innerNumber2 = innerNumber2;
            this.innerMessage2 = innerMessage2;
        }

        public int getInnerNumber2() {
            return innerNumber2;
        }

        public String getInnerMessage2() {
            return innerMessage2;
        }

        @Override
        public void close() throws Exception {
            /*NOP*/
        }

        public void printFields() {

            System.out.println(String.format("My fields: %d, %s", innerNumber2, innerMessage2));
            System.out.println(String.format("Field of other inner class: %d", InnerClass1.constantNumber));
            System.out.println(String.format("External fields: %d, %s", number, message));
        }
    }
}
