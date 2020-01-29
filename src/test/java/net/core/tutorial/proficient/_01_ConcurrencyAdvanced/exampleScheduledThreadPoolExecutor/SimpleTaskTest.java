package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleScheduledThreadPoolExecutor;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class SimpleTaskTest {

    @Test
    public void testExecuteSimpleTask() throws Exception {

        CountDownLatch lock = new CountDownLatch(3);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future = new SimpleTask().executeSimpleTask(executor, lock);

        lock.await(1000, TimeUnit.MILLISECONDS);
        future.cancel(true);

        assertEquals(true, future.isCancelled());
    }
}