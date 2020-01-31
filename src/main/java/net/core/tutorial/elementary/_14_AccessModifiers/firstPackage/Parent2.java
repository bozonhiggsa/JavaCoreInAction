package net.core.tutorial.elementary._14_AccessModifiers.firstPackage;

/**

 Illustration of protected access.

 */
public class Parent2 {

    protected String message = "I'm Parent2";
    protected static int number = 202;
    protected int value = 100;

    protected void printText() {
        System.out.println(message);
    }
}
