package net.core.tutorial.medium._07_EntryToCollectionStream.example1;

/**
 * Model for populate a collection
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Person {

    private String name;
    private String expertise;
    private int level;


    public Person(String name, String expertise, int level) {
        this.name = name;
        this.expertise = expertise;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Person: " + String.format("%s - %s - %d", this.getName(),
                                     this.getExpertise(), this.getLevel());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
