package net.core.tutorial.elementary._01_Introduction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 В Java имеются специальные объекты типа Class, которые содержат описание классов в рантайм. Объект Class используется
 при создании всех «обыкновенных» объектов любой программы. Каждый класс, задействованный в программе, представлен
 своим объектом Class. Каждый раз при написании и последующей компиляции нового класса для него создается объект Class
 (который сохраняется в одноименном файле с расширением .class). Для создания объекта этого класса виртуальная машина
 JVM, исполняющая программу, использует подсистему, называемую загрузчиком классов. Все классы загружаются в JVM
 динамически, при первом их использовании. После того как объект Class определенного типа помещен в память PermGen,
 в дальнейшем он используется при создании всех объектов этого типа.
 Таким образом в Java, в отличие от С++, программа никогда не загружается полностью в память до начала своего
 выполнения. А объекты программы создаются в процессе выполнения программы. Компилятор в Java не выдаёт
 исполняемый код, он выдаёт некоторый промежуточный байт-код, который используется для создания потока программы
 в реальном времени.

 Class – это модель некоторой сущности, чертёж, по которому создаются экземпляры (объекты) данного класса.
 Этот чертёж можно получить при помощи методов:

 Class<?> clazz = object.getClass();
 Class<?> clazz = ClassName.class;

 и статического метода

 Class<T> Class.forName(String qualifiedClassName);

 В данном случае объект clazz будет содержать в себе полное название внешнего класса.
 clazz – это некоторый объект, который представляет в runtime данные (мета информацию) о классе объекта.
 Основные методы класса Class позволяют получить данные об элементах класса и являются основой для Reflection:

 String getCanonicalName();
 Field[] getFilds(String name);
 Class[] getInterfaces();
 Methods[] getMethods();
 Constructor[] getConstructors();

 Для создания объекта класса через рефлексию можно использовать код

 Object obj = Class.forName(className).newInstance();

 При этом будет использован дефолтный конструктор класса.

 */

public class _03_Class implements SomeInterface1, SomeInterface2 {

    private String someField1;
    private String someField2;
    public String someField3;
    public String someField4;
    public int number;

    public _03_Class() {
    }

    public _03_Class(String someField1, String someField2, String someField3, String someField4, int number) {
        this.someField1 = someField1;
        this.someField2 = someField2;
        this.someField3 = someField3;
        this.someField4 = someField4;
        this.number = number;
    }

    public String getSomeField1() {
        return someField1;
    }

    public void setSomeField1(String someField1) {
        this.someField1 = someField1;
    }

    private void someMethod1(){
        System.out.println("Hello!");
    }

    public void someMethod2(){

    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        _03_Class currentObject = new _03_Class();

        Class<?> clazz1 = currentObject.getClass();
        Class<?> clazz2 = _03_Class.class;
        Class<?> clazz3 = Class.forName("net.core.tutorial.elementary._01_Introduction._03_Class");

        System.out.println("Object clazz1 equal to object clazz2: " + clazz1.equals(clazz2));
        System.out.println("Object clazz2 equal to object clazz3: " + clazz2.equals(clazz3));
        System.out.println("Object clazz3 equal to object clazz1: " + clazz3.equals(clazz1));
        System.out.println("---------------------------------");
        System.out.println("CanonicalName is: " + clazz1.getCanonicalName());

        System.out.println("---------------------------------");

        System.out.println("List of public fields:");
        Field[] fields = clazz1.getFields();
        for (Field f: fields) {
            System.out.println(f.getName());
        }

        System.out.println("---------------------------------");

        System.out.println("List of interfaces:");
        Class<?>[] interfaces = clazz2.getInterfaces();
        for (Class<?> interf: interfaces) {
            System.out.println(interf.getName());
        }

        System.out.println("---------------------------------");

        System.out.println("List of public methods:");
        Method[] methods = clazz3.getMethods();
        for (Method meth: methods) {
            System.out.println(meth.getName());
        }

        System.out.println("---------------------------------");

        System.out.println("List of constructors:");
        Constructor<?>[] constructors = clazz3.getConstructors();
        for (Constructor constructor: constructors) {
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter par: parameters) {
                System.out.println("       parameter: " + par.getName());
                System.out.println("       type of parameter: " + par.getType());
            }
        }

        System.out.println("---------------------------------");

        Object obj = clazz1.newInstance();
        ((_03_Class)obj).someMethod1();
    }
}

interface SomeInterface1{
}

interface SomeInterface2{
}