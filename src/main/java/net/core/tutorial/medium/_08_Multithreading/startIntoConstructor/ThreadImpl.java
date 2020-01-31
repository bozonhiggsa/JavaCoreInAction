package net.core.tutorial.medium._08_Multithreading.startIntoConstructor;

/**
 * The implementation of the Thread with .start() into constructor.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    private final Object monitor;

    public ThreadImpl(String name, Object monitor) {
        super(name);
        this.monitor = monitor;
        this.start();
    }

    public void run() {
        synchronized (monitor){
            System.out.println("This thread is named as: " + Thread.currentThread().getName());
        }
    }
}
