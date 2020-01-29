package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadPoolExecutor;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

public class FixedThreadPoolImplTest {

    @Test
    public void testExecuteSimpleTasksWithFixedThreadPool() throws Exception {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        new SimpleTasks().executeSimpleTasks(executor);

        assertEquals(2, executor.getPoolSize());
        assertEquals(1, executor.getQueue().size());
    }

    @Test
    public void testExecuteSimpleTasksWithCachedThreadPool() throws Exception {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();

        new SimpleTasks().executeSimpleTasks(executor);

        assertEquals(3, executor.getPoolSize());
        assertEquals(0, executor.getQueue().size());
    }

    @Test
    public void testExecuteSimpleTasksWithSingleThreadExecutor() throws Exception {

        AtomicInteger counter = new AtomicInteger();

        ExecutorService executor = Executors.newSingleThreadExecutor();

        new SimpleTasks().executeAnotherSimpleTasks(executor, counter);

        Thread.sleep(1000);
        System.out.println("Flag is: " + counter.intValue());
    }
}