package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import org.junit.Test;

import java.io.IOException;

public class InputStreamToFileJava8Test {

    @Test
    public void testConvertingInProgressInputStreamToFile() {

        try {
            new InputStreamToFileJava8().convertingInProgressInputStreamToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}