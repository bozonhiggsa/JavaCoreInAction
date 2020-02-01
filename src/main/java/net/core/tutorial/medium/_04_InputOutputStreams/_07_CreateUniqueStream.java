package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 *
 * Создание своего класса стрима с уникальным типом данных, встраивание его в общий поток при сохранении
 * в файл на диск, проверка функционирования.
 *
 */

public class _07_CreateUniqueStream {

    private static String FILE_NAME = "d:/tmp/entity.txt";

    public static void main(String[] args) throws IOException {

        OutputStream buf = new FileOutputStream(FILE_NAME);
        buf = new GZIPOutputStream(buf);
        EntityOutput out = new EntityOutputStream(buf);
        for (int index = 0; index < 10; index++) {
            out.writePerson(new Person("Mike " + index, index));
            out.writePoint(new Point(index + 1, index + 2));
        }
        buf.flush();
        buf.close();

        InputStream adapt = new FileInputStream(FILE_NAME);
        adapt = new GZIPInputStream(adapt);
        EntityInput in = new EntityInputStream(adapt);
        for (int index = 0; index < 10; index++) {
            Person person = in.readPerson();
            Point point = in.readPoint();
            if(!person.getName().equals("Mike " + index)){
                throw new AssertionError();
            }
            if(person.getAge() != index){
                throw new AssertionError();
            }
            if(point.getX() != index + 1){
                throw new AssertionError();
            }
            if(point.getY() != index + 2){
                throw new AssertionError();
            }
        }
        System.out.println("Person OK");
        System.out.println("Point OK");
        adapt.close();
    }
}

/**
 * Уникальный Entity класс типа данных
 */
class Point {

    private final int x;
    private final int y;

    public Point(int x, int y){
        if(x < 0 || x > 15) {
            throw new IllegalArgumentException();
        }
        if(y < 0 || y > 15) {
            throw new IllegalArgumentException();
        }
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "Point " + x + ", " + y;
    }
}

/**
 * Уникальный Entity класс типа данных
 */
class Person {

    private final String name;
    private final int age;

    public Person(String name, int age){

        if(age < 0 || age > 127) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "Person " + name + ", age is " + age;
    }
}

/**
 * Интерфейс потока чтения
 */
interface EntityInput {

    Person readPerson() throws IOException;
    Point readPoint() throws IOException;
}

/**
 * Интерфейс потока записи
 */
interface EntityOutput {

    void writePerson(Person person) throws IOException;
    void writePoint(Point point) throws IOException;
}

/**
 * Уникальный класс потока записи.
 * Делегирует основную работу объекту класса DataOutputStream, дополняя процесс записи своей логикой.
 */
class EntityOutputStream implements EntityOutput {

    private final DataOutput out;

    public EntityOutputStream(OutputStream out){
        this.out = new DataOutputStream(out);
    }

    @Override
    public void writePerson(Person person) throws IOException {
        out.writeInt(person.getAge());
        if(person.getName() == null){
            out.writeBoolean(false);
        }
        else {
            out.writeBoolean(true);
            out.writeUTF(person.getName());
        }
    }

    public void writePoint(Point point) throws IOException {
        int value = point.getX() << 4 | point.getY(); // тип int это 4 байта. X занимает младшие 4 бита int и
                                                      // Y занимает младшие 4 бита int
                                                      // сдвигаем X на 4 разряда вправо и побитовое ИЛИ с Y
                                                      // в итоге X и Y занимает только один младший байт одного int
        out.writeByte(value);
    }
}

/**
 * Уникальный класс потока чтения.
 * Делегирует основную работу объекту класса DataInputStream, дополняя процесс чтения своей логикой.
 */
class EntityInputStream implements EntityInput {

    private final DataInput in;

    public EntityInputStream(InputStream in){
        this.in = new DataInputStream(in);
    }

    @Override
    public Person readPerson() throws IOException {
        int age = in.readInt();
        Boolean condition = in.readBoolean();
        String s = in.readUTF();
        if(condition){
            return new Person(s, age);
        }
        else {
            return new Person("", age);
        }
    }

    public Point readPoint() throws IOException {
        Byte b = in.readByte();
        int y = (b & (byte)15);
        int x = (byte)15 & b >> 4;
        return new Point(x, y);

    }
}





