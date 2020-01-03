package net.core.tutorial.medium._04_Serialization.example2.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainJSON {

    public static void main(String[] args) {
        ReaderJSON readerJSON = new ReaderJSON("Oleg", "Sergeenko");
        readerJSON.setBooks(new ArrayList<BookJSON>());
        readerJSON.getBooks().add(bookInfo(500L, "Generation P", 300, 2003, 450.00, "Victor", "Pelevin", "fiction"));
        readerJSON.getBooks().add(bookInfo(500L, "Spartak", 234, 2003, 450.00, "Raffaello", "Giovagnoli", "history"));

        Gson gson = new Gson();
        String json = gson.toJson(readerJSON);
        ReaderJSON dataObjFromJson1 = gson.fromJson(json, ReaderJSON.class);
        System.out.println(dataObjFromJson1);

        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String jsonPretty = gsonPretty.toJson(readerJSON);
        ReaderJSON dataObjFromJson2 = gsonPretty.fromJson(jsonPretty, ReaderJSON.class);
        System.out.println(dataObjFromJson2);

    }

    private static List<AuthorAndGenreJSON> createAuthor(String firstName, String lastName, String genre) {
        AuthorAndGenreJSON authorAndGenreJSON = new AuthorAndGenreJSON();
        authorAndGenreJSON.setFirstName(firstName);
        authorAndGenreJSON.setLastName(lastName);
        authorAndGenreJSON.setGenre(genre);

        List<AuthorAndGenreJSON> list = new ArrayList<>();
        list.add(authorAndGenreJSON);
        return list;
    }

    private static BookJSON bookInfo(Long id, String title, int numberOfPages, int yearOfEdition, double cost, String firstName, String lastName, String genre) {
        BookJSON bookJSON = new BookJSON(id, title, numberOfPages, yearOfEdition, cost);
        bookJSON.setAuthors(createAuthor(firstName, lastName, genre));
        return bookJSON;
    }
}

