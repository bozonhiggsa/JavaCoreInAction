package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import java.util.concurrent.ExecutorService;

public class TaskWithInfiniteLoop {

    ExecutorService executorService;

    public TaskWithInfiniteLoop(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void executeTaskWithInfiniteLoop(){

        executorService.submit(() -> {
            while (true) {
            }
        });
    }
}
