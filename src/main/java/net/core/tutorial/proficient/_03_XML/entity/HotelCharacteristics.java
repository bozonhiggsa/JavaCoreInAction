package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HotelCharacteristics", propOrder = { "stars", "foods", "tvs", "conditioners", "apartments" })
public class HotelCharacteristics {

    @XmlElement(name = "Stars", required = true)
    protected int stars;

    @XmlElement(name = "Food")
    protected List<String> foods;

    @XmlElement(name = "TV")
    protected List<String> tvs;

    @XmlElement(name = "Conditioner")
    protected List<String> conditioners;

    @XmlElement(name = "Apartments", required = true)
    protected List<Integer> apartments;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public List<String> getFoods() {
        if (foods == null)
            foods = new ArrayList<String>();
        return foods;
    }

    public List<String> getTvs() {
        if (tvs == null)
            tvs = new ArrayList<String>();
        return tvs;
    }

    public List<String> getConditioners() {
        if (conditioners == null)
            conditioners = new ArrayList<String>();
        return conditioners;
    }

    public List<Integer> getApartments() {
        if (apartments == null)
            apartments = new ArrayList<Integer>();
        return apartments;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(stars).append('\n');
        if(foods != null){
            for (String food : foods)
                result.append(food).append('\n');
        }
        if(tvs != null){
            for (String tv : tvs)
                result.append(tv).append('\n');
        }
        if(conditioners != null){
            for (String conditioner : conditioners)
                result.append(conditioner).append('\n');
        }
        for (Integer apartment : apartments)
            result.append(apartment).append('\n');
        return result.toString();
    }
}
