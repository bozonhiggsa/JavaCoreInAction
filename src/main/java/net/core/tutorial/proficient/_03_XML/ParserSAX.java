package net.core.tutorial.proficient._03_XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;
import java.io.IOException;

/**
 * Controller for SAX parser.
 */
public class ParserSAX extends DefaultHandler {

    public static final String VALID_XML_FILE = "input.xml";
    public static final String OUTPUT_XML_FILE = "output.sax.xml";
    public static final String INVALID_XML_FILE = "file_invalid.xml";
    public static final String XSD_FILE = "input.xsd";
    public static final String CLASS_SAX_PARSER_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl";
    public static final String FEATURE_TURN_VALIDATION_ON =
            "http://xml.org/sax/features/validation";
    public static final String FEATURE_TURN_SCHEMA_VALIDATION_ON =
            "http://apache.org/xml/features/validation/schema";

    private String xmlFileName;
    private String currentElement; // <-- current element name holder

    private TouristVouchers vouchers; // <-- main container
    private TouristVoucher touristVoucher;
    private HotelCharacteristics hotelCharacteristics;
    private Cost cost;
    private Include include;

    public TouristVouchers getVouchers() {
        return vouchers;
    }

    public ParserSAX(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document.
     *
     * @param validate
     *            If true validate XML document against its XML schema. With
     *            this parameter it is possible make parser validating.
     */
    public void parse(boolean validate) throws ParserConfigurationException,
            SAXException, IOException {

        SAXParserFactory factory = SAXParserFactory.newInstance(
                CLASS_SAX_PARSER_FACTORY_INTERNAL,
                this.getClass().getClassLoader());

        factory.setNamespaceAware(true);
        if (validate) {
            factory.setFeature(FEATURE_TURN_VALIDATION_ON, true);
            factory.setFeature(FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
        }

        SAXParser parser = factory.newSAXParser();
        parser.parse(xmlFileName, this);
    }

    @Override
    public void error(org.xml.sax.SAXParseException e) throws SAXException {
        throw e; // <-- if XML document not valid just throw exception
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {

        currentElement = localName;

        // WARNING!!!
        // here and below we use '==' operation to compare two INTERNED STRINGS
        if (currentElement == XML.TOURIST_VOUCHERS.value()) {
            vouchers = new TouristVouchers();
            return;
        }

        if (currentElement == XML.TOURIST_VOUCHER.value()) {
            touristVoucher = new TouristVoucher();
            return;
        }

        if (currentElement == XML.HOTEL_CHARACTERISTICS.value()) {
            hotelCharacteristics = new HotelCharacteristics();
            return;
        }

        if (currentElement == XML.COST.value()) {
            cost = new Cost();
            return;
        }

        if (currentElement == XML.INCLUDE.value()) {
            include = new Include();
            return;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

        String elementText = new String(ch, start, length).trim();

        if (elementText.isEmpty()) // <-- return if content is empty
            return;

        if (currentElement == XML.TYPE_VOUCHER.value()) {
            touristVoucher.setTypeVoucher(elementText);
            return;
        }

        if (currentElement == XML.COUNTRY.value()) {
            touristVoucher.setCountry(elementText);
            return;
        }

        if (currentElement == XML.NUMBER_DAYS_NIGHT.value()) {
            touristVoucher.setNumberDaysNights(Integer.parseInt(elementText));
            return;
        }

        if (currentElement == XML.TRANSPORT.value()) {
            touristVoucher.getTransports().add(elementText);
            return;
        }

        if (currentElement == XML.STARS.value()) {
            hotelCharacteristics.setStars(Integer.parseInt(elementText));
            return;
        }

        if (currentElement == XML.FOOD.value()) {
            hotelCharacteristics.getFoods().add(elementText);
            return;
        }

        if (currentElement == XML.TELEVISION.value()) {
            hotelCharacteristics.getTvs().add(elementText);
            return;
        }

        if (currentElement == XML.CONDITIONER.value()) {
            hotelCharacteristics.getConditioners().add(elementText);
            return;
        }

        if (currentElement == XML.APARTMENTS.value()) {
            hotelCharacteristics.getApartments().add(Integer.parseInt(elementText));
            return;
        }

        if (currentElement == XML.MONEY.value()) {
            cost.setMoney(Double.valueOf(elementText));
            return;
        }

        if (currentElement == XML.INCLUDE_TRANSPORT.value()) {
            include.getIncludeTransports().add(elementText);
            return;
        }

        if (currentElement == XML.INCLUDE_TELEVISION.value()) {
            include.getIncludeTvs().add(elementText);
            return;
        }

        if (currentElement == XML.INCLUDE_CONDITIONER.value()) {
            include.getIncludeConditioners().add(elementText);
            return;
        }

        if (currentElement == XML.INCLUDE_FOOD.value()) {
            include.getIncludeFoods().add(elementText);
            return;
        }

        if (currentElement == XML.INCLUDE_APARTMENTS.value()) {
            include.getIncludeApartments().add(Integer.parseInt(elementText));
            return;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        if (localName == XML.TOURIST_VOUCHER.value()) {
            // just add question to container
            vouchers.getVouchers().add(touristVoucher);
            return;
        }

        if (localName == XML.HOTEL_CHARACTERISTICS.value()) {
            // just add answer to container
            touristVoucher.setHotelCharacteristics(hotelCharacteristics);
            return;
        }

        if (localName == XML.COST.value()) {
            // just add answer to container
            touristVoucher.setCost(cost);
            return;
        }

        if (localName == XML.INCLUDE.value()) {
            // just add answer to container
            cost.setInclude(include);
            return;
        }
    }

    public static void main(String[] args) throws ParserConfigurationException,
            SAXException, IOException, TransformerException, JAXBException {

        // try to parse NOT valid XML (failed)
        ParserSAX parserSAX = new ParserSAX(INVALID_XML_FILE);
        try {
            parserSAX.parse(true); // <-- do parse with validation on (failed)
        } catch (Exception ex) {
            System.err.println("====================================");
            System.err.println("Validation is failed:\n" + ex.getMessage());
            System.err
                    .println("Try to print TouristVouchers object:" + parserSAX.getVouchers());
            System.err.println("====================================");
        }

        // try to parse valid XML file (success)
        parserSAX = new ParserSAX(VALID_XML_FILE);
        parserSAX.parse(true); // <-- do parse with validation on (success)
        TouristVouchers vouchers = parserSAX.getVouchers(); // <-- obtain container

        // we have Test object at this point:
        System.out.println("====================================");
        System.out.print("Here is the TouristVouchers: \n" + vouchers);
        System.out.println("====================================");



        // and now try to parse NOT valid XML with validation off (success)
        //parserSAX.parse(false); // <-- do parse with validation off (success)

        // we have Test object at this point:
        //System.out.println("====================================");
        //System.out.print("Here is the TouristVouchers: \n" + parserSAX.getVouchers());
        //System.out.println("====================================");

        SaverJAXB.saveXmlFile(vouchers, OUTPUT_XML_FILE, XSD_FILE);
    }
}
