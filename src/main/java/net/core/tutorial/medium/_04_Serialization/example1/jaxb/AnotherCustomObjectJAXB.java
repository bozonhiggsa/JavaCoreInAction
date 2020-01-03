package net.core.tutorial.medium._04_Serialization.example1.jaxb;

import javax.xml.bind.annotation.XmlType;

/**
 * Another third-party class for demonstrating the JAXB marshaling.
 * @author Ihor Savchenko
 * @version 1.0
 */
@XmlType
public class AnotherCustomObjectJAXB {

    private static int stature;
    private float weight;

    public AnotherCustomObjectJAXB(float weight) {
        this.weight = weight;
    }

    public AnotherCustomObjectJAXB() {
    }

    public static int getStature() {
        return stature;
    }

    public static void setStature(int stature) {
        AnotherCustomObjectJAXB.stature = stature;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "AnotherCustomObjectJAXB{" +
                "weight=" + weight +
                '}';
    }
}
