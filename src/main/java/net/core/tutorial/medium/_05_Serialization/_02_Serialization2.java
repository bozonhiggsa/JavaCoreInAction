package net.core.tutorial.medium._05_Serialization;

import java.io.*;

/**

 Для указания того, что объект можно сериализовать, его класс должен имплементировать маркерный
 интерфейс Serializable.
 Процесс сериализации заключается в создании потока, представляющего направление сериализации,
 в создании ObjectOutputStream для этого потока и в вызове из него метода .writeObject(object).

 Массив байт после сериализации содержит:
 - метаданные класса;
 - метаданные классов-предков (если предки сериализованы).
 Метаданные – это фактически только имя класса, возможно ещё иерархия и модификаторы полей;
 - данные полей классов-предков;
 - данные полей объекта;
 - serialVersionUID в формате long.

 При десериализации выделяется область памяти для десериализуемого объекта и именно в таком порядке
 инициализируются значения его полей – сначала значениями из классов-предков, затем значениями из
 текущего класса (так же как и при создании объекта с помощью конструктора).
 Но, конструктор для сериализованного класса не вызывается. Вместо конструктора используется Reflection API.
 Но если у сериализованного класса имеется несериализованный предок, то при инициализации полей
 десериализуемого объекта, доставшихся от предка, будет вызван вызван дефолтный конструктор предка
 без аргументов. Если при этом у предка нет дефолтного конструктора (public или protected),
 до десериализировать текущий объект не получится.

 Все поля класса сериализуемого объекта должны иметь типы (классы), которые также реализуют
 интерфейс Serializable (простые типы, String и массивы автоматически сериализуемы).
 Если данный класс наследует некоторые ссылочные поля от классов-предков, то эти поля
 (если они реализуют Serializable) также будут сериализованы.
 Если какие-то поля класса не являются Serializable, то они не будут сериализованы.
 Если у сериализуемого класса есть поле с типом класса, который не сериализован, и это поле не инициализировано,
 т.е. оно равно null, то текущий объект будет всё равно успешно сериализован. Но если в этом поле
 содержится ссылка на объект класса, который не сериализован, то при попытке сериализации
 объекта текущего класса получим NotSerializableException.

 Пусть у предка, который не имплементирует Serializable, имеется строковое поле и сеттер к нему.
 И при сериализации из объекта текущего класса вызывается этот (унаследованный) сеттер и полю присваивается
 некоторое значение. При десериализации данное ссылочное поле будет установлено в null.

 Не подлежат сериализации статические поля, а также поля с ключевым словом transient.
 При десериализации static и transient поля будут инициализированы значениями по умолчанию.
 Модификатором transient имеет смысл отмечать поля, которые содержат ссылки на потоки
 (например InputStream)  и Connection с БД.

 */

public class _02_Serialization2 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SomeClass someClass = new SomeClass("Olga", 30);
        someClass.setNameParent2("Ivan");
        System.out.println("Fields of class until serialization: " + someClass.getName() + ", "
                + someClass.getAge() + ", " + someClass.getNameParent1() + ", " + someClass.getNameParent2() + ", "
                + someClass.getThirdPartyClass() + ", " + someClass.getNumber1() + ", " + someClass.getNumber2());
        // Создание потока, связанного с корневой папкой проекта
        FileOutputStream fos = new FileOutputStream("tester.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(someClass);
        outputStream.close();

        FileInputStream fis = new FileInputStream("tester.bin");
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        SomeClass someClassNew = (SomeClass) inputStream.readObject();
        inputStream.close();

        System.out.println("--------------------");

        System.out.println("Fields of class after serialization: "
                + someClassNew.getName() + ", " + someClassNew.getAge() + ", "
                + someClassNew.getNameParent1() + ", " + someClassNew.getNameParent2() + ", " + someClassNew.getThirdPartyClass()
                + ", " + someClassNew.getNumber1() + ", " + someClassNew.getNumber2());

        System.out.println("--------------------");

        System.out.println(someClass == someClassNew);
    }

}

class SomeClass extends SomeParent implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    ThirdPartyClass thirdPartyClass;
    //ThirdPartyClass thirdPartyClass = new ThirdPartyClass();
    private static int number1 = 100;
    private transient int number2 = 300;

    public SomeClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ThirdPartyClass getThirdPartyClass() {
        return thirdPartyClass;
    }

    public static int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }
}

class SomeParent {

    private String nameParent1 = "parent_name";
    private String nameParent2;

    public String getNameParent1() {
        return nameParent1;
    }

    public String getNameParent2() {
        return nameParent2;
    }

    public void setNameParent2(String nameParent2) {
        this.nameParent2 = nameParent2;
    }
}

class ThirdPartyClass /*implements Serializable*/ {

    @Override
    public String toString() {
        return "ThirdPartyClass{}";
    }
}