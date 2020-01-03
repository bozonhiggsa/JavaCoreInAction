package net.core.tutorial.medium._04_Serialization.example1.simpleSerializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * CustomObject implements Externalizable.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class CustomObject implements Externalizable {

    transient boolean b = true;

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(b);
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
    }
}
