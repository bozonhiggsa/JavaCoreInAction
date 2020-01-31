package net.core.tutorial.medium._05_Serialization.example1.jaxb;

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
 *

JAXB.
(Java Architecture for XML Binding).

Технология, позволяющая связать Java классы со схемой XML в формате xsd,
генерировать XSD схемы и выполнять их валидацию.
XSD – это язык описания структуры XML документа. XSD схема описывает, какие в файле XML могут быть теги,
данные каких типов можно прописывать в этих тегах, какие могут быть внутренние теги, поля, атрибуты и т.д.
В том числе JAXB позволяет быстро и легко выполнять marshaling объектов Java в XML и обратную операцию.

JAXB настраивается с помощью аннотаций.

SOAP (Simple Object Access Protocol) – простой протокол доступа к объектам – протокол обмена
структурированными сообщениями в распределёной вычислительной среде. Первоначально предназначался для
удалённого вызова процедур (RPC – Remote Procedure Call). Сейчас используется для обмена произвольными
XML сообщениями между веб сервисами. И для преобразования объектов в XML и обратно как раз и используется JAXB.

SOAP может использоваться совместно с любым протоколом прикладного уровня,
однако чаще всего используется поверх HTTP.
Использование SOAP для передачи сообщений увеличивает их объём и снижает скорость обработки.
Альтернативой SOAP являются RESTfull web API. Но REST это не протокол, а архитектурный стиль.

REST (Representational State Transfer) – передача состояния представления – архитектурный стиль взаимодействия
компонентов распределённого приложения в сети.
В широком смысле компоненты в REST взаимодействуют как клиенты и серверы в сети.
В сети вызов удалённой процедуры может представлять собой обычный HTTP-запрос (обычно GET или POST),
а необходимые данные передаются в качестве параметров запроса.

В одном файле XML может содержаться описание многих классов, но только один класс может быть объявлен root.
В аннотации

XmlRootElement(name = "dataObj"),

которая вешается на класс, можно при помощи атрибута name изменить название соответствующего тега в файле XML,
которое по дефолту совпадает с названием класса.

 @XmlElement – аннотация может быть поставлена или на геттер или на сеттер (но не на оба одновременно)
 и указывает на поле, которое надо сериализовать в XML.

 @XmlElement(required=true, name = “s”) – имеется возможность потребовать, чтобы соответствующее поле
 обязательно было в наличии (при чтении его из файла XML), а также задать другое имя для тега данного поля в XML.

 @XmlAttribute – аннотация, которую можно поставить на поле, геттер или сеттер (но не одновременно),
 чтобы указать, что при сериализации данное поле надо сохранить в качестве атрибута в теге класса.

 @XmlAccessorType(XmlAccessType.NONE) – аннотация, которая указывает тип доступа:

 @XmlAccessorType(XmlAccessType.NONE) – сериализуются в XML только элементы, явно обозначенные одной из аннотаций;

 @XmlAccessorType(XmlAccessType.FIELD) – сериализуются в XML все нестатические и не транзиентные поля,
 а также поля с аннотацией @XmlAttribute (в том числе статические). При этом на геттерах/сетерах уже нельзя
 использовать аннотацию @XmlElement, т.к. это приведёт к дублированию полей;

 @XmlAccessorType(XmlAccessType.PROPERTY) – сериализуются в XML все поля, в том числе транзиентные и статические.
 При этом на геттерах/сетерах уже нельзя использовать аннотацию @XmlElement и на полях/геттерах/сеттерах
 нельзя использовать аннотацию @XmlAttribute, т.к. это приведёт к дублированию полей;

 @XmlAccessorType(XmlAccessType.PUBLIC_MEMBER) – сериализуются в XML все поля (в том числе транзиентные
 и статические), для которых есть публичные геттеры/сеттеры. При этом на геттерах/сетерах уже нельзя
 использовать аннотацию @XmlElement и на полях/геттерах/сеттерах нельзя использовать аннотацию @XmlAttribute,
 т.к. это приведёт к дублированию полей.

 @XmlTransient – аннотация, которую можно поставить на поле, чтобы явно указать, что его сериализовать не надо.

 Если аннотацию @XmlElement расположить над геттером/сеттером коллекции, то в файле XML каждый элемент
 этой коллекции будет размещён в отдельном теге внутри тега класса. Для того, чтобы элементы коллекции
 размещались внутри отдельного подтега коллекции – можно использовать аннотацию

 @XmlElement
 @XmlElementWrapper(name = "elements")
 public Set<String> getSet() {
 return set;
 }

 @XmlElement
 @XmlElementWrapper(name = "elements")
 public void setSet(Set<String> set) {
 this.set = set;
 }

 Простые типы JAXB преобразует в XML автоматически. Если поля класса имеют сложный тип
 (это же касается коллекции объектов некоторых классов), то соответсвующий класс должен быть аннотирован
 при помощи @XmlType. Данная аннотация указывает на тип (класс), который должен сериализоваться в XML.
 Такой класс обязательно должен иметь дефолтный конструктор без аргументов
 (можно наряду с другими конструкторами).
 Его нестатические поля автоматически сериализуются, если их не отметить аннотацией @XmlTransient.

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
