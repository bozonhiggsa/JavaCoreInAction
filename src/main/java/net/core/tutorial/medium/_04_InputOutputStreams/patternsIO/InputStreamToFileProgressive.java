package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import java.io.*;

/**
 * Reading a file and creating its copy with the use of try with resources
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InputStreamToFileProgressive {

    public void convertingInProgressToFile() {

        try (InputStream initialStream = new FileInputStream(new File
                (String.format("%s%s", this.getClass().getResource("/").getPath(), "/sample.pdf")));
             OutputStream outStream = new FileOutputStream(new File
                     (String.format("%s%s", this.getClass().getResource("/").getPath(), "/targetFile.pdf")))) {

            byte[] buffer = new byte[8 * 1024];
            int bytesRead;
            while ((bytesRead = initialStream.read(buffer)) != -1)
                outStream.write(buffer, 0, bytesRead);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
