package net.core.tutorial.medium._05_Serialization.example2.simpleSerializable;

import java.util.List;

public class Book extends Stuff {

    private String title;
    private List<Author> authors;
    private int numberOfPages;
    private int yearOfEdition;
    private double cost;

    public Book() {
    }

    public Book(Long id, String title, List<Author> authors, int numberOfPages, int yearOfEdition, double cost) {
        super(id);
        this.title = title;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.yearOfEdition = yearOfEdition;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" +
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

        Book book = (Book) o;

        if (numberOfPages != book.numberOfPages) return false;
        if (yearOfEdition != book.yearOfEdition) return false;
        if (Double.compare(book.cost, cost) != 0) return false;
        if (!title.equals(book.title)) return false;
        return authors.equals(book.authors);

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }

    public void setYearOfEdition(int yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
