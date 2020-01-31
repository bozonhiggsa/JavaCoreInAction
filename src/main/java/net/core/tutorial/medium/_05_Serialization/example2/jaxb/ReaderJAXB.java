package net.core.tutorial.medium._05_Serialization.example2.jaxb;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class ReaderJAXB {

    private String firstName;
    private String lastName;
    private List<BookJAXB> books;

    public ReaderJAXB() {
    }
    public ReaderJAXB(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<BookJAXB> getBooks() {
        return books;
    }

    @XmlElement(name = "book")
    @XmlElementWrapper(name = "books")
    public void setBooks(List<BookJAXB> books) {
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    @XmlAttribute
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @XmlAttribute
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ReaderJAXB{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

}
