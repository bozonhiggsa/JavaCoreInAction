package net.core.tutorial.proficient._03_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ParserDOMwithSchemaLocation {

    public static final String VALID_XML_FILE = "input3.xml";
    public static final String INVALID_XML_FILE = "file_invalid.xml";
    public static final String OUTPUT_XML_FILE = "output3.dom.xml";
    public static final String CLASS_DOCUMENT_BUILDER_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";
    public static final String FEATURE__TURN_VALIDATION_ON =
            "http://xml.org/sax/features/validation";
    public static final String FEATURE__TURN_SCHEMA_VALIDATION_ON =
            "http://apache.org/xml/features/validation/schema";

    private TouristVouchers touristVouchers;

    public TouristVouchers getTouristVouchers() {
        return touristVouchers;
    }

    public static void main(String[] args) throws TransformerException, SAXException, IOException, ParserConfigurationException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(
                CLASS_DOCUMENT_BUILDER_FACTORY_INTERNAL,
                ParserDOM.class.getClassLoader());
        ParserDOM parserDOM = new ParserDOM();

        try {
            parserDOM.parse(dbf, true, VALID_XML_FILE);
        } catch (SAXException ex) {
            System.err.println("====================================");
            System.err.println("XML not valid");
            System.err.println("TouristVouchers object --> " + parserDOM.getTouristVouchers());
            System.err.println("====================================");
        }

        // try to parse NOT valid XML document with validation off (success)
        //parserDOM.parse(dbf, false, VALID_XML_FILE); // <-- parse with validation off (success)

        // we have Test object at this point:
        System.out.println("====================================");
        System.out.print("Here is the TouristVouchers: \n" + parserDOM.getTouristVouchers());
        System.out.println("====================================");

        SaverDOMwithSchemaLocation.saveXmlFile(parserDOM.getTouristVouchers(), OUTPUT_XML_FILE);
    }

    public void parse(DocumentBuilderFactory dbf, boolean validate, final String xmlFileName) throws ParserConfigurationException,
            SAXException, IOException {

        // set properties for Factory
        dbf.setNamespaceAware(true); // <-- XML document has namespace
        if (validate) { // <-- make parser validating
            dbf.setFeature(FEATURE__TURN_VALIDATION_ON, true);
            dbf.setFeature(FEATURE__TURN_SCHEMA_VALIDATION_ON, true);
        }

        DocumentBuilder db = dbf.newDocumentBuilder();

        db.setErrorHandler(new DefaultHandler() {
            public void error(SAXParseException e) throws SAXException {
                throw e; // <-- throw exception if XML document is NOT valid
            }
        });

        Document document = db.parse(xmlFileName); // <-- parse XML document
        Element root = document.getDocumentElement(); // <-- get root element

        // create container
        touristVouchers = new TouristVouchers();

        NodeList touristVoucherNodes = root
                .getElementsByTagName(XML.TOURIST_VOUCHER.value());

        for (int j = 0; j < touristVoucherNodes.getLength(); j++) {
            TouristVoucher touristVoucher = getTouristVoucher(touristVoucherNodes.item(j));
            touristVouchers.getVouchers().add(touristVoucher);
        }
    }

    private TouristVoucher getTouristVoucher(Node vNode) {
        TouristVoucher touristVoucher = new TouristVoucher();
        Element vElement = (Element) vNode;

        touristVoucher.setTypeVoucher((vElement.getElementsByTagName(XML.TYPE_VOUCHER.value())
                .item(0)).getTextContent());
        touristVoucher.setCountry((vElement.getElementsByTagName(XML.COUNTRY.value())
                .item(0)).getTextContent());
        touristVoucher.setNumberDaysNights(Integer.parseInt((vElement.getElementsByTagName(XML.NUMBER_DAYS_NIGHT.value())
                .item(0)).getTextContent()));

        NodeList transportNodeList = vElement.getElementsByTagName(XML.TRANSPORT.value());
        if(transportNodeList != null){
            for (int j = 0; j < transportNodeList.getLength(); j++) {
                //System.out.println((transportNodeList.item(j).getParentNode().toString()));
                String transport = transportNodeList.item(j).getTextContent();
                touristVoucher.getTransports().add(transport);
            }
        }
        Node hotelCharacteristicsNode = vElement.getElementsByTagName(XML.HOTEL_CHARACTERISTICS.value()).item(0);
        touristVoucher.setHotelCharacteristics(getHotelCharacteristics(hotelCharacteristicsNode));
        Node costNode = vElement.getElementsByTagName(XML.COST.value()).item(0);
        touristVoucher.setCost(getCost(costNode));

        return touristVoucher;
    }

    private HotelCharacteristics getHotelCharacteristics(Node hotelCharacteristicsNode) {
        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
        Element hElement = (Element) hotelCharacteristicsNode;

        hotelCharacteristics.setStars(Integer.parseInt((hElement.getElementsByTagName(XML.STARS.value())
                .item(0)).getTextContent()));

        NodeList foodNodeList = hElement.getElementsByTagName(XML.FOOD.value());
        if(foodNodeList != null){
            for (int j = 0; j < foodNodeList.getLength(); j++) {
                String food = foodNodeList.item(j).getTextContent();
                hotelCharacteristics.getFoods().add(food);
            }
        }
        NodeList tvNodeList = hElement.getElementsByTagName(XML.TELEVISION.value());
        if(tvNodeList != null){
            for (int j = 0; j < tvNodeList.getLength(); j++) {
                String tv = tvNodeList.item(j).getTextContent();
                hotelCharacteristics.getTvs().add(tv);
            }
        }
        NodeList conditionerNodeList = hElement.getElementsByTagName(XML.CONDITIONER.value());
        if(conditionerNodeList != null){
            for (int j = 0; j < conditionerNodeList.getLength(); j++) {
                String conditioner = conditionerNodeList.item(j).getTextContent();
                hotelCharacteristics.getConditioners().add(conditioner);
            }
        }
        NodeList apartmentsNodeList = hElement.getElementsByTagName(XML.APARTMENTS.value());
        for (int j = 0; j < apartmentsNodeList.getLength(); j++) {
            int apartment = Integer.parseInt(apartmentsNodeList.item(j).getTextContent());
            hotelCharacteristics.getApartments().add(apartment);
        }

        return hotelCharacteristics;
    }

    private Cost getCost(Node costNode) {
        Cost cost = new Cost();
        Element cElement = (Element) costNode;

        cost.setMoney(Double.parseDouble((cElement.getElementsByTagName(XML.MONEY.value())
                .item(0)).getTextContent()));

        Node includeNode = cElement.getElementsByTagName(XML.INCLUDE.value()).item(0);
        cost.setInclude(getInclude(includeNode));

        return cost;
    }

    private Include getInclude(Node includeNode) {
        Include include = new Include();
        Element iElement = (Element) includeNode;

        NodeList includeTransportNodeList = iElement.getElementsByTagName(XML.INCLUDE_TRANSPORT.value());
        if(includeTransportNodeList != null){
            for (int j = 0; j < includeTransportNodeList.getLength(); j++) {
                String transport = includeTransportNodeList.item(j).getTextContent();
                include.getIncludeTransports().add(transport);
            }
        }

        NodeList includeTvNodeList = iElement.getElementsByTagName(XML.INCLUDE_TELEVISION.value());
        if(includeTvNodeList != null){
            for (int j = 0; j < includeTvNodeList.getLength(); j++) {
                String tv = includeTvNodeList.item(j).getTextContent();
                include.getIncludeTvs().add(tv);
            }
        }
        NodeList includeConditionerNodeList = iElement.getElementsByTagName(XML.INCLUDE_CONDITIONER.value());
        if(includeConditionerNodeList != null){
            for (int j = 0; j < includeConditionerNodeList.getLength(); j++) {
                String conditioner = includeConditionerNodeList.item(j).getTextContent();
                include.getIncludeConditioners().add(conditioner);
            }
        }
        NodeList includeApartmentsNodeList = iElement.getElementsByTagName(XML.INCLUDE_APARTMENTS.value());
        for (int j = 0; j < includeApartmentsNodeList.getLength(); j++) {
            int apartment = Integer.parseInt(includeApartmentsNodeList.item(j).getTextContent());
            include.getIncludeApartments().add(apartment);
        }

        NodeList includeFoodNodeList = iElement.getElementsByTagName(XML.INCLUDE_FOOD.value());
        if(includeFoodNodeList != null){
            for (int j = 0; j < includeFoodNodeList.getLength(); j++) {
                String food = includeFoodNodeList.item(j).getTextContent();
                include.getIncludeFoods().add(food);
            }
        }

        return include;
    }
}
