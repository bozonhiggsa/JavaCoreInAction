package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import org.junit.Test;

import java.io.IOException;

public class InputStreamToFileGuavaTest {

    @Test
    public void testConvertingInputStreamToFile() {

        try {
            new InputStreamToFileGuava().convertingInputStreamToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}