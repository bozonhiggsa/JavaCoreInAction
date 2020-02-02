package net.core.tutorial.proficient._03_XML.entity;

public enum XML {

    // these are tags
    TOURIST_VOUCHERS("TouristVouchers"), TOURIST_VOUCHER("TouristVoucher"), HOTEL_CHARACTERISTICS("HotelCharacteristics"), INCLUDE("Include"), COST("Cost"),
    TYPE_VOUCHER("TypeVoucher"), COUNTRY("Country"), NUMBER_DAYS_NIGHT("NumberDaysNights"), TRANSPORT("Transport"),
    TELEVISION("TV"), CONDITIONER("Conditioner"), STARS("Stars"), FOOD("Food"), APARTMENTS("Apartments"),
    MONEY("Money"), INCLUDE_TRANSPORT("IncludeTransport"), INCLUDE_TELEVISION("IncludeTV"), INCLUDE_CONDITIONER("IncludeConditioner"),
    INCLUDE_APARTMENTS("IncludeApartments"), INCLUDE_FOOD("IncludeFood"), VOUCHER_INCLUDE("voucher_include"),
    HOTEL_INCLUDE("hotel_include");

    private String value;

    public String value() {
        return value;
    }

    XML(String value) {
        this.value = value.intern();
    }
}
