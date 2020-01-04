package net.core.tutorial.medium._05_Multithreading.exampleForProducerAndConsumer;

/**
 * Entry point for explanation a producer-consumer approach.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws InterruptedException {

        SingleElementBuffer monitor = new SingleElementBuffer();
        Thread thread1 = new Thread(new Producer(1, 300, monitor));
        Thread thread2 = new Thread(new Producer(100, 300, monitor));
        Thread thread3 = new Thread(new Producer(1000, 300, monitor));


        Thread thread4 = new Thread(new Consumer(monitor, 1));
        Thread thread5 = new Thread(new Consumer(monitor, 2));

        System.out.println("Work is started");
        System.out.println("-------------------");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
