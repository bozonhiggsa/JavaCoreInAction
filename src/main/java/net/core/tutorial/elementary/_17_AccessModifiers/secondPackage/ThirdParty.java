package net.core.tutorial.elementary._17_AccessModifiers.secondPackage;

/**
 *
 Illustration of protected access.

 */
public class ThirdParty {

    public static void main(String[] args) {

        Child2 child2 = new Child2();
        child2.printMessage();
        System.out.println("-------------------");
        // В стороннем классе ThirdParty нет доступа из объекта наследника к protected элементам предка
        //child2.printText();
        //System.out.println("Access to non static field of Parent2 from object of Child2: " + child2.message);
    }

}
