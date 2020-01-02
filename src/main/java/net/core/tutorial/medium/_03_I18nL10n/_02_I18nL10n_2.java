package net.core.tutorial.medium._03_I18nL10n;

import java.util.Locale;
import java.util.ResourceBundle;

/**

 Ресурсы сосредоточены в пакетах ресурсов (ResourceBundle). Может быть много пакетов ресурсов, каждый для своей локали.

 Существует механизм поиска ресурса, соответствующего необходимому языку (локали). Пакеты ресурсов должны иметь
 уникальные имена, которые указывают на конкретную локаль. Ресурсы в пакете можно найти по строковым ключам.
 Последовательность действий для нахождения ресурса, соответствующего локали, такова:
 1.	Найти пакет ресурсов, соответствующий данной локали;
 2.	Получить из него ресурс, соответствующий нужному ключу.

 Базовый класс для доступа к пакетам ресурсов – java.util.ResourceBundle. Этот класс позволяет получить
 список ключей, объект по ключу, строку по ключу, массив строк по ключу.

 Основу механизма поиска нужного пакета составляет набор перегруженных статических методов .getBundle().
 В аргументах метода можно задать только имя пакета, а можно задать также конкретную локаль и загрузчик классов.
 Если локаль явно не указывать, то будет выбрана дефолтная локаль. И тогда, при запуске приложения на некоторой
 платформе, будет выполнен поиск пакета ресурсов именно для той локали, которая является дефолтной для данной платформы.

 Название локали должно фигурировать в названии пакета ресурсов.
 Например: messages_ru_UA_Kharkov.properties.

 У класса java.util.ResourceBundle есть два наследника – java.util.ListResourceBundle и
 java.util.PropertyResourceBundle.

 Первый из них – абстрактный, второй нет. ListResourceBundle позволяет использовать ресурсы любого типа.
 Его абстрактный метод .getContents() возвращает двухмерный массив объектов. Ключи должны быть строками.
 Значения могут быть любыми. В этом заключается преимущество данного класса, но в этом же и его недостаток.
 При изменении ресурса придется, возможно, перекомпилировать класс, который реализует метод .getContents().

 Класс java.util.PropertyResourceBundle позволяет загружать ресурсы из файла свойств.
 В этом его преимущество – изменение ресурсов не потребует перекомпиляции. Но в этом же и недостаток – ресурсы могут
 быть только строковыми.

 Пусть базовое имя пакета ресурсов – baseName, и необходимо выполнить поиск конкретного пакета ресурсов для locale1,
 которая определяется параметрами language1, COUNTRY1 и variant1.
 И пусть дефолтная локаль имеет параметры language2, COUNTRY2 и variant2.

 Для создания объекта пакета ресурсов выполним код:

 ResourceBundle rb = ResourceBundle.getBundle("baseName", locale1);

 Происходит следующее:
 1.	Выполняется попытка в качестве пакета ресурсов загрузить объект пользовательского класса,
 наследника ResourceBundle. Если такой класс есть, то базовое имя пакета ресурсов должно соответствовать
 qualified class name такого класса. Например, com.myName.MyBundle. Может быть набор классов:
 com.myName.MyBundle
 com.myName.MyBundle_en
 com.myName.MyBundle_en_GB
 com.myName.MyBundle_ru

 2.	Если пользовательские классы, наследники ResourceBundle, недоступны, то выполняется поиск файла свойств.
 Файл свойств должен быть доступен для загрузчика классов, т.е. находиться в classpath. Например, файлы свойств
 можно расположить в папке src/. Это могут быть файлы:
 baseName_language1_COUNTRY1_variant1.properties
 baseName_language1_COUNTRY1.properties
 baseName_language1.properties
 baseName_language2_COUNTRY2_variant2.properties
 baseName_language2_COUNTRY2.properties
 baseName_language2.properties
 baseName.properties

 При поиске пакета ресурсов для locale1 перебор файлов свойств будет выполняться именно в такой
 последовательности – сначала ищем файлы для искомой локали, затем файлы для дефолтной локали, затем корневой файл.
 Поэтому, если выполняется поиск пакета ресурсов для locale1, а в наличии только файлы:
 baseName_ language2.properties
 baseName.properties
 то будет выбран файл baseName_language2.properties, соответствующий дефолтной локали.
 Если в данном случае необходимо использовать ресурсы из файла baseName.properties, то надо расположить
 в classpath пустой файл baseName_language1.properties.
 Если необходимый файл найден, то на его основе создаётся объект класса PropertyResourceBundle.

 3.	Если необходимые пакеты ресурсов отсутствуют, то бросается исключение MissingResourceException.

 4.	Когда пакет ресурсов загружен, для него создаётся родительская цепочка. Если мы ищем пакет ресурсов для locale1,
 которая определяется параметрами language1, COUNTRY1 и variant1, то будет найден пакет
 baseName_ language1_COUNTRY1_variant1.properties
 и его родителями будут считаться:
 baseName_ language1_COUNTRY1.properties
 baseName_ language1.properties
 baseName.properties

 Теперь, при попытке получить ресурс по некоторому ключу

 rb.getString("someKey")

 будет выполнен поиск ресурса в основном пакете. Если ресурс не найден, то будет выполнен поиск в пакете
 ближайшего предка. И т.д. до последнего предка. Если ресурс всё равно не найден, то будет выброшено исключение
 MissingResourceException.

 Загрузка ресурсов из файлов свойств производится с помощью класса java.util.Properties. По сути своей этот
 класс – хеш-таблица со строковыми ключами и строковыми значениями. И данный класс предполагает, что входной
 файл записан в кодировке iso-8859-1 (Latin 1). Поэтому для всех символов, не входящих в эту кодировку,
 необходимо использовать escape-последовательность.

 В состав JDK входит утилита native2ascii, которая предназначена для получения escape-последовательностей из
 символов национальных языков.
 Пример использования (прежде сменить директорию в командной строке на директорию проекта, где находятся
 входной и выходной файлы):

 native2ascii -encoding charset inputFile outputFile

 native2ascii -encoding utf-8 messages_pattern.properties messages_ru_RU.properties

 При этом символы из входного файла будут читаться в указанной кодировке. Если кодировку не указывать,
 то для чтения символов из исходного файла будет использована дефолтная кодировка операционной системы.

 */

public class _02_I18nL10n_2 {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();

        ResourceBundle rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));

        locale = new Locale("ru");
        rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));

        locale = new Locale("ru", "RU");
        rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));

        locale = new Locale("ru", "UA");
        rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));

        locale = new Locale("ru", "UA", "Kharkov");
        rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));

        locale = new Locale("ua", "UA");
        rb = ResourceBundle.getBundle("messages", locale);
        System.out.println(rb.getString("hanger"));
    }
}
