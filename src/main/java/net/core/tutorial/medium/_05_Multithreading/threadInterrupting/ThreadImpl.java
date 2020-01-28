package net.core.tutorial.medium._05_Multithreading.threadInterrupting;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    final private Object monitor;
    private int timeout;

    public ThreadImpl(String name, int timeout, Object monitor) {
        super(name);
        this.monitor = monitor;
        this.timeout = timeout;
    }

    public void run() {
        synchronized (monitor){
            while(true){
                try{
                    System.out.println(Thread.currentThread().getName() + " entered into .run()");
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println(Thread.currentThread().getName() + " must finished his work");
                        System.out.println("isInterrupted for " + Thread.currentThread().getName() + " is still "
                                + Thread.currentThread().isInterrupted());
                        return;
                    }
                    else{
                        monitor.notifyAll();
                        monitor.wait(timeout);
                    }
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupt therefor exception");
                    System.out.println("isInterrupted for " + Thread.currentThread().getName() + " retains: "
                            + Thread.currentThread().isInterrupted() +" after exception");
                    return;
                }
            }
        }
    }
}

