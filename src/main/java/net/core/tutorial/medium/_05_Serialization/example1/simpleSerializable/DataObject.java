package net.core.tutorial.medium._05_Serialization.example1.simpleSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * DataObject extends Non-Serializable object.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DataObject extends NonSerializable implements Serializable {

    int number = 10;
    String s = "Hello";
    transient String[] arrayStrings = {"Hi", "Bye", "Welcome"};
    CustomObject customObject = new CustomObject();

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(getText());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        setText((String)in.readObject());
    }
}
