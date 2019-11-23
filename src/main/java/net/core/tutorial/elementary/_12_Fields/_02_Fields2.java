package net.core.tutorial.elementary._12_Fields;

/**

 Статическое поле класса является общим для всех объектов этого класса, а также для всех объектов классов наследников.
 К этому полю (если позволяет уровень доступа) можно обратиться как по имени класса/объекта предка, так и по имени
 класса/объекта наследника. Но если в классе наследника объявить одноимённое поле, то тогда по имени класса/объекта
 наследника будем обращаться именно к нему.

 final static поля по Code Convention должны иметь идентификаторы из заглавных букв.

 */
public class _02_Fields2 {

    public static void main(String[] args) {

        System.out.println("Статическое поле было инициализировано до создания каких-либо объектов класса: " + Parent1.number);
        System.out.println("Доступ к статическому полю есть как по имени исходного класса, так и по имени любого класса" +
                " наследника: " + Child3.number);
        System.out.println("Доступ к статическому полю можно получить также из любого объекта исходного класса или" +
                " наследников: " + new Child1().number + ", " + new Child2().number);
        System.out.println("Статическое поле является общим и его можно изменять по имени исходного класса или" +
                " наследников \nили из объектов исходного класса или наследников: "
                + ++(new Child1().number) + ", " + ++(new Child2().number) + ", " + ++(Child3.number) + ", " + ++(Parent1.number));
    }
}

class Parent1 {

    static int number = 100;
    public static String STRING_CONSTANT = "Invariable";
}

class Child1 extends Parent1 {}

class Child2 extends Parent1 {}

class Child3 extends Child2 {}
