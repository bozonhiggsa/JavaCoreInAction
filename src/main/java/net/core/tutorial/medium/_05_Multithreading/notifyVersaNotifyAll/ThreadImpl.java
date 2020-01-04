package net.core.tutorial.medium._05_Multithreading.notifyVersaNotifyAll;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    long timeout;
    Object monitor;

    public ThreadImpl(long timeout, Object monitor) {
        super();
        this.timeout = timeout;
        this.monitor = monitor;
    }

    public void run() {
        ((EntryPoint)monitor).method(timeout);
    }
}
