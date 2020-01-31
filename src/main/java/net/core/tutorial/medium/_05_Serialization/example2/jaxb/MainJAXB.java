package net.core.tutorial.medium._05_Serialization.example2.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainJAXB {

    public static void main(String[] args){
        DataObjJAXB dataObjJAXB = new DataObjJAXB();
        dataObjJAXB.setId(1);
        ReaderJAXB readerJAXB= new ReaderJAXB("Oleg", "Sergeenko");
        dataObjJAXB.setReaderJAXBS(new ReaderJAXB[] {readerJAXB});

        // first book
        BookJAXB bookJAXB = new BookJAXB();
        AuthorAndGenreJAXB authorAndGenreJAXB = new AuthorAndGenreJAXB("Victor", "Pelevin", "fiction");
        bookJAXB.setAuthorAndGenreJAXB(authorAndGenreJAXB);
        bookJAXB.setTitle("Generation P");
        bookJAXB.setCost(450.00);
        bookJAXB.setId(500L);
        bookJAXB.setNumberOfPages(300);
        bookJAXB.setYearOfEdition(2003);
        bookJAXB.setAuthorAndGenreJAXB(authorAndGenreJAXB);

        List<BookJAXB> books = new ArrayList<>();
        books.add(bookJAXB);

        // second book
        bookJAXB = new BookJAXB();
        authorAndGenreJAXB = new AuthorAndGenreJAXB("Raffaello", "Giovagnoli", "history");
        bookJAXB.setAuthorAndGenreJAXB(authorAndGenreJAXB);
        bookJAXB.setTitle("Spartak");
        bookJAXB.setCost(450.00);
        bookJAXB.setId(500L);
        bookJAXB.setNumberOfPages(234);
        bookJAXB.setYearOfEdition(2003);
        bookJAXB.setAuthorAndGenreJAXB(authorAndGenreJAXB);

        books.add(bookJAXB);

        readerJAXB.setBooks(books);

//        AuthorAndGenreJAXB authorAndGenreJAXB1 = new AuthorAndGenreJAXB("Stiven", "King", "horror");

        try {
            /*File file = new File(System.getProperty("user.dir")
                    + File.separator + "storeXML.xml");*/
            File file = new File("src/main/resources/storeXML.xml");


            JAXBContext context = JAXBContext.newInstance(DataObjJAXB.class);


            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(dataObjJAXB, file);
            marshaller.marshal(dataObjJAXB, System.out);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DataObjJAXB dataObjFromXml = (DataObjJAXB) unmarshaller.unmarshal(file);
            System.out.println(dataObjFromXml);
        } catch (JAXBException ex) {
            Logger.getLogger(MainJAXB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}

