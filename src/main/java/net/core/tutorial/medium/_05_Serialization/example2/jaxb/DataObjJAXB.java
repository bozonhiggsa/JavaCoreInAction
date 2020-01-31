package net.core.tutorial.medium._05_Serialization.example2.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "dataObjJAXB")
public class DataObjJAXB {
    private ReaderJAXB[] readerJAXBS;

    private Integer id;

    public DataObjJAXB() {
    }

    public ReaderJAXB[] getReaderJAXBS() {
        return readerJAXBS;
    }

    public void setReaderJAXBS(ReaderJAXB[] readerJAXBS) {
        this.readerJAXBS = readerJAXBS;
    }

    @XmlAttribute
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DataObjJAXB{" +
                "readerJAXBS=" + Arrays.toString(readerJAXBS) +
                '}';
    }
}
