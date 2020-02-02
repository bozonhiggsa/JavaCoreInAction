package net.core.tutorial.proficient._03_XML;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

/**
 * Controller for STAX parser.
 */
public class ParserSTAX extends DefaultHandler {

    public static final String VALID_XML_FILE = "input.xml";
    public static final String OUTPUT_XML_FILE = "output.stax.xml";
    public static final String INVALID_XML_FILE = "file_invalid.xml";
    public static final String XSD_FILE = "input.xsd";

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


    public ParserSTAX(String xmlFileName) {
        this.xmlFileName = xmlFileName;
    }

    /**
     * Parses XML document with StAX API. There is no validation during the
     * parsing.
     */
    public void parse() throws XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newInstance();

        factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

        XMLEventReader reader = factory.createXMLEventReader(
                new StreamSource(xmlFileName));

        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();

            // skip any empty content
            if (event.isCharacters() && event.asCharacters().isWhiteSpace())
                continue;

            // handler for start tags
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                currentElement = startElement.getName().getLocalPart();

                // WARNING!!!
                // here and below we use '==' operation to compare two INTERNED STRINGS
                if (currentElement == XML.TOURIST_VOUCHERS.value()) {
                    vouchers = new TouristVouchers();
                    continue;
                }

                if (currentElement == XML.TOURIST_VOUCHER.value()) {
                    touristVoucher = new TouristVoucher();
                    continue;
                }

                if (currentElement == XML.HOTEL_CHARACTERISTICS.value()) {
                    hotelCharacteristics = new HotelCharacteristics();
                    continue;
                }

                if (currentElement == XML.COST.value()) {
                    cost = new Cost();
                    continue;
                }

                if (currentElement == XML.INCLUDE.value()) {
                    include = new Include();
                    continue;
                }
            }

            // handler for contents
            if (event.isCharacters()) {
                Characters characters = event.asCharacters();

                if (currentElement == XML.TYPE_VOUCHER.value()) {
                    touristVoucher.setTypeVoucher(characters.getData());
                    continue;
                }

                if (currentElement == XML.COUNTRY.value()) {
                    touristVoucher.setCountry(characters.getData());
                    continue;
                }

                if (currentElement == XML.NUMBER_DAYS_NIGHT.value()) {
                    touristVoucher.setNumberDaysNights(Integer.parseInt(characters.getData()));
                    continue;
                }

                if (currentElement == XML.TRANSPORT.value()) {
                    touristVoucher.getTransports().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.STARS.value()) {
                    hotelCharacteristics.setStars(Integer.parseInt(characters.getData()));
                    continue;
                }

                if (currentElement == XML.FOOD.value()) {
                    hotelCharacteristics.getFoods().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.TELEVISION.value()) {
                    hotelCharacteristics.getTvs().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.CONDITIONER.value()) {
                    hotelCharacteristics.getConditioners().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.APARTMENTS.value()) {
                    hotelCharacteristics.getApartments().add(Integer.parseInt(characters.getData()));
                    continue;
                }

                if (currentElement == XML.MONEY.value()) {
                    cost.setMoney(Double.valueOf(characters.getData()));
                    continue;
                }

                if (currentElement == XML.INCLUDE_TRANSPORT.value()) {
                    include.getIncludeTransports().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.INCLUDE_TELEVISION.value()) {
                    include.getIncludeTvs().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.INCLUDE_CONDITIONER.value()) {
                    include.getIncludeConditioners().add(characters.getData());
                    continue;
                }

                if (currentElement == XML.INCLUDE_APARTMENTS.value()) {
                    include.getIncludeApartments().add(Integer.parseInt(characters.getData()));
                    continue;
                }

                if (currentElement == XML.INCLUDE_FOOD.value()) {
                    include.getIncludeFoods().add(characters.getData());
                    continue;
                }
            }

            // handler for end tags
            if (event.isEndElement()) {
                EndElement endElement = event.asEndElement();
                String localName = endElement.getName().getLocalPart();

                if (localName == XML.TOURIST_VOUCHER.value()) {
                    vouchers.getVouchers().add(touristVoucher);
                    continue;
                }

                if (localName == XML.HOTEL_CHARACTERISTICS.value()) {
                    touristVoucher.setHotelCharacteristics(hotelCharacteristics);
                    continue;
                }

                if (localName == XML.COST.value()) {
                    touristVoucher.setCost(cost);
                    continue;
                }

                if (localName == XML.INCLUDE.value()) {
                    cost.setInclude(include);
                }
            }
        }
        reader.close();
    }

    public static void main(String[] args) throws JAXBException, XMLStreamException, SAXException {

        ParserSTAX parserSTAX = new ParserSTAX(VALID_XML_FILE);
        parserSTAX.parse();
        TouristVouchers vouchers = parserSTAX.getVouchers(); // <-- obtain container

        // we have Test object at this point:
        System.out.println("====================================");
        System.out.print("Here is the TouristVouchers: \n" + vouchers);
        System.out.println("====================================");

        SaverJAXB.saveXmlFile(vouchers, OUTPUT_XML_FILE, XSD_FILE);
    }
}
