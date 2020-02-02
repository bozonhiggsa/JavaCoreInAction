package net.core.tutorial.proficient._03_XML.entity;

public class Conditioner {

    protected String content;

    protected String hotel_include;

    public String getContent() {
        return content;
    }

    public void setContent(String value) {
        this.content = value;
    }

    public String getHotel_include() {
        return hotel_include;
    }

    public void setHotel_include(String hotel_include) {
        this.hotel_include = hotel_include;
    }

    @Override
    public String toString() {
        return content;
    }
}
