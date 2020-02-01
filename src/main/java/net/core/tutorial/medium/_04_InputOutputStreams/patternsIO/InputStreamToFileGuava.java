package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import com.google.common.io.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Reading a file and creating its copy with the use of Guava
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InputStreamToFileGuava {

    public void convertingInputStreamToFile()
            throws IOException {

        InputStream initialStream = new FileInputStream(
                new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/sample.pdf")));
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/targetFile.pdf"));
        Files.write(buffer, targetFile);
    }
}
