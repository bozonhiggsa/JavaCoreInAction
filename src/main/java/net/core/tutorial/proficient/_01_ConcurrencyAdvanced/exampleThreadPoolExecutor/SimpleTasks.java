package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadPoolExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleTasks {

    public void executeSimpleTasks(ThreadPoolExecutor executor){

        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
    }

    public void executeAnotherSimpleTasks(ExecutorService executor, AtomicInteger counter){

        executor.submit(() -> counter.set(1));

        executor.submit(() -> counter.compareAndSet(1, 2));
    }
}
