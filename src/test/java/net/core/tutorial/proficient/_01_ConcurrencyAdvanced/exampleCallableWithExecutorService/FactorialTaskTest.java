package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleCallableWithExecutorService;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.assertEquals;

public class FactorialTaskTest {

    @Test
    public void whenTaskSubmitted_ThenFutureResultObtained() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(5);
        Future<Integer> future = executorService.submit(task);

        assertEquals(120, future.get().intValue());
        assertEquals(true, future.isDone());
    }

    @Test(expected = ExecutionException.class)
    public void whenException_ThenCallableThrowsIt() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        Integer result = future.get();
    }

    @Test
    public void whenException_ThenCallableWithTryCatchWithin() throws InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);
        try {
            Integer result = future.get();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        }

        assertEquals(true, future.isDone());
    }

    @Test
    public void whenException_ThenCallableDoesntThrowsItIfGetIsNotCalled(){

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(-5);
        Future<Integer> future = executorService.submit(task);

        assertEquals(false, future.isDone());
    }

    @Test(expected = TimeoutException.class)
    public void whenExceptionTimeoutException() throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FactorialTask task = new FactorialTask(50);
        Future<Integer> future = executorService.submit(task);
        Integer result = future.get(1, TimeUnit.NANOSECONDS);
    }
}