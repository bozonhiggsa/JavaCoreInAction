package net.core.tutorial.elementary._14_AccessModifiers.secondPackage;

import net.core.tutorial.elementary._14_AccessModifiers.firstPackage.Parent2;

/**

 Illustration of protected access.

 Модификатор protected.
 Переменные или методы с модификатором protected, как и для случая с дефолтным модификатором, полноценно доступны
 по ссылке и через механизм наследования внутри классов из того же пакета, что и родной класс. Но, кроме этого,
 наследники из других пакетов внутри своих классов могут обращаться к статическим и нестатическим переменным и методам
 своего предка напрямую через механизм наследования или при помощи super.
 К статическим переменным/методам предка внутри класса наследника можно обратиться также по имени класса предка
 или по ссылке на объект предка.
 К нестатическим переменным/методам предка внутри класса наследника нельзя обратиться по ссылке на объект предка.
 Но к нестатическим переменным/методам предка внутри класса наследника можно обратиться по ссылке на объект наследника.
 (так как наследник уналедовал эти элементы и внутри его класса они его собственные).

 В стороннем классе нет доступа из объекта наследника к protected элементам предка.

 */
public class Child2 extends Parent2 {

    int value = 300;

    public static void main(String[] args) {

        Child2 child2 = new Child2();
        child2.printMessage();
        System.out.println("-------------------");
        // наследник уналедовал этот метод и внутри его класса он его собственный
        child2.printText();
        // наследник уналедовал эту переменную и внутри его класса она его собственная
        System.out.println("Access to non static field of Parent2 from object of Child2: " + child2.message);
        System.out.println("Access to static field of Parent2 over inheritance: " + number);
    }

    public void printMessage() {

        System.out.println("Child2 uses variables of Parent2: " + message + ", " + number);
        printText();
        System.out.println("value from Child2 = " + value + ", value from Parent2 = " + super.message);
        System.out.println("value from Child2 = " + value + ", value from Parent2 = " + super.value);

        Parent2 parent2 = new Parent2();
        System.out.println("Access to static field of Parent2: " + parent2.number);
        System.out.println("Access to static field of Parent2: " + Parent2.number);
    }
}
