package net.core.tutorial.medium._04_Serialization.example1.jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.Set;

/**
 * DataObject for marshaling over JAXB.
 * @author Ihor Savchenko
 * @version 1.0
 */
@XmlRootElement(name = "dataObj")
@XmlAccessorType(XmlAccessType.NONE)
public class DataObjectJAXB {

    @XmlAttribute
    static private int number;

    @XmlTransient
    private int age;

    private String s;
    private List<String> list;
    private Set<String> set;
    private Set<CustomObjectJAXB> setCustomObject;
    private AnotherCustomObjectJAXB anotherCustomObjectJAXB;

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

    @XmlElement
    public void setS(String s) {
        this.s = s;
    }

    public List<String> getList() {
        return list;
    }

    @XmlElement(required = true, name = "li")
    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    @XmlElement
    @XmlElementWrapper(name = "elements")
    public void setSet(Set<String> set) {
        this.set = set;
    }

    @XmlElement
    @XmlElementWrapper(name = "customElements")
    public Set<CustomObjectJAXB> getSetCustomObject() {
        return setCustomObject;
    }

    public void setSetCustomObject(Set<CustomObjectJAXB> setCustomObject) {
        this.setCustomObject = setCustomObject;
    }

    public AnotherCustomObjectJAXB getAnotherCustomObjectJAXB() {
        return anotherCustomObjectJAXB;
    }

    @XmlElement
    public void setAnotherCustomObjectJAXB(AnotherCustomObjectJAXB anotherCustomObjectJAXB) {
        this.anotherCustomObjectJAXB = anotherCustomObjectJAXB;
    }

    @Override
    public String toString() {
        return "DataObjectJAXB{" +
                "age=" + age +
                ", s='" + s + '\'' +
                ", list=" + list +
                ", set=" + set +
                ", setCustomObject=" + setCustomObject +
                ", anotherCustomObjectJAXB=" + anotherCustomObjectJAXB +
                '}';
    }
}
