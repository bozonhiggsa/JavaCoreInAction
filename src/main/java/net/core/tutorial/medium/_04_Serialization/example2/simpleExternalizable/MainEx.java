package net.core.tutorial.medium._04_Serialization.example2.simpleExternalizable;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainEx {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        AuthorEx author1 = new AuthorEx("Victor", "Pelevin", "fiction");
        AuthorEx author2 = new AuthorEx("Stiven", "King", "horror");

        System.out.println(author1);
        System.out.println(author2);

        BookEx book1 = new BookEx(1L, "Generation P", Arrays.asList(author1), 300, 2003, 450.00);
        BookEx book2 = new BookEx(2L, "Оно", Arrays.asList(author2), 500, 2014, 950.50);

        System.out.println(book1);
        System.out.println(book2);

        ReaderEx reader = new ReaderEx("Oleg", "Sergeenko", new ArrayList<>(Arrays.asList(book1, book2)));

        System.out.println(reader);

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("src/main/resources/test1.bin")); ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/main/resources/test1.bin"))) {
            outputStream.writeObject(reader);

            ReaderEx readerNew = (ReaderEx) inputStream.readObject();
            System.out.println(readerNew);
            System.out.println(reader.equals(readerNew));
        }
    }
}

