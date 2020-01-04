package net.core.tutorial.medium._05_Multithreading.interactWaitAndNotifyAll;

/**
 * Entry point for explanation how to organize the interaction among threads using
 * .wait(), .notify() and .notifyAll()  methods.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        new ThreadImpl("Thread A").start();
        new ThreadImpl("Thread B").start();

        Thread.sleep(300);
        synchronized (ThreadImpl.monitor){
            ThreadImpl.monitor.notifyAll();
        }
    }
}
