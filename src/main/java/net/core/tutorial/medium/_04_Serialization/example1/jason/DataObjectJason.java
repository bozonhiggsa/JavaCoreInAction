package net.core.tutorial.medium._04_Serialization.example1.jason;

import java.util.List;
import java.util.Set;

/**
 * DataObject for marshaling over JASON.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DataObjectJason {

    static private int number;

    private int age;

    private String s;
    private List<String> list;
    private Set<String> set;
    private Set<CustomObjectJason> setCustomObject;
    private AnotherCustomObjectJason anotherCustomObjectJason;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Set<CustomObjectJason> getSetCustomObject() {
        return setCustomObject;
    }

    public void setSetCustomObject(Set<CustomObjectJason> setCustomObject) {
        this.setCustomObject = setCustomObject;
    }

    public AnotherCustomObjectJason getAnotherCustomObjectJason() {
        return anotherCustomObjectJason;
    }

    public void setAnotherCustomObjectJason(AnotherCustomObjectJason anotherCustomObjectJason) {
        this.anotherCustomObjectJason = anotherCustomObjectJason;
    }

    @Override
    public String toString() {
        return "DataObjectJason{" +
                "age=" + age +
                ", s='" + s + '\'' +
                ", list=" + list +
                ", set=" + set +
                ", setCustomObject=" + setCustomObject +
                ", anotherCustomObjectJason=" + anotherCustomObjectJason +
                '}';
    }
}
