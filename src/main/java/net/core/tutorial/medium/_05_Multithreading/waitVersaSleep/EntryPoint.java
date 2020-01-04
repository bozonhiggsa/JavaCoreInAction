package net.core.tutorial.medium._05_Multithreading.waitVersaSleep;

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
                    monitor.helloForSleep(threadId);
                }
            }).start();
        }
        System.out.println("---------------------");
        Thread.sleep(3000);
        System.out.println("---------------------");
        Thread[] threads2 = new Thread[5];
        for (int k = 0; k < threads2.length; k++) {
            final int threadId = k;
            new Thread(new Runnable() {
                public void run() {
                    monitor.helloForWait(threadId);
                }
            }).start();
        }
    }

    private synchronized void helloForSleep(int threadId){
        System.out.println(threadId + " - I'm here");
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void helloForWait(int threadId){
        System.out.println(threadId + " - I'm here");
        try {
            wait(500);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
