package net.core.tutorial.medium._05_Multithreading.exampleForAtomicInteger;

/**
 * Entry point for explanation of AtomicInteger advantages.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new ThreadImpl(10_000_000);
        t1.start();
        Thread t2 = new ThreadImpl(10_000_000);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Atomic counter = " + ThreadImpl.counter);
        System.out.println("Simple counter = " + ThreadImpl.simpleCounter);
        System.out.println("Volatile counter = " + ThreadImpl.volatileCounter);
    }
}
