package net.core.tutorial.medium._08_Multithreading.addingTwoVectors;

import java.util.Arrays;

/**
 * Entry point for explanation.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static final int LENGTH = 250;
    public static final int CORES = Runtime.getRuntime().availableProcessors();
    public static int[] vector1 = new int[LENGTH * CORES];
    public static int[] vector2 = new int[LENGTH * CORES];
    public static int[] sumSimultateous = new int[LENGTH * CORES];
    public static int[] sumSequentional = new int[LENGTH * CORES];


    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < (LENGTH * CORES); i++){
            vector1[i] = i;
            vector2[i] = i + 300;
        }

        System.out.println("Cores into the system: " + CORES);

        Thread[] threads = new Thread[CORES];
        for(int i = 0; i < CORES; i++){
            int numberThread = i;
            threads[i] = new ThreadImpl(new EntryPoint(), numberThread);
            threads[i].start();
        }
        long start1 = System.currentTimeMillis();
        for(int i = 0; i < CORES; i++){
            threads[i].join();
        }
        long stop1 = System.currentTimeMillis();
        System.out.println("Time for simultaneous decision = " + (stop1 - start1) + " ms");

        long start2 = System.currentTimeMillis();
        sequentionalDecision(vector1, vector2);
        long stop2 = System.currentTimeMillis();
        System.out.println("Time for sequentional decision = " + (stop2 - start2) + " ms");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Resulting vectors for two decisions are equal: " + Arrays.equals(sumSimultateous, sumSequentional));
            }
        }).start();
    }

    public static void sequentionalDecision(int[] vector1, int[] vector2) throws InterruptedException {

        for(int i = 0; i < (LENGTH * CORES); i++){
            sumSequentional[i] = vector1[i] + vector2[i];
            Thread.sleep(1);
        }
    }

    public void sumultaneousDecision(int[] vector1, int[] vector2, int numberThread) throws InterruptedException {

        for(int i = (numberThread * LENGTH); i < ((numberThread + 1) * LENGTH); i++){
            sumSimultateous[i] = vector1[i] + vector2[i];
            Thread.sleep(1);
        }
    }
}
