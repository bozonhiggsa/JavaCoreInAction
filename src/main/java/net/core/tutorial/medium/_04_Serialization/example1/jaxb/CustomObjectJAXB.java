package net.core.tutorial.medium._04_Serialization.example1.jaxb;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Third-party class for demonstrating the JAXB marshaling.
 * @author Ihor Savchenko
 * @version 1.0
 */
@XmlType
public class CustomObjectJAXB {

    private String name;
    private int level;

    public CustomObjectJAXB(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public CustomObjectJAXB() {
    }

    @XmlTransient
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "CustomObjectJAXB{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
