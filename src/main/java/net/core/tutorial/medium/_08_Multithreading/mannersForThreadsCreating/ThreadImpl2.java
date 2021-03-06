package net.core.tutorial.medium._08_Multithreading.mannersForThreadsCreating;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl2 extends Thread {

    public ThreadImpl2(String name) {
        super(name);
    }

    public void run() {
        System.out.println("This thread is named as: " + Thread.currentThread().getName());
    }
}
