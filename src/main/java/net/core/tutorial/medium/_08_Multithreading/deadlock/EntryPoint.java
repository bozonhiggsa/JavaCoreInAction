package net.core.tutorial.medium._08_Multithreading.deadlock;

/**
 * Entry point for explanation what is a deadlock.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    private static final Object monitorOne = new Object();
    private static final Object monitorTwo = new Object();

    public static void main(String[] args) throws InterruptedException {

        new ThreadImpl(monitorOne, monitorTwo).start();

        System.out.println("Now we have a deadlock");
        synchronized (monitorTwo){
            Thread.sleep(300);
            synchronized (monitorOne){}
        }
    }
}
