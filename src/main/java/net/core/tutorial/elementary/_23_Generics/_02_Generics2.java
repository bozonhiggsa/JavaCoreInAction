package net.core.tutorial.elementary._23_Generics;

import java.util.Arrays;
import java.util.List;

/**

 Можно использовать такой синтаксис

 <T extends Comparable<T>>

 В этом случае у объекта такого типа можно будет вызывать методы, которые общие для ссылочных типов,
 а также метод .compareTo(T  o).
 Можно создавать объекты такого класса с любым типом T, который имплементит интерфейс Comparable.

 Можно использовать такой синтаксис

 <T super Person<T>>

 Здесь T может быть любым предком Person.

 У дженериков есть свойство "type erasure".
 До Java 5 не было дженериков и ArrayList был списком объектов (использовался «сырой» тип List list = ArrayList()).
 Начиная с Java 6 компилятор проверяет, чтобы было соответствие типов, т.е. ArrayList<Integer> не одно и то же,
 что ArrayList<String>. Но после компиляции информация о типах стирается и это опять список объектов.
 Получаем один байт-код для всех вариантов (типов) одного дженерика.
 Только в Runtime будет проверяться конкретный тип элементов списка.
 По этой причине нельзя перегружать методы:

 f(ArrayList<String> s)
 f(ArrayList<Integer> d)

 Такой синтаксис также не разрешён:

 ArrayList<Object> list = new ArrayList<String>();

 Но разрешён такой синтаксис:

 ArrayList<? extends Object> list = new ArrayList<String>();

 Знак ? означает «любой».

 Можно использовать следующие wildcards:
 <? extends T>
 <? super T>
 <?>

 */

public class _02_Generics2 {

    public static void main(String[] args) {

        System.out.println(GenericExample.getFirst(Arrays.asList(33, 44, 55, 66)));
        System.out.println(GenericExample.getFirst(Arrays.asList("One", "Two", "Three")));

        System.out.println("-------------------");

        List<? extends Comparable<?>> list1 = Arrays.asList("One", "Two", "Three", "Four");
        List<? extends Comparable<?>> list2 = Arrays.asList(3.14, 2.72, 3.0e8, 9.8);

        System.out.println(list1);
        System.out.println(list2);

        System.out.println("--------------------");

        manyIdsInParams(new LongId<User>(1001), new LongId<Server>(2002), new LongId<Customer>(3003));
    }

    public static void manyIdsInParams(LongId<User> userId, LongId<Server> serverId, LongId<Customer> customerId) {

        System.out.println("User Id: " + userId.getLong() + ", Server Id: " + serverId.getLong()
                + ", Customer Id: " + customerId.getLong());
    }
}

// Можно использовать дженерики при объявлении методов класса
class GenericExample {

    public static <T> T getFirst(List<T> list){

        return list.get(0);
    }
}

// Иногда удобно использовать дженерики, чтобы сделать код более читабельным.
// Допустим есть несколько похожих сущностей – например несколько идентификаторов,
// которые используются в качестве аргументов некоторого метода:
//
// void manyIdsInParams(long userId, long serverId, long customerId)
//
// Чтобы сделать код более читабельным можно создать специальный класс для типизации идентификаторов
class LongId<T> {

    private long Id;

    public LongId(long Id){

        this.Id = Id;
    }

    public long getLong(){

        return Id;
    }
}

class User {
}

class Server {
}

class Customer {
}