package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleSimpleDateFormat;

import org.junit.Test;

public class SimpleDateFormatAndThreadLocalTest {

    @Test
    public void testParsingDateFromVariousThreads() throws Exception {

        new SimpleDateFormatAndThreadLocal().parsingDateFromVariousThreads();
    }

    @Test
    public void testFormattingDateFromVariousThreads() throws Exception {

        new SimpleDateFormatAndThreadLocal().formattingDateFromVariousThreads();
    }
}