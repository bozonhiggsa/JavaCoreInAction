package net.core.tutorial.medium._04_Serialization.example2.json;

import java.util.List;

public class ReaderJSON {

    private String firstName;
    private String lastName;
    private List<BookJSON> books;


    public ReaderJSON() {
    }

    public ReaderJSON(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public List<BookJSON> getBooks() {
        return books;
    }

    public void setBooks(List<BookJSON> books) {
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "ReaderJSON{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }
}
