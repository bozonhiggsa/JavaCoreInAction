package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleForkJoinPool;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class ForkJoinExampleTest {

    @Test
    public void testCalculateSumOfNodeValues() throws Exception {

        ForkJoinExample.TreeNode tree = new ForkJoinExample.TreeNode(5,
                new ForkJoinExample.TreeNode(3), new ForkJoinExample.TreeNode(2,
                new ForkJoinExample.TreeNode(2), new ForkJoinExample.TreeNode(8)));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int sum = forkJoinPool.invoke(new ForkJoinExample.CountingTask(tree));
        System.out.println("Sum of node values is: " + sum);

        int numberOfCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processor's cores is: " + numberOfCores);

        assertEquals(3, forkJoinPool.getPoolSize());
        assertEquals(0, forkJoinPool.getRunningThreadCount());
        assertEquals(0, forkJoinPool.getQueuedSubmissionCount());
        assertEquals(3, forkJoinPool.getParallelism());
    }
}