package net.core.tutorial.proficient._03_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import net.core.tutorial.proficient._03_XML.entity.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class SaverDOMwithSchemaLocation {

    public static final String SCHEMA_LOCATION =
            "xsi:schemaLocation";
    public static final String SCHEMA_LOCATION_URI =
            "http://savchenko.ua input3.xsd";
    public static final String NAMESPACE_URI =
            "http://savchenko.ua";
    public static final String NAMESPACE_PREFIX = "";
    public static final String CLASS_DOCUMENT_BUILDER_FACTORY_INTERNAL =
            "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl";

    public static void saveXmlFile(TouristVouchers touristVouchers, final String xmlFileName)
            throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(
                CLASS_DOCUMENT_BUILDER_FACTORY_INTERNAL,
                ParserDOM.class.getClassLoader());

        // set properties for Factory
        dbf.setNamespaceAware(true); // <-- XML document has namespace

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.newDocument();

        // this is the root element
        Element rootElement = document.createElementNS(
                NAMESPACE_URI, NAMESPACE_PREFIX + XML.TOURIST_VOUCHERS.value());

        // set schema location
        rootElement.setAttributeNS(
                XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI,
                SCHEMA_LOCATION,
                SCHEMA_LOCATION_URI);

        document.appendChild(rootElement);

        for (TouristVoucher voucher : touristVouchers.getVouchers()) {
            Element vElement = document.createElement(XML.TOURIST_VOUCHER.value());
            rootElement.appendChild(vElement);

            Element typeElement =
                    document.createElement(XML.TYPE_VOUCHER.value());
            typeElement.setTextContent(voucher.getTypeVoucher());
            vElement.appendChild(typeElement);

            Element countryElement =
                    document.createElement(XML.COUNTRY.value());
            countryElement.setTextContent(voucher.getCountry());
            vElement.appendChild(countryElement);

            Element numberDaysNightsElement =
                    document.createElement(XML.NUMBER_DAYS_NIGHT.value());
            numberDaysNightsElement.setTextContent(String.valueOf(voucher.getNumberDaysNights()));
            vElement.appendChild(numberDaysNightsElement);

            List<String> transports = voucher.getTransports();
            if (!transports.isEmpty()) {
                for (String transport : transports) {
                    Element transportElement = document.createElement(XML.TRANSPORT.value());
                    transportElement.setTextContent(transport);
                    vElement.appendChild(transportElement);
                }
            }

            Element hotelCharacteristicsElement =
                    document.createElement(XML.HOTEL_CHARACTERISTICS.value());
            vElement.appendChild(hotelCharacteristicsElement);

            Element starsElement =
                    document.createElement(XML.STARS.value());
            starsElement.setTextContent(String.valueOf(voucher.getHotelCharacteristics().getStars()));
            hotelCharacteristicsElement.appendChild(starsElement);

            List<String> foods = voucher.getHotelCharacteristics().getFoods();
            if (!foods.isEmpty()) {
                for (String food : foods) {
                    Element foodElement = document.createElement(XML.FOOD.value());
                    foodElement.setTextContent(food);
                    hotelCharacteristicsElement.appendChild(foodElement);
                }
            }

            List<String> tvs = voucher.getHotelCharacteristics().getTvs();
            if (!tvs.isEmpty()) {
                for (String tv : tvs) {
                    Element tvElement = document.createElement(XML.TELEVISION.value());
                    tvElement.setTextContent(tv);
                    hotelCharacteristicsElement.appendChild(tvElement);
                }
            }

            List<String> conditioners = voucher.getHotelCharacteristics().getConditioners();
            if (!conditioners.isEmpty()) {
                for (String conditioner : conditioners) {
                    Element conditionerElement = document.createElement(XML.CONDITIONER.value());
                    conditionerElement.setTextContent(conditioner);
                    hotelCharacteristicsElement.appendChild(conditionerElement);
                }
            }

            List<Integer> apartments = voucher.getHotelCharacteristics().getApartments();
            for (int apartment : apartments) {
                Element apartmentElement = document.createElement(XML.APARTMENTS.value());
                apartmentElement.setTextContent(String.valueOf(apartment));
                hotelCharacteristicsElement.appendChild(apartmentElement);
            }

            Element costElement =
                    document.createElement(XML.COST.value());
            vElement.appendChild(costElement);

            Element moneyElement =
                    document.createElement(XML.MONEY.value());
            moneyElement.setTextContent(String.valueOf(voucher.getCost().getMoney()));
            costElement.appendChild(moneyElement);

            Element includeElement =
                    document.createElement(XML.INCLUDE.value());
            costElement.appendChild(includeElement);

            List<String> includeTransports = voucher.getCost().getInclude().getIncludeTransports();
            if (!includeTransports.isEmpty()) {
                for (String includeTransport : includeTransports) {
                    Element includeTransportElement = document.createElement(XML.INCLUDE_TRANSPORT.value());
                    includeTransportElement.setTextContent(includeTransport);
                    includeElement.appendChild(includeTransportElement);
                }
            }

            List<String> tvs2 = voucher.getCost().getInclude().getIncludeTvs();
            if (!tvs2.isEmpty()) {
                for (String tv : tvs2) {
                    Element tvElement = document.createElement(XML.INCLUDE_TELEVISION.value());
                    tvElement.setTextContent(tv);
                    includeElement.appendChild(tvElement);
                }
            }

            List<String> conditioners2 = voucher.getCost().getInclude().getIncludeConditioners();
            if (!conditioners2.isEmpty()) {
                for (String conditioner : conditioners2) {
                    Element conditionerElement = document.createElement(XML.INCLUDE_CONDITIONER.value());
                    conditionerElement.setTextContent(conditioner);
                    includeElement.appendChild(conditionerElement);
                }
            }

            List<Integer> apartments2 = voucher.getCost().getInclude().getIncludeApartments();
            for (int apartment : apartments2) {
                Element apartmentElement = document.createElement(XML.INCLUDE_APARTMENTS.value());
                apartmentElement.setTextContent(String.valueOf(apartment));
                includeElement.appendChild(apartmentElement);
            }

            List<String> foods2 = voucher.getCost().getInclude().getIncludeFoods();
            if (!foods2.isEmpty()) {
                for (String food : foods2) {
                    Element foodElement = document.createElement(XML.INCLUDE_FOOD.value());
                    foodElement.setTextContent(food);
                    includeElement.appendChild(foodElement);
                }
            }

            StreamResult result = new StreamResult(new File(xmlFileName));

            // set up transformation
            TransformerFactory tf = TransformerFactory.newInstance();
            javax.xml.transform.Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");

            // run transformation
            t.transform(new DOMSource(document), result);
        }
    }
}
