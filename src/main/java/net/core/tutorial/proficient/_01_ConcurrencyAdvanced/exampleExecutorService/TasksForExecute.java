package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleExecutorService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TasksForExecute {

    public void createSimpleTasks() throws ExecutionException, InterruptedException {

        Runnable runnableTask = () -> System.out.println("runnableTask is executed");

        Callable<String> callableTask = () -> {
            System.out.println("callableTask is executed");
            return "Task executed";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(runnableTask);

        Future future = executorService.submit(runnableTask);

        Future<String> future2 = executorService.submit(callableTask);
        System.out.println(future2.get());

        String result = executorService.invokeAny(callableTasks);
        System.out.println(result);

        List<Future<String>> futures = executorService.invokeAll(callableTasks);
        for (Future<String> fu: futures) {
            System.out.println(fu.get());
        }
    }
}
