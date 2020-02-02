package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

/**

 File.

 В пакете java.io находится класс File, который позволяет читать метаинформацию файла и его атрибуты.
 Класс File служит для хранения и обработки в качестве объектов каталогов и имен файлов. Этот класс
 не содержит методы для работы с содержимым файла, но позволяет манипулировать такими свойствами файла,
 как право доступа, дата и время создания, путь в иерархии каталогов, создание, удаление файла, изменение
 имени файла и каталога и т. д.

 При создании объекта класса File ему в конструкторе всегда передают абстрактный путь к элементу файловой системы.
 Абстрактный путь состоит из системно-зависимого префикса (необязательно) и последовательности имён.
 Последовательность имён состоит из совокупности имён каталогов, причём последним именем последовательности
 может быть имя файла, а может быть название каталога. Если префикс отсутствует, то последовательность имён
 отсчитывается от текущей директории.
 Текущая пользовательская директория назначается каждой программе при её выполнении и от неё отсчитываются
 относительные пути. Путь к текущей директории можно получить при помощи метода:

 System.getProperty("user.dir");

 Объект класса File создается одним из нижеприведенных способов:

 File obFile = new File(""); // допускается использовать пустой абстрактный путь
 // при этом будет использован путь к текущей директории

 File obFile = new File("\\com\\file.txt");

 File obDir = new File("c:/jdk/src/java/io");

 File obFile1 = new File(obDir, "File.java");

 File obFile2 = new File("c:\\com", "file.txt");

 File obFile3 = new File(new URI("Интернет-адрес"));

 Во втором случае создается объект, соответствующий файлу, в третьем – подкаталогу.
 Четвертый и пятый случаи идентичны – для создания объекта указывается каталог и имя файла.
 В шестом случае создается объект, соответствующий адресу в инете.

 Существует разница между разделителями, употребляющимися при записи пути к файлу:
 для системы Unix – «/»,
 для Windows – «\\» (экранированный символ «\»).
 Так же в Windows допускается использовать разделитель «/».
 Для случаев, когда неизвестно, в какой системе будет выполняться код, предусмотрены специальные
 static поля в классе File:

 public static final String separator;
 public static final char separatorChar;

 С помощью этих полей можно задать путь, универсальный в любой системе:

 File file = new File(File.separator + "com" + File.separator + "data.txt" );

 Также предусмотрен еще один тип разделителей – для разделения путей к файлам в последовательности путей:

 public static final String pathSeparator;
 public static final char pathSeparatorChar;

 К примеру, для ОС Unix значение pathSeparator принимает значение «:», а для Windows – «;».
 Это же значение можно получить при помощи
 System.getProperty("path.separator");

 Так же из класса System можно получить:
 System.getProperty("line.separator");  //  разделитель строк в системе
 System.getProperty("file.encoding"); //  дефолтная кодировка файлов

 Дефолтную кодировку в системе можно получить также при помощи
 Charset.defaultCharset().displayName();
 При запуске программы дефолтную кодировку устанавливает JVM в зависимости от ОС и её настроек.

 Метод .getPath() класса File возвращает строковое значение абстрактного пути к файлу
 (с разделителями, принятыми в данной ОС). С префиксом или без (в зависимости от того, с префиксом или без
 был задан абстрактный путь при создании объекта файла).
 Внутри реализации метода .toString() в классе File так же вызывается метод .getPath().

 Так же могут быть полезны методы
 file.getAbsolutePath();
 file.getCanonicalPath();

 Если при создании объекта файла был использован абстрактный путь без префикса "file.txt",
 то данные методы вернут путь к данному файлу, отсчитанный от текущей директории. Например:

 C:\Users\Ihor\IdeaProjects\p100\file.txt

 Если при создании объекта файла был использован абстрактный путь "/file.txt",
 то данные методы вернут путь к данному файлу, отсчитанный от системного диска. Например:

 C:\file.txt

 Если при создании объекта файла был использован абстрактный путь с полным префиксом "f:/temp/file.txt",
 то данные методы вернут этот же путь. Например:

 f:\temp\line.txt  // результат применения метода getAbsolutePath()
 F:\temp\line.txt // результат применения метода getCanonicalPath ()

 Метод .getCanonicalPath() приводит абсолютный путь к виду, принятому в данной системе.
 В частности, удаляет избыточные символы "." и ".." из последовательности имён каталогов,
 приводит название раздела диска к верхнему регистру.
 Например, если при создании объекта файла указать путь к текущей директории при помощи

 File file = new File("./file.txt");

 System.out.println(file.getAbsolutePath());
 System.out.println(file.getCanonicalPath());

 то результатом будет:

 C:\Users\Ihor\IdeaProjects\p100\.\file.txt  // применение метода getAbsolutePath()
 C:\Users\Ihor\IdeaProjects\p100\file.txt  // применение метода getCanonicalPath ()

 Если при создании объекта файла указать путь к внешней директории при помощи

 File file = new File("../file.txt");

 System.out.println(file.getAbsolutePath());
 System.out.println(file.getCanonicalPath());

 то результатом будет:
 C:\Users\Ihor\IdeaProjects\p100\..\file.txt  // применение метода getAbsolutePath()
 C:\Users\Ihor\IdeaProjects\file.txt  // применение метода getCanonicalPath ()

 При создании объекта класса File любым из конструкторов компилятор не выполняет проверку
 на существование физического файла с заданным путем. Но если попытаться создать входной поток на основе
 такого объекта, не связанного с физическим файлом, то получим FileNotFoundException.
 При создании выходного потока FileOutputStream происходит физическое создание файла, причём до того,
 как полностью выполнится конструктор данного потока.

 */

