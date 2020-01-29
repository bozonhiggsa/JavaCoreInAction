package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleScheduledExecutorService;

import java.util.concurrent.*;

public class SimpleRunnableTask {

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public void executeSimpleRunnableTasks() throws ExecutionException, InterruptedException {

        Runnable runnableTask1 = () -> System.out.println("Task 1 executed with delay 3 sec");
        Runnable runnableTask2 = () -> System.out.println("Task 2 is executing with delay 2 sec periodically over 3 sec");
        Runnable runnableTask3 = () -> System.out.println("Task 3 is executing with init delay 1 sec and delay 4 sec between iterations");

        System.out.println("Start of executing");
        Future resultFuture1 = executorService
                .schedule(runnableTask1, 3, TimeUnit.SECONDS);
        System.out.println(resultFuture1.get());

        Future resultFuture2 = executorService
                .scheduleAtFixedRate(runnableTask2, 2, 3, TimeUnit.SECONDS);
        try {
            System.out.println(resultFuture2.get(15, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        Future resultFuture3 = executorService
                .scheduleWithFixedDelay(runnableTask3, 1, 4, TimeUnit.SECONDS);
        try {
            System.out.println(resultFuture3.get(10, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
