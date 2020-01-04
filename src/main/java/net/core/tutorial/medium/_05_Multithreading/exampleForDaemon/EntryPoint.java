package net.core.tutorial.medium._05_Multithreading.exampleForDaemon;

/**
 * Entry point for explanation what is a daemon.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("main is daemon: " + Thread.currentThread().isDaemon());

        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("other thread is daemon: " + Thread.currentThread().isDaemon());
                for (int i = 0; i < 5; i++) {
                    System.out.println("new thread");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main thread");
            Thread.sleep(500);
        }
    }
}
