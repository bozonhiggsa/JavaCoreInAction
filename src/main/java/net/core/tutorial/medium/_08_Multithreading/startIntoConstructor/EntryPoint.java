package net.core.tutorial.medium._08_Multithreading.startIntoConstructor;

/**
 * Entry point for explanation.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {

        Object monitor = new Object();
        Thread thread1 = new ThreadImpl("first thread", monitor);
        new ThreadImpl("second thread", monitor);
        new ThreadImpl("three thread", monitor);
        System.out.println("This thread is named as: " + Thread.currentThread().getName());
    }
}
