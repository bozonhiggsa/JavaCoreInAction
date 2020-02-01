package net.core.tutorial.medium._05_Serialization;

/**

 Сериализация.

 В различных языках программирования используется термин RPC
 (Remote Procedure Call – удалённый вызов процедур).
 Идея состоит в расширении механизма передачи управления и данных внутри программы, выполняющегося
 на одной машине, на передачу управления и данных через сеть. Средства удаленного вызова процедур предназначены
 для облегчения организации распределенных вычислений.

 В Java данный подход получил название RMI (Remote Method Invocation – удалённый вызов методов).
 RMI обеспечивает вызов методов из удалённых объектов, размещённых на других JVM, возможно на других хостах.

 RMI использует сериализацию (marshaling). Обычно под этим понимается запись объектов программы
 в поток данных для передачи в другое приложение, которое возможно находится даже на другом компьютере
 и возможно с другой архитектурой процессора. Unmarshaling обратный процесс, чтение с другой стороны.

 Сериализация – это технология преобразования запроса (например, аргументов метода, которые могут быть объектами)
 в массив байт для передачи по сети на другой компьютер с другой JVM (пересылка по сети между процессами).
 Объект на другой JVM вызовет свой аналогичный метод и вернёт результат в виде ещё одного объекта
 (а возможно сгенерирует объект-исключение). Этот результат также преобразовывается в массив байт,
 поступает на первый компьютер, преобразовывается в итоговый объект.

 Другими вариантами marshaling являются:
 - преобразование/запись объекта в бинарный файл;
 - преобразование/запись объекта в .xml файл;
 - запись объекта в JSON;
 - преобразование/запись объекта в формат BLOB базы данных.

 Marshaling это более общее понятие, чем сериализация.
 Сериализация в Java разработана без учёта возможной кросс-платформенности, когда на разных
 компьютерах используются разные языки программирования. Поэтому часто используются сторонние
 технологии, такие как Google Protobuf.

 При сериализации используется глубокое копирование (deep copy), когда в массив байт преобразовывается
 весь объект со всеми его полями (возможно разного типа), ссылками на другие объекты в полях и сами
 эти другие объекты (включая их поля и т.д). При десериализации восстанавливается полностью весь объект
 со всеми его значениями в полях, ссылками на другие объекты и самими другими объектами.

 Для успешной сериализации/десериализации на удалённых компьютерах должны быть одни и те же используемые
 классы (в classpass) и одни и те же версии этих классов.
 Поэтому в класс, объект которого будет сериализоваться, вводят поле

 private static final long serialVersionUID = 1L;

 Теперь на удалённой JVM перед десериализацией будет проверена версия имеющегося там соответствующего класса.
 Данное поле надо менять вручную после каждого внесённого изменения. Если это поле не использовать,
 то оно будет автоматически вычислено в формате long по файлу класса (по всем его определениям,
 названиям полей, методов и т.д.) и добавлено в класс на этапе компиляции. На удалённой JVM будет также
 автоматически вычислено данное поле по имеющемуся там файлу класса.
 serialVersionUID вычисляется на основании определения класса, а не по конкретному объекту.
 Самостоятельное явное определение значения поля serialVersionUID может оказаться полезным, если набор
 полей класса и их порядок уже определен, а методы класса могут меняться. Кроме того, начиная с Java 5
 крайне рекомендуется всем сериализуемым классам декларировать это поле в явном виде, ибо вычисление
 по умолчанию очень чувствительно к деталям структуры класса, которые могут различаться в зависимости
 от реализации компилятора, и вызывать таким образом неожиданные InvalidClassException при десериализации.

 При клонировании используется паттерн Prototype и поверхностное копирование (shallow copy). Имеется в виду,
 что клон содержит те же самые значения примитивных полей и те же самые "жёсткие" ссылки в ссылочных полях,
 что и исходный объект.
 И если после в исходном объекте изменить примитивные поля или immutable объекты, то в клоне останутся
 прежние значения. И если изменить содержимое объекта, на который указывает "жёсткая" ссылка, то такой объект
 изменится и для клона также.
 Согласно конвенции клонированный объект следует делать независимым от исходного объекта. Чтобы добиться этого,
 возможно целесообразно ссылочным полям клона присвоить другие ссылки, которые будут указывать на копии
 ссылочных объектов.

 */

public class _01_Serialization1 {

    public static void main(String[] args) throws CloneNotSupportedException {

        SomeClass1 someClass1 = new SomeClass1();
        SomeClass2 obj = new SomeClass2(100, "Bye!");
        someClass1.setObj(obj);
        System.out.println(someClass1);

        System.out.println("------------------");

        SomeClass1 someClass1Copy = someClass1.clone();
        System.out.println(someClass1Copy);

        System.out.println("------------------");

        someClass1.setNumber1(20);
        someClass1.setMessage1("Welcome!");
        obj.setNumber2(300);
        obj.setMessage2("Hey!");
        System.out.println(someClass1);
        System.out.println(someClass1Copy);
    }
}

class SomeClass1 implements Cloneable {

    int number1 = 10;
    String message1 = "Hello!";
    SomeClass2 obj;

    @Override
    public SomeClass1 clone() throws CloneNotSupportedException {
        return (SomeClass1) super.clone();
    }

    @Override
    public String toString() {
        return "SomeClass1{" +
                "number1=" + number1 +
                ", message1='" + message1 + '\'' +
                ", obj=" + obj +
                '}';
    }

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public void setObj(SomeClass2 obj) {
        this.obj = obj;
    }
}

class SomeClass2 {

    int number2;
    String message2;

    public SomeClass2(int number2, String message2) {
        this.number2 = number2;
        this.message2 = message2;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    @Override
    public String toString() {
        return "SomeClass2{" +
                "number2=" + number2 +
                ", message2='" + message2 + '\'' +
                '}';
    }
}