package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Пояснение буферизации и использования flush.
 */

public class _02_Simple_IO_Streams {

    public static void main(String[] args) throws IOException {

        OutputStream dst = new ByteArrayOutputStream(); // создали базовый стрим
        dst = new LogOS(dst, "BaseStream"); // обернули базовый стрим в обёртку LogOS
        dst = new BufferedOutputStream(dst, 2); // обернули LogOS в обёртку буферизованного стрима,
                                                // размер буфера 2 байта
        dst = new LogOS(dst, "BufferedStream"); // обернули буферизованный стрим в обёртку LogOS

        dst.write(1);
        dst.write(2);
        dst.write(3);
        dst.write(4);
        dst.write(5);
        dst.flush();
        dst.close();
    }
}

class LogOS extends OutputStream {

    private final OutputStream impl;
    private final String name;

    LogOS(OutputStream impl, String name) {
        this.impl = impl;
        this.name = name;
    }

    @Override
    public void write(int b) throws IOException {
        System.out.println("дёргаем " + name + ":write(" + b + ")");
        impl.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("дёргаем " + name + ":write(" + Arrays.toString(b) + ")");
        impl.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        System.out.println("дёргаем " + name + ":write(" + Arrays.toString(b) + ", " + off + ", " +len + ")");
        impl.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        System.out.println("дёргаем " + name + ":flush");
        impl.flush();
    }

    @Override
    public void close() throws IOException {
        System.out.println("дёргаем " + name + ":close");
        impl.close();
    }
}
