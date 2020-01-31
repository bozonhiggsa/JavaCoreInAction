package net.core.tutorial.medium._08_Multithreading.exampleForJoin;

/**
 * Entry point for explanation - method .join() not cease to block a monitor.
 * And we may get a deadlock.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint2 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " has started the work");
                    Thread.sleep(200);
                    commonMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        commonMethod();
        thread.join();
        System.out.println(Thread.currentThread().getName() + " has finished the work");
    }

    private synchronized static void commonMethod(){
        System.out.println(Thread.currentThread().getName() + " has started the work");
        while(true);
    }
}
