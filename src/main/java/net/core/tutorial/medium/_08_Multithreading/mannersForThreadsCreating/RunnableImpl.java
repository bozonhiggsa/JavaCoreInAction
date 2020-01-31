package net.core.tutorial.medium._08_Multithreading.mannersForThreadsCreating;

/**
 * The implementation of the Runnable.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RunnableImpl implements Runnable {

    public void run() {
        System.out.println("This thread is named as: " + Thread.currentThread().getName());
    }
}
