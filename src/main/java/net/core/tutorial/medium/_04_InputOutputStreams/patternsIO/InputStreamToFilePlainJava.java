package net.core.tutorial.medium._04_InputOutputStreams.patternsIO;

import java.io.*;

/**
 *
 * В данном примере файл, из которого создаётся входной поток, является статичным,
 * поэтому можно сразу определить необходимый размер байтового массива при помощи .available().
 * Если же входной поток создаётся динамически, например, файл загружается из инета,
 * то необходимо использовать более прогрессивный подход.
 *
 * Reading a file and creating its copy with the use of basic Java mechanism
 * @author Ihor Savchenko
 * @version 1.0
 */
public class InputStreamToFilePlainJava {

    public void convertingToFile() throws IOException {

        System.out.println(this.getClass().getResource("/").getPath());

        InputStream initialStream = new FileInputStream(
                new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/sample.pdf")));
        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        File targetFile = new File(String.format("%s%s", this.getClass().getResource("/").getPath(), "/targetFile.pdf"));
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        outStream.flush();
        initialStream.close();
        outStream.close();
    }
}
