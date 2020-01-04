package net.core.tutorial.medium._05_Multithreading.addingTwoVectors;

/**
 * The implementation of the Thread.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ThreadImpl extends Thread {

    private final EntryPoint instance;
    private int numberThread;

    public ThreadImpl(EntryPoint instance, int numberThread) {
        this.instance = instance;
        this.numberThread = numberThread;
    }

    public int getNumberThread() {
        return numberThread;
    }

    @Override
    public void run() {
        try{
            this.instance.sumultaneousDecision(EntryPoint.vector1, EntryPoint.vector2, numberThread);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
