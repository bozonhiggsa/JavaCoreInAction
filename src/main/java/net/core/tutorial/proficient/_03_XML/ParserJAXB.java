package net.core.tutorial.proficient._03_XML;

import org.xml.sax.SAXException;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

/**
 * Entry Point for demonstrating the marshaling and unmarshaling using JAXB.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ParserJAXB {

    public static final String VALID_XML_FILE = "input.xml";
    public static final String OUTPUT_XML_FILE = "output.jaxb.xml";
    public static final String INVALID_XML_FILE = "file_invalid.xml";
    public static final String XSD_FILE = "input.xsd";
    public static final String JAXB__PACKAGE = "net.core.tutorial.proficient._03_XML.entity";


    public static void main(String[] args) throws JAXBException, SAXException {

        File file = new File(VALID_XML_FILE);
        //JAXBContext context = JAXBContext.newInstance(TouristVouchers.class);
        JAXBContext context = JAXBContext.newInstance(JAXB__PACKAGE);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        validateJAXB(file, XSD_FILE, unmarshaller);
        TouristVouchers touristVouchersFromXml = (TouristVouchers) unmarshaller.unmarshal(file);
        System.out.println(touristVouchersFromXml);
        SaverJAXB.saveXmlFile(touristVouchersFromXml, OUTPUT_XML_FILE, XSD_FILE);
    }

    public static void validateJAXB(final File xmlFile, final String xsdFileName,
                                    Unmarshaller unmarshaller) throws JAXBException, SAXException {

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        if (xsdFileName != null) {
            Schema schema = null;
            if ("".equals(xsdFileName)) {
                // setup validation against XSD pointed in XML
                schema = sf.newSchema();
            } else {
                // setup validation against external XSD
                schema = sf.newSchema(new File(xsdFileName));
            }

            unmarshaller.setSchema(schema); // <-- set XML schema for validation

            // set up handler
            unmarshaller.setEventHandler(new ValidationEventHandler() {
                // this method will be invoked if XML is NOT valid
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    // at this point we have NOT valid XML document
                    // just print message
                    System.err.println("====================================");
                    System.err.println(xmlFile.getName() + " is NOT valid against "
                            + xsdFileName + ":\n" + event.getMessage());
                    System.err.println("====================================");

                    // if we place 'return false;' unmarshal method throws
                    // exception
                    // 'return true;' does not imply any exceptions
                    return true;
                }
            });
        }
    }
}
