package net.core.tutorial.elementary._17_AccessModifiers.secondPackage;

import net.core.tutorial.elementary._17_AccessModifiers.firstPackage.Parent2;

/**

 Illustration of protected access.

 */
public class Child2 extends Parent2 {

    int value = 300;

    public static void main(String[] args) {

        Child2 child2 = new Child2();
        child2.printMessage();
        System.out.println("-------------------");
        child2.printText();
        System.out.println("Access to non static field of Parent2 from object of Child2: " + child2.message);
        System.out.println("Access to static field of Parent2 over inheritance: " + number);
    }

    public void printMessage() {

        System.out.println("Child2 uses variables of Parent2: " + message + ", " + number);
        printText();
        System.out.println("value from Child2 = " + value + ", value from Parent2 = " + super.value);

        Parent2 parent2 = new Parent2();
        System.out.println("Access to static field of Parent2: " + parent2.number);
        System.out.println("Access to static field of Parent2: " + Parent2.number);
        System.out.println("Access to static field of Parent2: " + number);
    }
}
