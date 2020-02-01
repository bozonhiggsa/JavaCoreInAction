package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import org.junit.Test;

import java.io.IOException;

public class InputStreamToFilePlainJavaTest {

    @Test
    public void testConvertingToFile() {

        try {
            new InputStreamToFilePlainJava().convertingToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}