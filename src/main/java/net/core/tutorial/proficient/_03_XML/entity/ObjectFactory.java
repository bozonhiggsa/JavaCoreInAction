package net.core.tutorial.proficient._03_XML.entity;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public TouristVouchers createTouristVouchers() {
        return new TouristVouchers();
    }

    public TouristVoucher createTouristVoucher() {
        return new TouristVoucher();
    }

    public HotelCharacteristics createHotelCharacteristics() {
        return new HotelCharacteristics();
    }

    public Cost createCost() {
        return new Cost();
    }

    public Include createInclude() {
        return new Include();
    }

}
