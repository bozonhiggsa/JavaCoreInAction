package net.core.tutorial.elementary._15_Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**

 В случае, если надо сортировать объекты, которые явно нельзя упорядочить по возрастанию, то и алгоритм
 бинарного поиска и методы .sort() имеют две разные реализации – сортируемые объекты можно сделать такими,
 которые имплементируют интерфейс Comparable, или такими, которые имплементируют интерфейс Comparator.

 Интерфейс Comparable объявляет метод compareTo(Object o) с одним аргументом, т.е. объект из которого
 вызывается метод, сравнивается с объектом в аргументе метода.
 Поэтому объект, помещаемый в коллекцию  TreeSet или TreeMap, должен имплементить интерфейс Comparable
 и имплементировать данный метод.

 Интерфейс Comparator объявляет метод compare(Object o1, Object o2) с двумя аргументами. Поэтому объект,
 помещаемый в коллекцию TreeSet или TreeMap не обязан имплементить Comparable, но при создании коллекции
 ей в конструткоре необходимо дать объект интерфейса Comparator. Например, можно реализовать его на лету.

 */
public class _03_Arrays3 {

    public static void main(String[] args) {

        // Реализация компаратора на лету
        Set<Person> set = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person p0, Person p1) {
                return p0.getAge() - p1.getAge();
            }
        });

        Person[] persons = new Person[]{new Person(30, "Alex"), new Person(20, "Anna"), new Person(25, "Ivan")};

        System.out.println("Исходный массив: " + Arrays.toString(persons));
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p0, Person p1) {
                return p0.getAge() - p1.getAge();
            }
        });
        System.out.println("Отсортированный массив: " + Arrays.toString(persons));
        System.out.println("------------------------------ ");
    }
}

class Person {

    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
