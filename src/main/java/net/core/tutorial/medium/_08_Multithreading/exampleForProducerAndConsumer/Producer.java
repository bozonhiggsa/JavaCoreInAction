package net.core.tutorial.medium._08_Multithreading.exampleForProducerAndConsumer;

/**
 * Producer from the producer-consumer approach.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Producer implements Runnable {

    private int startValue;
    private final int timeout;
    private final SingleElementBuffer monitor;

    public Producer(int startValue, int timeout, SingleElementBuffer monitor) {
        this.startValue = startValue;
        this.timeout = timeout;
        this.monitor = monitor;
    }

    public void run() {
        while(true){
            try {
                monitor.put(startValue);
                System.out.println(System.currentTimeMillis() + ": " + startValue++ + " is produced");
                Thread.sleep(timeout);
            }
            catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was stopped");
                break;
            }
        }
    }
}
