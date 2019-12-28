package net.core.tutorial.elementary._23_Generics;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**

 Generics.
 Позволяют реализовать полиморфизм по типу.

 Существуют дженерики у классов (кроме анонимных классов, Enum, классов исключений), интерфейсов (кроме аннотаций)
 и дженерики у методов (в том числе у конструкторов).

 Homogeneous container – принимает только объекты одного типа.
 Heterogeneous container – принимает объекты разных типов.

 Пусть имеется набор классов с одинаковой структурой, методами, но разными типами полей.
 В этом случае можно создать один класс с дженериком и конкретный тип данных указывать при создании объекта класса.
 Получается, что мы выделяем то абстрактное, что есть у класса независимо от конкретного типа данных
 и используем эту абстракцию вместе с дженериком.

 <T> type variable – переменная типа. Вместо T можно использовать любую комбинацию символов,
 которая годится для использования в качестве имени в Java.
 Для коллекций принято использовать <E> – элемент.

 Класс с дженериком можно унаследовать, но указав конкретный тип данных.
 В дженерике нельзя использовать примитивный тип данных, но можно использовать любой ссылочный тип,
 например, тип-обёртку Integer или int[].

 Пример:
 В Java есть интерфейс List<E>.
 Чтобы имплементировать данный интерфейс придётся реализовать метод .iterator(), который возвращает
 тип данных Iterator<E>.
 Iterator<E> это также интерфейс, для имплементации которого требуется реализовать метод .next(),
 который возвращает тип данных <E>. Следовательно Iterator<E> обходит что угодно, но ему надо
 указать конкретный тип данных.
 Поэтому при создании объекта ArrayList<String> a приходится указывать конкретный тип данных.
 Так же и при создании объекта итератора.
 Теперь, если получить доступ к конкретному элементу списка, то компилятор разрешит вызвать у него методы,
 соответствующие String. Это полиморфизм в чистом виде.

 */
public class _01_Generics1 {

    public static void main(String[] args) {

        // При создании конкретного объекта класса при помощи конструктора надо использовать
        // конкретный тип поля value, указав также корректный тип переменной
        SomeClass<String> someClass1 = new SomeClass<>("Hello", 123456789);
        SomeClass<int[]> someClass2 = new SomeClass<>(new int[]{1, 2, 3}, 123456789);
        System.out.println(someClass1);
        System.out.println(someClass2);

        System.out.println("----------------------");

        Child child = new Child(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 20202020);
        System.out.println(child);

        System.out.println("----------------------");

        List<String> strings = Arrays.asList("One", "Two", "Three", "Four");
        Set<String> set = new TreeSet<>(strings);
        AnotherClass<Set<String>, boolean[]> anotherClass = new AnotherClass<>(new First<>(set),
                new Second<>(new boolean[]{true, false, true}));
        System.out.println(anotherClass);

        System.out.println("Размер сета: " + anotherClass.getFirst().getA().size());
        System.out.println(Arrays.toString(anotherClass.getSecond().getB()));
        System.out.println("Размер массива: " + anotherClass.getSecond().getB().length);
    }
}

// Класс с недоопределённым типом
class SomeClass <T> {

    private T value;
    private long version;

    public SomeClass(T value, long version) {

        this.value = value;
        this.version = version;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "value=" + value +
                ", version=" + version +
                '}';
    }
}

class Child extends SomeClass<List<Integer>> {

    public Child(List<Integer> value, long version) {
        super(value, version);
    }
}

// Можно также применять абстракцию более высокого уровня
class AnotherClass <A, B> {

    private First<A> first;
    private Second<B> second;

    public AnotherClass(First<A> first, Second<B> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "AnotherClass{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public First<A> getFirst() {
        return first;
    }

    public Second<B> getSecond() {
        return second;
    }
}

class First <A> {

    private A a;

    public First(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "First{" +
                "a=" + a +
                '}';
    }

    public A getA() {
        return a;
    }
}

class Second <B> {

    private B b;

    public Second(B b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Second{" +
                "b=" + b +
                '}';
    }

    public B getB() {
        return b;
    }
}
