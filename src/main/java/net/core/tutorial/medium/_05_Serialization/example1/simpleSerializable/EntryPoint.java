package net.core.tutorial.medium._05_Serialization.example1.simpleSerializable;

import java.io.*;

/**
 * Entry Point for demonstrating the simple serializable.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPoint {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        DataObject dataObject = new DataObject();
        dataObject.setText("Howdy y'all, my friends!");
        // Создание потока, связанного с папкой проекта target/classes/
        FileOutputStream outputStream = new FileOutputStream(String
                                                          .format("%s%s", EntryPoint.class.getClass().getResource("/").getPath(), "store.bin"));
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeObject(dataObject);
        out.flush();
        out.close();

        FileInputStream inputStream = new FileInputStream(String
                                                           .format("%s%s", EntryPoint.class.getClass().getResource("/").getPath(), "store.bin"));
        ObjectInputStream input = new ObjectInputStream(inputStream);
        DataObject dataObjectAfterReading = (DataObject) input.readObject();
        input.close();
        System.out.println(dataObjectAfterReading.getClass());
        System.out.println(dataObjectAfterReading.getText());
        System.out.println(dataObjectAfterReading.customObject.b);
    }
}
