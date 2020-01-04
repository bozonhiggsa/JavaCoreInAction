package net.core.tutorial.medium._05_Multithreading.exampleForProducerAndConsumer;

/**
 * Consumer from the producer-consumer approach.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Consumer implements Runnable{

    private final int id;
    private final SingleElementBuffer monitor;

    public Consumer(SingleElementBuffer monitor, int id) {
        this.monitor = monitor;
        this.id = id;
    }

    public void run() {
        while(true){
            try {
                Integer element = monitor.get();
                System.out.println(System.currentTimeMillis() + ": " + element + " consumed by consumer with id=" + id);
            }
            catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was stopped");
                return;
            }
        }
    }
}
