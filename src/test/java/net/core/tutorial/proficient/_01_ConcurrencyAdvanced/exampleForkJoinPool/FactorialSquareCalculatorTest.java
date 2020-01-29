package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleForkJoinPool;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

public class FactorialSquareCalculatorTest {

    @Test
    public void testCompute() throws Exception {

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        FactorialSquareCalculator calculator = new FactorialSquareCalculator(10);

        forkJoinPool.execute(calculator);
    }
}