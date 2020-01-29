package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskWithInfiniteLoopTest {

    @Test
    public void testExecuteTaskWithInfiniteLoop() throws Exception {

        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        ExecutorService executorService =
                MoreExecutors.getExitingExecutorService(executor,
                        100, TimeUnit.MILLISECONDS);

        new TaskWithInfiniteLoop(executorService).executeTaskWithInfiniteLoop();
    }
}