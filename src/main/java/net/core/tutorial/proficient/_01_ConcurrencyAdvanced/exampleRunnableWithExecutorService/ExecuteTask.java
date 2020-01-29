package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleRunnableWithExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteTask {

    public void executeTask() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new EventLoggingTask());
        executorService.shutdown();
    }
}
