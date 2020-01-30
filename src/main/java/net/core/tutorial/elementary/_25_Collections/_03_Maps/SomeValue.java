package net.core.tutorial.elementary._25_Collections._03_Maps;

public class SomeValue {

    private String name;
    private int age;

    public SomeValue(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeValue someValue = (SomeValue) o;

        if (age != someValue.age) return false;
        return name != null ? name.equals(someValue.name) : someValue.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "SomeValue{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
