package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import org.junit.Test;

import java.io.IOException;

public class InputStreamToFileApacheCommonsIOTest {

    @Test
    public void testConvertingInputStreamToFile() {

        try {
            new InputStreamToFileApacheCommonsIO().convertingInputStreamToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}