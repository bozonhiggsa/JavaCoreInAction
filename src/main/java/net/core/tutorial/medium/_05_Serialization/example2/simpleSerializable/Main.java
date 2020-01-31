package net.core.tutorial.medium._05_Serialization.example2.simpleSerializable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Author author1 = new Author("Victor", "Pelevin", "fiction");
        Author author2 = new Author("Stiven", "King", "horror");

        System.out.println(author1);
        System.out.println(author2);

        Book book1 = new Book(1L, "Generation P", Arrays.asList(author1), 300, 2003, 450.00);
        Book book2 = new Book(2L, "Оно", Arrays.asList(author2), 500, 2014, 950.50);

        System.out.println(book1);
        System.out.println(book2);

        Reader reader = new Reader("Oleg", "Sergeenko", new ArrayList<>(Arrays.asList(book1, book2)));

        System.out.println(reader);

        // Создание потока, связанного с папкой проекта src/main/resources/
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/test.bin")); ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/test.bin"))) {
            outputStream.writeObject(reader);

            Reader readerNew = (Reader) inputStream.readObject();
            System.out.println(readerNew);
            System.out.println(reader.equals(readerNew));
        }
    }
}

