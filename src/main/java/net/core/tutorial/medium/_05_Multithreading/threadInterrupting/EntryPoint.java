package net.core.tutorial.medium._05_Multithreading.threadInterrupting;

/**
 * Entry point for explanation how should finish a thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        Object monitor = new Object();
        Thread thread1 = new ThreadImpl("first thread", 200, monitor);
        Thread thread2 = new ThreadImpl("second thread", 200, monitor);
        Thread thread3 = new ThreadImpl("third thread", 200, monitor);
        Thread thread4 = new ThreadImpl("fourth thread", 200, monitor);
        Thread thread5 = new ThreadImpl("fifth thread", 200, monitor);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        Thread.sleep(300);
        if(thread1.isAlive()){
            thread1.interrupt();
        }
        if(thread2.isAlive()){
            thread2.interrupt();
        }
        if(thread3.isAlive()){
            thread3.interrupt();
        }
        if(thread4.isAlive()){
            thread4.interrupt();
        }
        if(thread5.isAlive()){
            thread5.interrupt();
        }
        Thread.sleep(300);
        if(!thread1.isAlive()){
            System.out.println("method .isInterrupted() invoked on dead thread return: " + thread1.isInterrupted());
        }
    }
}
