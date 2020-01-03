package net.core.tutorial.medium._04_Serialization.example2.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
public class BookJAXB extends StuffJAXB{

    public BookJAXB(Long id, String title, int numberOfPages, int yearOfEdition, double cost) {
        super(id);
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearOfEdition = yearOfEdition;
        this.cost = cost;
    }

    private String title;
    private List<AuthorAndGenreJAXB> authors;
    private int numberOfPages;
    private int yearOfEdition;
    private double cost;

    public BookJAXB() {
    }

    public String getTitle() {
        return title;
    }
    @XmlElement
    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorAndGenreJAXB getAuthorAndGenreJAXB() {
        return authorAndGenreJAXB;
    }

    @XmlElement
    public void setAuthorAndGenreJAXB(AuthorAndGenreJAXB authorAndGenreJAXB) {
        this.authorAndGenreJAXB = authorAndGenreJAXB;
    }

    private AuthorAndGenreJAXB authorAndGenreJAXB;

    public List<AuthorAndGenreJAXB> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorAndGenreJAXB> authors) {
        this.authors = authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
    @XmlElement
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getYearOfEdition() {
        return yearOfEdition;
    }
    @XmlElement
    public void setYearOfEdition(int yearOfEdition) {
        this.yearOfEdition = yearOfEdition;
    }

    public double getCost() {
        return cost;
    }
    @XmlElement
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "BookJAXB{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", numberOfPages=" + numberOfPages +
                ", yearOfEdition=" + yearOfEdition +
                ", cost=" + cost +
                '}';
    }
}
