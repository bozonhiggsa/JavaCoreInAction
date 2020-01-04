package net.core.tutorial.medium._05_Multithreading.exampleForYield;

/**
 * Entry point for explanation of yield() method.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        EntryPoint monitor = new EntryPoint();
        Thread thread1 = new ThreadImpl(monitor);
        Thread thread2 = new ThreadImpl(monitor);
        Thread thread3 = new ThreadImpl(monitor);

        thread1.start();
        thread2.start();
        thread3.start();

        for (int k = 0; k < 15; k++) {
            sillyWork();
            System.out.println("Thread: " + Thread.currentThread().getName() + " - performed silly work");
        }
    }

    public static void sillyWork(){
        double d = 2.0;
        for (int i = 0; i < 1_000_000; i++) {
            d = Math.sin(d);
        }
    }
}
