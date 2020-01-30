package net.core.tutorial.elementary._25_Collections._04_Properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**

 Properties.

 Это фактически Map<String, String>. И с ней можно работать как с обычной map.
 Но кроме этого Properties имеет ряд полезных методов:

 .list(PrintStream) – вывод листинга (например в консоль System.out) содержимого коллекции
 в формате key=value;

 .store(new FileOutputStream(“props.properties”), null) – сохранение содержимого коллекции
 в файл .properties. Причём, поскольку файлы .properties имеют кодировку Latin1, то кирилические
 символы автоматически записываются в виде escape-последовательностей;

 .storeToXML(new FileOutputStream(“props.xml”), null) – сохранение содержимого коллекции в файл .xml.
 Причём, в кодировке UTF-8;

 .load(InputStream);

 .load(Reader);

 .loadFromXML(InputStream);

 */

public class PropertiesExample {

    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.put("key1", "value1");
        properties.put("key2", "value2");
        properties.put("key2", "value3");
        properties.put("key10", "value10");

        properties.list(System.out);

        properties.store(new FileOutputStream("props.properties"), "some comments");
        properties.storeToXML(new FileOutputStream("props.xml"), "some comments");

        System.out.println("---------------------------");

        properties.clear();
        properties.list(System.out);

        System.out.println("---------------------------");

        properties.loadFromXML(new FileInputStream("props.xml"));
        properties.list(System.out);
    }
}
