package net.core.tutorial.medium._05_Multithreading.exampleForJoin;

/**
 * Entry point for explanation how to work method .join().
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint1 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10; i++){
                    try {
                        System.out.println(Thread.currentThread().getName() + " work during " + i + " iteration");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
        try {
            thread.join(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " has accomplished");
    }
}
