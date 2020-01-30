package net.core.tutorial.elementary._25_Collections._03_Maps;

import java.util.Comparator;

public class SomeTreeKey {

    private int value1;
    private int value2;

    public SomeTreeKey(int value1, int value2) {
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
    public String toString() {
        return "SomeTreeKey{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}

class SomeTreeKeyComparator implements Comparator<SomeTreeKey> {

    @Override
    public int compare(SomeTreeKey k1, SomeTreeKey k2) {

        if(k1.getValue1() == k2.getValue1() && k1.getValue2() == k2.getValue2()){
            return 0;
        }
        else{
            if (k1.getValue1() > k2.getValue1()){
                return 1;
            }
            else return -1;
        }
    }
}
