package net.core.tutorial.medium._05_Multithreading.mannersForThreadsCreating;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl1 extends Thread {

    public void run() {
        System.out.println("This thread is named as: " + Thread.currentThread().getName());
    }
}
