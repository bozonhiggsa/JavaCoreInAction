package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TouristVoucher", propOrder = { "typeVoucher", "country", "numberDaysNights", "transports", "hotelCharacteristics", "cost" })
public class TouristVoucher {

    @XmlElement(name = "TypeVoucher", required = true)
    protected String typeVoucher;

    @XmlElement(name = "Country", required = true)
    protected String country;

    @XmlElement(name = "NumberDaysNights", required = true)
    protected int numberDaysNights;

    @XmlElement(name = "Transport")
    protected List<String> transports;

    @XmlElement(name = "HotelCharacteristics", required = true)
    protected HotelCharacteristics hotelCharacteristics;

    @XmlElement(name = "Cost", required = true)
    protected Cost cost;

    public String getTypeVoucher() {
        return typeVoucher;
    }

    public void setTypeVoucher(String typeVoucher) {
        this.typeVoucher = typeVoucher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumberDaysNights() {
        return numberDaysNights;
    }

    public void setNumberDaysNights(int numberDaysNights) {
        this.numberDaysNights = numberDaysNights;
    }

    public HotelCharacteristics getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    public void setHotelCharacteristics(HotelCharacteristics hotelCharacteristics) {
        this.hotelCharacteristics = hotelCharacteristics;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public List<String> getTransports() {
        if (transports == null)
            transports = new ArrayList<String>();
        return transports;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(typeVoucher).append('\n');
        result.append(country).append('\n');
        result.append(numberDaysNights).append('\n');
        if(transports != null){
            for (String transport : transports)
                result.append(transport).append('\n');
        }
        result.append(hotelCharacteristics).append('\n');
        result.append(cost).append('\n');
        return result.toString();
    }
}
