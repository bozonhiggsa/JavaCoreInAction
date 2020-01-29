package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleScheduledThreadPoolExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SimpleTask {

    public ScheduledFuture<?> executeSimpleTask(ScheduledExecutorService executor, CountDownLatch lock){

         return executor.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);
    }
}
