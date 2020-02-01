package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * Reading a file and creating its copy with the use of commons-fileupload
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InputStreamToFileApacheCommonsIO {

    public void convertingInputStreamToFile() throws IOException {
        InputStream initialStream = FileUtils.openInputStream
                (new File(this.getClass().getResource("/sample.pdf").getPath()));

        File targetFile = new File(String.format("%s%s",
                this.getClass().getResource("/").getPath(), "/targetFile.pdf"));

        FileUtils.copyInputStreamToFile(initialStream, targetFile);
    }
}
