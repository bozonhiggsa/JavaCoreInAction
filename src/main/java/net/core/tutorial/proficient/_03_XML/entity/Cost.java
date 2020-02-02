package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Cost", propOrder = { "money", "include" })
public class Cost {

    @XmlElement(name = "Money", required = true)
    protected double money;

    @XmlElement(name = "Include", required = true)
    protected Include include;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Include getInclude() {
        return include;
    }

    public void setInclude(Include include) {
        this.include = include;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(money).append('\n');
        result.append(include).append('\n');
        return result.toString();
    }
}
