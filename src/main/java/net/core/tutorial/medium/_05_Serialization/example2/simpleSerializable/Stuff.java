package net.core.tutorial.medium._05_Serialization.example2.simpleSerializable;

import java.io.Serializable;

public abstract class Stuff implements Serializable {

    private Long id;

    public Stuff() {
    }

    public Stuff(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Stuff{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stuff stuff = (Stuff) o;

        return id.equals(stuff.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
