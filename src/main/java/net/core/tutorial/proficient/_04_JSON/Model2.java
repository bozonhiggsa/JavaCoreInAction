package net.core.tutorial.proficient._04_JSON;

import java.util.Arrays;

public class Model2 {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Model2{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
