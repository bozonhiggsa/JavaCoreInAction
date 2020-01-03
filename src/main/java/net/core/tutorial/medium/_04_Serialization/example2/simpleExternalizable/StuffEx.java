package net.core.tutorial.medium._04_Serialization.example2.simpleExternalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class StuffEx implements Externalizable {

    private Long id;

    public StuffEx() {
    }

    public StuffEx(Long id) {
        this.id = id;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = (Long) in.readObject();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StuffEx{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StuffEx stuffEx = (StuffEx) o;

        return id.equals(stuffEx.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
