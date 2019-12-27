package net.core.tutorial.elementary._01_Introduction;

import java.util.Comparator;
import java.util.Objects;

/**

 Класс java.util.Objects.

 Класс содержит утилитарные методы для работы с объектами.

 .hashCode(Object a) – статический метод, возвращает 0 для null и int для NotNull argument.

 .hash(Object... values) – статический метод, возвращающий хеш код для последовательности объектов таким образом,
 как если бы они были переданы в метод в внутри массива.
 Делегирует работу методу Arrays.hashCode(Object[]).
 Если в метод передать 1 объект, то возвращаемый хэш код не будет равен стандартному хэш коду данного объекта.

 .equals(Object a, Object b) – статический метод, возвращающий булевое значение, сравнивая два объекта.
 Возвращает true, если это один и тот же объект или если это два null, а также если это разные
 объекты с одинаковым содержимым, для которых переопределён метод .equals().
 В частности, массивы не переопределяют метод .equals(), поэтому сравнивать их содержимое таким способом нельзя.

 .deepEquals(Object a, Object b) – статический метод, сравнение содержимого двух объектов.
 Использует метод Arrays.deepEquals0(a, b), который сам определяет тип аргумента (примитивные типы данных или Object)
 через instanceof и использует подходящий для данного типа данных метод из класса Arrays.
 Метод позволяет в том числе сравнивать по содержимому два массива.

 .toString(Object o) – статический метод, возвращающий String, полученный из String.valueOf(o).

 .toString(Object o, String nullDefault) – статический метод, если первый аргумент не null, то возвращает o.toString,
 иначе возвращает строку второго аргумента.

 .compare(T a, T b, Comparator<? super T> c) – статический метод, возвращает <T> int.
 Если a и b это один и тот же объект, то возвращает 0, иначе используется дженерифицированный любым
 предком T компаратор и используется метод c.compare(a, b), объявленный в интерфейсе Comparator.

 .requireNonNull(T obj) – статический метод, возвращает <T> T. Если obj равен null, то кидается
 исключение NullPointerException, иначе возвращается obj. Во второй реализации этого метода используется
 второй аргумент message, который добавляется при выкидывании исключения.

 */

public class _07_Objects {

    public static void main(String[] args) {

        System.out.println(Objects.hashCode(null));
        System.out.println(Objects.hashCode(new SomeClass(100, "Go for a walk")));

        System.out.println("-----------------");

        System.out.println(Objects.hash(new SomeClass(100, "Go for a walk"), new SomeClass(200, "Go to the park")));
        SomeClass someClass = new SomeClass(200, "Message");
        System.out.println(someClass.hashCode());
        System.out.println(Objects.hash(someClass));

        System.out.println("-----------------");

        System.out.println(Objects.equals(null, null));
        System.out.println(Objects.equals(someClass, someClass));
        System.out.println(Objects.equals(new SomeClass(300, "Hello!"), new SomeClass(300, "Hello!")));
        System.out.println(Objects.equals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));

        System.out.println("-----------------");

        System.out.println(Objects.deepEquals(null, null));
        System.out.println(Objects.deepEquals(someClass, someClass));
        System.out.println(Objects.deepEquals(new SomeClass(300, "Hello!"), new SomeClass(300, "Hello!")));
        System.out.println(Objects.deepEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3}));

        System.out.println("-----------------");

        System.out.println(Objects.toString(someClass));
        System.out.println(Objects.toString(null, "Argument is null"));

        System.out.println("-----------------");

        System.out.println(Objects.compare(new SomeClass(12, "Hello"), new SomeClass(9, "Hello"), new ComparatorForSomeClass()));
        System.out.println(Objects.compare(new SomeClass(2, "Hello"), new SomeClass(9, "Hello"), new ComparatorForSomeClass()));
        System.out.println(Objects.compare(new SomeClass(2, "Hello"), new SomeClass(2, "Bye!"), new ComparatorForSomeClass()));

        System.out.println("-----------------");

        System.out.println(Objects.requireNonNull(someClass));
        someClass = null;
        try{
            System.out.println(Objects.requireNonNull(someClass, "Argument is null"));
        }
        catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}

class SomeClass {

    private int value;
    private String message;

    public SomeClass(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SomeClass someClass = (SomeClass) o;

        if (value != someClass.value) return false;
        return message != null ? message.equals(someClass.message) : someClass.message == null;

    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "value=" + value +
                ", message='" + message + '\'' +
                '}';
    }
}

class ComparatorForSomeClass implements Comparator<SomeClass> {

    @Override
    public int compare(SomeClass o1, SomeClass o2) {
        if(o1.getValue() == o2.getValue()){
            return 0;
        }
        else if(o1.getValue() > o2.getValue()){
            return 1;
        }
        else return -1;
    }
}
