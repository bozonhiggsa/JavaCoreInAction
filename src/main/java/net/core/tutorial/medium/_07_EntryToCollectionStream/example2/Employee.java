package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

import java.io.Serializable;

public class Employee implements Serializable{
    private String name;
    private String surname;
    private int id;
    private int age;
    private Position position;

    public Employee(String name, String surname, int id, int age, Position position) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.age = age;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", position=" + position +
                '}';
    }
}
