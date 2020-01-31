package net.core.tutorial.medium._08_Multithreading.exampleForProducerAndConsumer;

/**
 * Buffer with one element from the producer-consumer approach.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SingleElementBuffer {

    private Integer element = null;

    public synchronized void put(int newElement) throws InterruptedException {
        while(this.element != null){
            this.wait();
        }
        this.element = newElement;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while(element == null){
            this.wait();
        }
        Integer result = this.element;
        this.element = null;
        this.notifyAll();
        return result;
    }
}
