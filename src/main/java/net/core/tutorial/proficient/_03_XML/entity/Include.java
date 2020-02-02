package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Include", propOrder = { "includeTransports", "includeTvs", "includeConditioners", "includeApartments", "includeFoods" })
public class Include {

    @XmlElement(name = "IncludeTransport")
    protected List<String> includeTransports;

    @XmlElement(name = "IncludeTV")
    protected List<String> includeTvs;

    @XmlElement(name = "IncludeConditioner")
    protected List<String> includeConditioners;

    @XmlElement(name = "IncludeApartments", required = true)
    protected List<Integer> includeApartments;

    @XmlElement(name = "IncludeFood")
    protected List<String> includeFoods;

    public List<String> getIncludeTransports() {
        if (includeTransports == null)
            includeTransports = new ArrayList<String>();
        return includeTransports;
    }

    public List<String> getIncludeTvs() {
        if (includeTvs == null)
            includeTvs = new ArrayList<String>();
        return includeTvs;
    }

    public List<String> getIncludeConditioners() {
        if (includeConditioners == null)
            includeConditioners = new ArrayList<String>();
        return includeConditioners;
    }

    public List<Integer> getIncludeApartments() {
        if (includeApartments == null)
            includeApartments = new ArrayList<Integer>();
        return includeApartments;
    }

    public List<String> getIncludeFoods() {
        if (includeFoods == null)
            includeFoods = new ArrayList<String>();
        return includeFoods;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if(includeTransports != null){
            for (String transport : includeTransports)
                result.append(transport).append('\n');
        }
        if(includeTvs != null){
            for (String tv : includeTvs)
                result.append(tv).append('\n');
        }
        if(includeConditioners != null){
            for (String conditioner : includeConditioners)
                result.append(conditioner).append('\n');
        }
        for (Integer apartment : includeApartments)
            result.append(apartment).append('\n');
        if(includeFoods != null){
            for (String food : includeFoods)
                result.append(food).append('\n');
        }
        return result.toString();
    }
}
