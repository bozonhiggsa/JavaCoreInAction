package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Пояснение к паттерну Decorator.
 */

public class _03_IO_Streams_Decorator {

    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream buf = new ByteArrayOutputStream(); //конечный получатель - байтовый массив
        OutputStream dst = new BufferedOutputStream(buf, 8 * 1024); //буферизация
        dst = new GZIPOutputStream(dst); //сжатие
        DataOutput out = new DataOutputStream(dst); //Класс DataOutputStream содержит методы для преобразования
                                                    //разных типов данных в байты


        for (int i = 0; i < 1000_000; i++) {
            out.writeDouble(i % 2 == 0 ? 0.5 : 1.5);  //преобразование данных типа double в байты
        }

        dst.flush(); //У DataOutput нет flush, поэтому вызываем flush у dst
        dst.close();
        byte[] rawData = buf.toByteArray(); //извлечение данных из ByteArrayOutputStream
        System.out.println(rawData.length);

        //Обратные преобразования
        DataInput src = new DataInputStream(
                new GZIPInputStream(
                        new BufferedInputStream(
                                new ByteArrayInputStream(rawData))));

        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readDouble());
        System.out.println(src.readInt());  //Пример слабой типизации. Теперь из байт можно получать не только double
        System.out.println(src.readByte());
    }
}
