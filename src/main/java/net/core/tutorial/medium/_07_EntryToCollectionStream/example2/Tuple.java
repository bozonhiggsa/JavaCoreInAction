package net.core.tutorial.medium._07_EntryToCollectionStream.example2;

public class Tuple {
    private Position position;
    private int age;

    public Tuple(Position position, int age) {
        this.position = position;
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

        Tuple tuple = (Tuple) o;

        if (age != tuple.age) return false;
        return position == tuple.position;

    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "position=" + position +
                ", age=" + age +
                '}';
    }
}
