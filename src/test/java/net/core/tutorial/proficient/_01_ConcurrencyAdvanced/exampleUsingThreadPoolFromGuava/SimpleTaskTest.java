package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertTrue;

public class SimpleTaskTest {

    @Test
    public void testExecuteSimpleTask() throws Exception {

        Executor executor = MoreExecutors.directExecutor();
        AtomicBoolean executed = new AtomicBoolean();

        new SimpleTask(executor, executed).executeSimpleTask();

        assertTrue(executed.get());
    }
}