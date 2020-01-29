package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleTask {

    Executor executor;
    AtomicBoolean executed;

    public SimpleTask(Executor executor, AtomicBoolean executed) {
        this.executor = executor;
        this.executed = executed;
    }

    public void executeSimpleTask(){

        executor.execute(() -> {
            try {
                System.out.println("Another thread is running");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executed.set(true);
        });
    }
}
