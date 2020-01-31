package net.core.tutorial.medium._08_Multithreading.exampleForYield;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    private final Object monitor;

    public ThreadImpl(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            for (int i = 0; i < 5; i++) {
                EntryPoint.sillyWork();
                System.out.println("Thread: " + Thread.currentThread().getName() + " - performed silly work");
                Thread.yield();
                System.out.println("Thread: " + Thread.currentThread().getName() + " - returned after yield");
            }
        }
    }
}
