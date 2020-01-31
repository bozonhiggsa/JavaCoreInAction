package net.core.tutorial.medium._05_Serialization.example2.simpleExternalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class ReaderEx implements Externalizable {
    private static final long serialVersionUID = 11L;

    private String firstName;
    private String lastName;
    private List<BookEx> books;

    public ReaderEx() {
    }

    public ReaderEx(String firstName, String lastName, ArrayList<BookEx> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(books);
        out.writeUTF(firstName);
        out.writeUTF(lastName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        books = (List<BookEx>) in.readObject();
        firstName = in.readUTF();
        lastName = in.readUTF();
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

    public List<BookEx> getBooks() {
        return books;
    }

    public void setBooks(List<BookEx> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ReaderEx{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", books=" + books +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReaderEx readerEx = (ReaderEx) o;

        if (firstName != null ? !firstName.equals(readerEx.firstName) : readerEx.firstName != null) return false;
        if (lastName != null ? !lastName.equals(readerEx.lastName) : readerEx.lastName != null) return false;
        return books != null ? books.equals(readerEx.books) : readerEx.books == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (books != null ? books.hashCode() : 0);
        return result;
    }
}
