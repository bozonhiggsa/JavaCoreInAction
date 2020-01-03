package net.core.tutorial.medium._04_Serialization.example2.simpleExternalizable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class BookEx extends StuffEx {

    private String title;
    private List<AuthorEx> authors;
    private int numberOfPages;
    private int yearOfEdition;
    private double cost;

    public BookEx(Long id, String title, List<AuthorEx> authors, int numberOfPages, int yearOfEdition, double cost) {
        super(id);
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.yearOfEdition = yearOfEdition;
        this.cost = cost;
    }

    public BookEx() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeUTF(title);
        out.writeObject(authors);
        out.writeInt(numberOfPages);
        out.writeInt(yearOfEdition);
        out.writeDouble(cost);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        title = in.readUTF();
        authors = (List<AuthorEx>) in.readObject();
        numberOfPages = in.readInt();
        yearOfEdition = in.readInt();
        cost = in.readDouble();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookEx{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                ", yearOfEdition=" + yearOfEdition +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEx bookEx = (BookEx) o;

        if (numberOfPages != bookEx.numberOfPages) return false;
        if (yearOfEdition != bookEx.yearOfEdition) return false;
        if (Double.compare(bookEx.cost, cost) != 0) return false;
        if (!title.equals(bookEx.title)) return false;
        return authors.equals(bookEx.authors);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title.hashCode();
        result = 31 * result + authors.hashCode();
        result = 31 * result + numberOfPages;
        result = 31 * result + yearOfEdition;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
