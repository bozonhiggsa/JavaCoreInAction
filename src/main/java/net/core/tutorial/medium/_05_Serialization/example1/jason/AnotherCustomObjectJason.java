package net.core.tutorial.medium._05_Serialization.example1.jason;

/**
 * Another third-party class for demonstrating the JASON marshaling.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class AnotherCustomObjectJason {

    private static int stature;
    private float weight;

    public AnotherCustomObjectJason(float weight) {
        this.weight = weight;
    }

    public AnotherCustomObjectJason() {
    }

    public static int getStature() {
        return stature;
    }

    public static void setStature(int stature) {
        AnotherCustomObjectJason.stature = stature;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "AnotherCustomObjectJason{" +
                "weight=" + weight +
                '}';
    }
}
