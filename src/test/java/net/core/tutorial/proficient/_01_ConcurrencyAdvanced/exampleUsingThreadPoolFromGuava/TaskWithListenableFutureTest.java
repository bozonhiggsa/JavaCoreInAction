package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

public class TaskWithListenableFutureTest {

    @Test
    public void testExecuteTaskWithListenableFuture() throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ListeningExecutorService listeningExecutorService =
                MoreExecutors.listeningDecorator(executorService);

        String greeting = new TaskWithListenableFuture(listeningExecutorService).executeTaskWithListenableFuture();

        assertEquals("Hello World", greeting);
    }
}