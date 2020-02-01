package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;

/**
 * Reading a file and creating its copy with the use of Java 8 (java.nio)
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InputStreamToFileJava8 {

    public void convertingInProgressInputStreamToFile()
            throws IOException {

        InputStream initialStream = new FileInputStream(
                new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/sample.pdf")));
        File targetFile = new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/targetFile.pdf"));

        java.nio.file.Files.copy(
                initialStream,
                targetFile.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

        initialStream.close();
    }
}
