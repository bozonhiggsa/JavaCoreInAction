package net.core.tutorial.medium._05_Multithreading.exampleForAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    private static int N;
    public static AtomicInteger counter = new AtomicInteger();
    public static int simpleCounter;
    public volatile static int volatileCounter;

    public ThreadImpl(int number) {
        super();
        N = number;
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            counter.incrementAndGet();
            simpleCounter++;
            volatileCounter++;
        }
    }
}
