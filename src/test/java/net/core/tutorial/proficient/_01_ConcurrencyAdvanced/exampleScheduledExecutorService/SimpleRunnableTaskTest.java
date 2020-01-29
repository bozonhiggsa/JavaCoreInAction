package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleScheduledExecutorService;

import org.junit.Test;

public class SimpleRunnableTaskTest {

    @Test
    public void testExecuteSimpleRunnableTasks() throws Exception {

        SimpleRunnableTask simpleRunnableTask = new SimpleRunnableTask();
        simpleRunnableTask.executeSimpleRunnableTasks();
    }
}