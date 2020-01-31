package net.core.tutorial.elementary._11_Methods;

/**

 Виртуальные и статические методы.

 Нестатические методы виртуальны. Т.е. то, какой именно будет вызываться метод (предка или наследника),
 решается в рантайме по типу объекта. Если в классе наследника не переопределён нестатический метод, который есть
 в классе предка, то из объекта наследника будет вызван метод предка (если к нему есть доступ).
 Если в классе наследника переопределён (override) нестатический метод, который есть в классе предка,
 то из объекта наследника будет вызван его собственный метод.
 Наследовать и переопределять можно только нестатические методы. И только такие методы виртуальны.

 */

public class _01_Methods1 {

    public static void main(String[] args) {

        new Parent1().printMessage();
        new Child1().printMessage();
        new Child2().printMessage();
    }
}

class Parent1 {

    public void printMessage() {

        String message = getMessage();
        System.out.println(message);
    }

    public String getMessage() {

        return "This is message from Parent1";
    }
}

class Child1 extends Parent1 {

    public String getMessage() {

        return "This is message from Child1";
    }
}

class Child2 extends Parent1 {

    public String getMessage() {

        return "This is message from Child2";
    }
}