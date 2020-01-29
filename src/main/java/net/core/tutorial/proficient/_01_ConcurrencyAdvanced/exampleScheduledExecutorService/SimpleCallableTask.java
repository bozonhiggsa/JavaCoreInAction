package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleScheduledExecutorService;

import java.util.concurrent.*;

public class SimpleCallableTask {

    public void executeSimpleCallableTask() throws ExecutionException, InterruptedException {

        Callable<String> callableTask = () -> "Task 1 executed with delay 3 sec";

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        System.out.println("Start of executing");
        Future<String> resultFuture =
                executorService.schedule(callableTask, 3, TimeUnit.SECONDS);

        System.out.println(resultFuture.get());
    }
}