public class _08_File {

    //private static String FILE_NAME = "d:/tmp/someFile.txt";
    private static String FILE_NAME = "e:/tmp/";

    public static void main(String[] args) throws IOException {

        System.out.println("Путь к текущей директории: " + System.getProperty("user.dir"));
        System.out.println("разделитель, употребляющийся при записи пути к файлу, в текущей ОС: " + File.separator);
        System.out.println("разделитель путей файлов в последовательности, в текущей ОС: " + File.pathSeparator);
        System.out.println("разделитель путей файлов в последовательности, в текущей ОС: "
                + System.getProperty("path.separator"));
        System.out.println("разделитель строк в текущей ОС: "
                + System.getProperty("line.separator"));
        System.out.println("дефолтная кодировка файлов в текущей ОС: "
                + System.getProperty("file.encoding"));
        System.out.println("дефолтная кодировка файлов в текущей ОС: "
                + Charset.defaultCharset().displayName());
        System.out.println("------------------");

        File file = new File(FILE_NAME);  // создаёт объект file, но так как записывать в файл можно через
                                          // FileOutputStream, то файл на диске пока не создаётся,
                                          // он создастся при начале записи через FileOutputStream

        System.out.println("строковое значение абстрактного пути к файлу: " + file.getPath());
        System.out.println("абсолютный путь к файлу: " + file.getAbsolutePath());
        System.out.println("канонический путь к файлу: " + file.getCanonicalPath());
        System.out.println("------------------");

        System.out.println("файл создан? :" + file.createNewFile()); // Но есть метод для создания пустого файла на диске
                                                                     // выдаст исключение, если указан некорректный путь

        //file.delete();                                             // можно удалить файл, этого не может FileOutputStream

        System.out.println("существует ли файл? :" + file.exists());
        System.out.println("может ли файл быть выполнен? :" + file.canExecute());
        System.out.println("доступный ли файл для чтения? :" + file.canRead());
        System.out.println("доступный ли файл для записи? :" + file.canWrite());
        System.out.println("получить имя файла :" + file.getName());
        System.out.println("получить путь к файлу :" + file.getPath());
        System.out.println("дата последней модификации :" + new Date(file.lastModified()));
        System.out.println("это файл? :" + file.isFile());
        System.out.println("это директория? :" + file.isDirectory());
        System.out.println("если это директория, а не файл, то можно получить список файлов в ней:");
        System.out.println(Arrays.toString(file.listFiles()));
    }
}
