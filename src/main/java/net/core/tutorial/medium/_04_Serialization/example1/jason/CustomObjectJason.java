package net.core.tutorial.medium._04_Serialization.example1.jason;

/**
 * Third-party class for demonstrating the JASON marshaling.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class CustomObjectJason {

    private String name;
    private int level;

    public CustomObjectJason(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public CustomObjectJason() {
    }

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
        return "CustomObjectJason{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
