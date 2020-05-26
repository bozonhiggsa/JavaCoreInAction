package net.core.tutorial.medium._04_InputOutputStreams;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class _01_Simple_IO_Streams {

    public static void main(String[] args) throws IOException {

        InputStream src1 = new URL("http://google.com").openStream(); // Считывание страницы из инета в файл на диске
        OutputStream dst1 = new FileOutputStream("home/ihor/temp/google1.html");
        copyByteOverByte(src1, dst1);
        src1.close();
        dst1.close();

        InputStream src2 = new URL("http://google.com").openStream(); // Считывание страницы из инета в файл на диске
        copyByteOverByte(src2, System.out); // можно вывести прямо в консоль, т.к. поле System.out это тоже OutputStream
        src2.close();

        InputStream src3 = new URL("http://google.com").openStream(); // Считывание страницы из инета в файл на диске
        OutputStream dst3 = new FileOutputStream("home/ihor/temp/google2.html");
        copyOverBuffer(src3, dst3);
        src3.close();
        dst3.flush();
        dst3.close();

    }

    public static void copyByteOverByte(InputStream src, OutputStream dst) throws IOException {

        while(true){
            int data = src.read();
            if(data != -1){
                dst.write(data);}
            else {
                return;
            }
        }
    }

    public static void copyOverBuffer(InputStream src, OutputStream dst) throws IOException {

        byte[] buffer = new byte[64 * 1024]; // создаём буфер на 64 кбайт

        while(true){
            int count = src.read(buffer); // метод .read с аргументом byte[] возвращает количество считанных байт
            if(count != -1){
                dst.write(buffer, 0, count);}
            else {
                return;
            }
        }
    }
}
