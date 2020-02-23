package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

import java.util.HashSet;
import java.util.Set;

public class Department {
    private int id;
    private int parent;
    private String name;
    private Set<Department> childs = new HashSet<>();

    public Department(int id, int parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", childs=" + childs +
                '}';
    }
}
