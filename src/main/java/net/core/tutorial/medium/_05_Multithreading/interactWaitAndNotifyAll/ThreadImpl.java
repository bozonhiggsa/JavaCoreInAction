package net.core.tutorial.medium._05_Multithreading.interactWaitAndNotifyAll;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    public static Object monitor = new Object();
    private String message;

    public ThreadImpl(String message) {
        this.message = message;
    }

    public void run() {
        synchronized (monitor) {
            try {
                while (true) {
                    monitor.wait();
                    monitor.notify();
                    System.out.println(message);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
