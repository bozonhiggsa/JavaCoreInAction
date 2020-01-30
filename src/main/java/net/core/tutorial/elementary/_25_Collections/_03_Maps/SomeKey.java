package net.core.tutorial.elementary._25_Collections._03_Maps;

public class SomeKey {

    private int value1;
    private int value2;

    public SomeKey(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeKey someKey = (SomeKey) o;

        if (value1 != someKey.value1) return false;
        return value2 == someKey.value2;

    }

    @Override
    public int hashCode() {
        int result = value1;
        result = 31 * result + value2;
        return result;
    }

    @Override
    public String toString() {
        return "SomeKey{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
