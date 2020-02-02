package net.core.tutorial.proficient._03_XML;

import org.xml.sax.SAXException;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

public class SaverJAXB {

    public static final String JAXB__PACKAGE = "net.core.tutorial.proficient._03_XML.entity";

    public static void saveXmlFile(TouristVouchers touristVouchers, final String xmlFileName,
                                   final String xsdFileName) throws JAXBException, SAXException {

        JAXBContext context = JAXBContext.newInstance(JAXB__PACKAGE);
        Marshaller marshaller = context.createMarshaller();
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // setup validation against XSD
        if (xsdFileName != null) {
            Schema schema = sf.newSchema(new File(xsdFileName));
            marshaller.setSchema(schema);
            marshaller.setEventHandler(new ValidationEventHandler() {
                @Override
                public boolean handleEvent(ValidationEvent event) {
                    // at this point we have NOT valid XML document
                    // just print message
                    System.err.println("====================================");
                    System.err.println(xmlFileName + " is NOT valid against "
                            + xsdFileName + ":\n" + event.getMessage());
                    System.err.println("====================================");

                    // if we place 'return false;' marshal method throws
                    // exception
                    // 'return true;' does not imply any exceptions
                    return false;
                }
            });
        }
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, Constants.SCHEMA_LOCATION__URI);
        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, xsdFileName);
        marshaller.marshal(touristVouchers, new File(xmlFileName));
    }
}
