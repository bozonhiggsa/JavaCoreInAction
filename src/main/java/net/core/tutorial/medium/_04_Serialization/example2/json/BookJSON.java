package net.core.tutorial.medium._04_Serialization.example2.json;

import java.util.List;

public class BookJSON extends StuffJSON {

    private String title;
    private List<AuthorAndGenreJSON> authors;
    private int numberOfPages;
    private int yearOfEdition;
    private double cost;


    public BookJSON(Long id,  String title, int numberOfPages, int yearOfEdition, double cost) {
        super(id);
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfEdition = yearOfEdition;
        this.cost = cost;
    }

    public BookJSON() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorAndGenreJSON> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorAndGenreJSON> authors) {
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

    @Override
    public String toString() {
        return "BookJSON{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                ", yearOfEdition=" + yearOfEdition +
                ", cost=" + cost +
                '}';
    }
}
