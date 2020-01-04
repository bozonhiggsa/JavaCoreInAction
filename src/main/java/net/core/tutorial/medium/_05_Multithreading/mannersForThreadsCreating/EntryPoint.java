package net.core.tutorial.medium._05_Multithreading.mannersForThreadsCreating;

/**
 * Various manners of threads creating.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) {

        Thread thread0 = new Thread(new RunnableImpl());
        Thread thread11 = new ThreadImpl1();
        Thread thread12 = new Thread(new ThreadImpl1());
        thread0.run();
        thread11.run();
        thread12.run();
        System.out.println("--------------------");
        Thread thread2 = new ThreadImpl2("Some thread");
        thread0.start();
        thread11.start();
        thread12.start();
        thread2.start();
        System.out.println("--------------------");
        EntryPoint monitor = new EntryPoint();
        Thread thread31 = new ThreadImpl3("Another thread", monitor);
        Thread thread32 = new ThreadImpl3("Another thread", monitor);
        Thread thread33 = new ThreadImpl3("Another thread", monitor);
        thread31.start();
        thread32.start();
        thread33.start();
        System.out.println("--------------------");
        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                System.out.println("This thread is named as: " + Thread.currentThread().getName());
            }
        });
        thread4.start();
    }
}
