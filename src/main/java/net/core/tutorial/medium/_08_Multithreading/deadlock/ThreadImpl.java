package net.core.tutorial.medium._08_Multithreading.deadlock;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    private final Object monitorOne;
    private final Object monitorTwo;

    public ThreadImpl(Object monitorOne, Object monitorTwo) {
        this.monitorOne = monitorOne;
        this.monitorTwo = monitorTwo;
    }

    @Override
    public void run() {
        try{
            synchronized (monitorOne){
                Thread.sleep(500);
                synchronized (monitorTwo){}
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
