package net.core.tutorial.medium._08_Multithreading.interactWaitAndNotifyAll;

/**
 * Entry point for explanation how to organize the interaction among threads using
 * .wait(), and .notify() methods.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint2 extends Thread {

    private String message;
    private final static Object object = new Object();

    public EntryPoint2(String message) {
        this.message = message;
    }

    public void run() {
        synchronized (EntryPoint2.class) {
            try {
                while (true) {
                    EntryPoint2.class.notify();
                    EntryPoint2.class.wait();
                    System.out.println(message);
                    staticMethod();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        new EntryPoint2("Thread A").start();
        new EntryPoint2("Thread B").start();
    }

    public static void staticMethod() {
        synchronized (object) {
            while (true) {
                break;
            }
        }
    }
}
