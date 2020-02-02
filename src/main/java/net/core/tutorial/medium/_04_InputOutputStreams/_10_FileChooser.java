package net.core.tutorial.medium._04_InputOutputStreams;

import javax.swing.*;
import java.io.*;

/**
 Чтение файла с диска через диалоговое окно выбора файла и создание копии файла.
 Использование try-with-resources.
 */
public class _10_FileChooser {

    private static String FILE_NAME_COPY = "e:/tmp/image.jpg";

    public static void main(String[] args) throws IOException {

        File inputFile = null;

        JFileChooser fileOpen = new JFileChooser();
        int option = fileOpen.showDialog(null,"Открыть файл");
        if(option == JFileChooser.APPROVE_OPTION){
            inputFile = fileOpen.getSelectedFile();
        }
        if (!inputFile.exists()){
            System.out.println("Файл не существует.");
        }

        try(InputStream inputStream = new FileInputStream(inputFile);
            OutputStream outputStream = new FileOutputStream(FILE_NAME_COPY);
            OutputStream buf = new BufferedOutputStream(outputStream, 1024*8)) {

            long start = System.currentTimeMillis();
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                buf.write(data);
            }
            buf.flush();
            long stop = System.currentTimeMillis();
            System.out.println("Запись выполнена за " + (stop - start) + " ms");
        }
    }
}
