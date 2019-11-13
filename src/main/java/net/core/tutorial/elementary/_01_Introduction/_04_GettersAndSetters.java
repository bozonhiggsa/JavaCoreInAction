package net.core.tutorial.elementary._01_Introduction;

/**
 Геттеры и сеттеры

 Пусть name – это переменная класса. У нее модификатор доступа public, поэтому она видна везде в проекте.

 public String name;

 Метод getName – getter, возвращает значение переменной класса name. Имя метода строится по принципу
 get + «имя переменной с большой буквы».

 public String getName() {
 return name;
 }

 Для переменных типа Boolean геттер строится по принципу is + «имя переменной с большой буквы».

 public boolean isName() {
 return name;
 }

 Метод setName – setter, используется для присваивания нового значения переменной класса name.
 Имя метода строится по принципу set + «имя переменной с большой буквы». В этом методе имя параметра совпадает
 с именем переменной класса, поэтому мы ставим this перед именем переменной.

 public void setName(String name) {
 this.name = name;
 }

 Обычно переменные, объявленные внутри классов, имеют модификатор private. Чтобы другие классы могли менять значения
 таких переменных, для каждой из них можно создать пару методов: get и set. Задача метода get вернуть текущее
 значение переменной тому, кто его вызвал. Задача метода set установить новое значение переменной.
 Если мы не хотим, чтобы кто-то менял значения переменных наших объектов, мы можем просто не писать метод set
 для него, или сделать его private. Также в этот метод можно добавить дополнительные проверки данных,
 т.е контролировать корректность изменения переменной.

 */

public class _04_GettersAndSetters {

    private int number = 10;
    private String name = "Oleg";
    private double num = 5.34;
    private boolean value = false;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public static void main(String[] args) {

        _04_GettersAndSetters obj = new _04_GettersAndSetters();

        System.out.println("number = " + obj.getNumber());
        System.out.println("name is: " + obj.getName());
        System.out.println("num = " + obj.getNum());
        System.out.println("value = " + obj.isValue());

        System.out.println("-----------------");

        obj.setName("Ihor");
        obj.setValue(true);

        System.out.println("-----------------");

        System.out.println("number = " + obj.getNumber());
        System.out.println("name is: " + obj.getName());
        System.out.println("num = " + obj.getNum());
        System.out.println("value = " + obj.isValue());
    }
}