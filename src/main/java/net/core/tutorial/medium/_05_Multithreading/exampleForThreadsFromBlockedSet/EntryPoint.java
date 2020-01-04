package net.core.tutorial.medium._05_Multithreading.exampleForThreadsFromBlockedSet;

/**
 * Entry point for explanation of a BlockedSet space.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        final EntryPoint monitor = new EntryPoint();

        Thread[] threads = new Thread[5];
        for (int k = 0; k < threads.length; k++) {
            final int threadId = k;
            new Thread(new Runnable() {
                public void run() {
                    monitor.hello(threadId);
                }
            }).start();
        }
    }

    private synchronized void hello(int threadId){
        System.out.println(threadId + " - I'm here");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
