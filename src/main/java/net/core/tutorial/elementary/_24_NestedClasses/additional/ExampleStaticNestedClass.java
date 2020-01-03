package net.core.tutorial.elementary._24_NestedClasses.additional;

public class ExampleStaticNestedClass {

    public static void main(String[] args) {

        // обращение к статической переменной static nested класса без создания объекта данного класса
        System.out.println(Outer2.Static_nested1.staticNumber1);
        // обращение к статической переменной static nested класса с созданием объекта static nested класса
        System.out.println(new Outer2.Static_nested1().staticNumber1);
        // аналогично
        Outer2.Static_nested1 static_nested1 = new Outer2.Static_nested1();
        System.out.println(static_nested1.staticNumber1);

        // косвенное обращение к статической переменной static nested класса
        System.out.println(new Outer2().y1);
        System.out.println(new Outer2().y2);

        // обращение к нестатической переменной static nested класса возможно
        // только после создания объекта данного класса
        System.out.println(new Outer2.Static_nested1().number1);

    }
}