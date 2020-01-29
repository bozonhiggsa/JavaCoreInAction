package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleUsingThreadPoolFromGuava;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class TaskWithListenableFuture {

    ListeningExecutorService listeningExecutorService;

    public TaskWithListenableFuture(ListeningExecutorService listeningExecutorService) {
        this.listeningExecutorService = listeningExecutorService;
    }

    public String executeTaskWithListenableFuture() throws ExecutionException, InterruptedException {

        ListenableFuture<String> future1 =
                listeningExecutorService.submit(() -> "Hello");
        ListenableFuture<String> future2 =
                listeningExecutorService.submit(() -> "World");

        return Futures.allAsList(future1, future2).get()
                .stream()
                .collect(Collectors.joining(" "));
    }
}
