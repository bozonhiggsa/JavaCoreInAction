package net.core.tutorial.elementary._01_Introduction;

/**
 Методы java.lang.Object

 .getClass() – финальный нативный метод, возвращающий метаинформацию о классе в виде объекта класса Class.

 .hashCode() – нативный метод, возвращающий хеш код в виде int.

 .equals(Object) – метод, возвращающий булевое значение. true если текущий объект, у которого вызывается метод,
 и объект в аргументе это один и тот же объект. Т.е. ссылка на объект в памяти одна и та же.
 У String этот метод переопределён и сравниваются не ссылки, а содержимое строк.

 .toString() – метод, возвращающий String в виде .getClass().getName() + "@" + Integer.toHexString(hashCode()).
 Т.е. возвращается строковое имя класса + @ + преобразованный в 16-ричные символы хеш код.
 У String этот метод переопределён и возвращает саму строку. У многих классов этот метод переопределён,
 в том числе у Integer и других обёрток, у коллекций и т.д.
 Все объекты в Java могут быть преобразованы в строку.
 Если мы «складываем» строку и ещё что-то, то это что-то преобразовывается в строку посредством
 неявного вызова метода .toString().

 .notify() – финальный нативный метод. Смотри монитор.
 .notifyAll() – финальный нативный метод. Смотри монитор.
 .wait() – финальный нативный метод. Смотри монитор.

 .finalize().

 Любой класс в Java неявно является наследником класса Object и получает его методы по наследству.
 Т.е. можно из объекта любого класса вызвать public методы, доставшиеся по наследству от Object.
 Или, в пользовательском классе можно переопределить некоторые из методов, чтобы они реализовывали
 требуемую логику, отличающуюся от дефолтной.

 .clone() – нативный protected метод, возвращающий клон текущего объекта.
 Наследник не из пакета java.lang не может к нему напрямую обратиться.
 Поэтому надо переопределить его в классе наследника, но изменить модификатор на public. Например так:

 @Override
 public Object clone() throws CloneNotSupportedException {
 return super.clone();
 }
 Клонирование по умолчанию у объектов выключено, поэтому конкретный класс объекта должен также
 имплементить интерфейс Cloneable, иначе при клонировании вылетит исключение CloneNotSupportedException.

 */

public class _05_Object {

    public static void main(String[] args) throws CloneNotSupportedException {

        _05_Object obj1 = new _05_Object();
        _05_Object obj2 = new _05_Object();

        System.out.println(obj1.getClass().getName());
        System.out.println(obj1.hashCode());
        System.out.println(obj1.equals(obj1));
        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.toString());

        System.out.println("---------------------");

        AnotherClass obj3 = new AnotherClass();

        System.out.println(obj3.getClass().getName());
        System.out.println(obj3.hashCode());
        System.out.println(obj3.equals(obj3));
        System.out.println(obj3.equals(obj2));
        System.out.println(obj3.toString());

        System.out.println("---------------------");

        AnotherClass obj4 = (AnotherClass) obj3.clone();
        System.out.println(obj3.equals(obj4));

    }
}

class AnotherClass /*extends Object*/ implements Cloneable {

    @Override
    public String toString() {
        return "My name is: " + AnotherClass.class.getSimpleName();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}