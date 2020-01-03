package net.core.tutorial.medium._04_Serialization.example1.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Entry Point for demonstrating the marshaling and unmarshaling using JAXB.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPointJAXB {

    public static void main(String[] args) throws JAXBException {

        DataObjectJAXB dataObj = new DataObjectJAXB();
        dataObj.setNumber(33);
        dataObj.setAge(99);
        dataObj.setS("Hey!");
        dataObj.setList(Arrays.asList("One", "Two", "Three", "Four", "One"));
        Set<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        dataObj.setSet(set);
        HashSet<CustomObjectJAXB> customSet = new HashSet<CustomObjectJAXB>();
        customSet.add(new CustomObjectJAXB("Green", 10));
        customSet.add(new CustomObjectJAXB("Red", 100));
        customSet.add(new CustomObjectJAXB("Blue", 1000));
        dataObj.setSetCustomObject(customSet);
        AnotherCustomObjectJAXB anotherCustomObjectJAXB = new AnotherCustomObjectJAXB(80);
        AnotherCustomObjectJAXB.setStature(180);
        dataObj.setAnotherCustomObjectJAXB(anotherCustomObjectJAXB);

        try {
            /*File file = new File(System.getProperty("user.dir")
                    + File.separator + "storeXML.xml");*/
            File file = new File(String
                   .format("%s%s", EntryPointJAXB.class.getClass().getResource("/").getPath(), "storeXML.xml"));
            JAXBContext context = JAXBContext.newInstance(DataObjectJAXB.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(dataObj, file);
            marshaller.marshal(dataObj, System.out);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            DataObjectJAXB dataObjFromXml = (DataObjectJAXB) unmarshaller.unmarshal(file);
            System.out.println(dataObjFromXml);
        } catch (JAXBException ex) {
            Logger.getLogger(EntryPointJAXB.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
