package net.core.tutorial.medium._05_Multithreading.mannersForThreadsCreating;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl3 extends Thread {

    private final Object monitor;

    public ThreadImpl3(String name, Object monitor) {
        super(name);
        this.monitor = monitor;
    }

    public void run() {
        synchronized (monitor){
            System.out.println("This thread is named as: " + Thread.currentThread().getName());
        }
    }
}
