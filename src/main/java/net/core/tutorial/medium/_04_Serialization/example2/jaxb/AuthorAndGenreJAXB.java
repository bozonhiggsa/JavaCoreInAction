package net.core.tutorial.medium._04_Serialization.example2.jaxb;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class AuthorAndGenreJAXB {

    private String firstName;
    private String lastName;
    private String genre;

    public AuthorAndGenreJAXB(String firstName, String lastName, String genre) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
    }

    public AuthorAndGenreJAXB() {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "AuthorAndGenreJAXB{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
