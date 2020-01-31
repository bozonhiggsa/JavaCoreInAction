package net.core.tutorial.medium._05_Serialization.example2.jaxb;


import javax.xml.bind.annotation.XmlElement;

public abstract class StuffJAXB {
    private Long id;

    public StuffJAXB() {
    }

    public StuffJAXB(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @XmlElement
    public void setId(Long id) {
        this.id = id;
    }
}
