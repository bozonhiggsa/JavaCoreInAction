package net.core.tutorial.medium._05_Multithreading.notifyVersaNotifyAll;

/**
 * Entry point for explanation a difference between .notify() and .notifyAll() methods.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {

        EntryPoint monitor = new EntryPoint();
        Thread thread1 = new ThreadImpl(100, monitor);
        Thread thread2 = new ThreadImpl(100, monitor);
        Thread thread3 = new ThreadImpl(100, monitor);
        Thread thread4 = new ThreadImpl(100, monitor);
        Thread thread5 = new ThreadImpl(100, monitor);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    synchronized void method(long timeout){
        for (int i = 0; i < 5; i++){
            try {
                System.out.println(Thread.currentThread().getName());
                //notify();
                notifyAll();
                wait(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
