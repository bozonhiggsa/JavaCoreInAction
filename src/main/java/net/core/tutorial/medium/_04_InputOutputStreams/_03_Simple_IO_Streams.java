package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.*;

/**
 * Копирование файла.
 */
public class _03_Simple_IO_Streams {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите название/путь исходного файла:");
        String sourceFileName = reader.readLine();
        File inputFile = new File(sourceFileName);
        while (!inputFile.exists()) {
            System.out.println("Указанный файл не существует. Повторите ввод названия/пути файла:");
            sourceFileName = reader.readLine();
            inputFile = new File(sourceFileName);
        }

        System.out.println("Введите название/путь файла для создания копии:");
        String destinationFileName = reader.readLine();
        File copyFile = new File(destinationFileName);

        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(copyFile);
            OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            while (bufferedInputStream.available() > 0) {
                int data = bufferedInputStream.read();
                bufferedOutputStream.write(data);
            }
            bufferedInputStream.close();
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }
        catch (FileNotFoundException e) {
            throw e;
        }
    }
}
