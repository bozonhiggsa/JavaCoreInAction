package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleForkJoinPool;

import org.junit.Test;

public class CustomRecursiveTaskTest {

    @Test
    public void testCompute() throws Exception {

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(100);
        customRecursiveTask.populateArray();
        customRecursiveTask.compute();
    }
}