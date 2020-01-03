package net.core.tutorial.elementary._24_NestedClasses.additional;

public class ExampleInnerClass {

    public static void main(String[] args) {

        // Создадим объект внешнего класса
        Outer outer = new Outer(10);

        // Создание объекта inner класса
        // При создании объекта inner класса необходимо использовать ссылку на объект его внешнего класса (outer)
        Outer.Inner inner1 = outer.new Inner("Ten");
        inner1.getInnerFields();
        // Можно создавать много объектов одного inner класса относительно одного и того же объекта внешнего класса
        Outer.Inner inner2 = outer.new Inner("Twenty");
        inner2.getInnerFields();

        // Можно не сохранять ссылку на объект внешнего класса в отдельную переменную, если не требуется вызывать
        // из объекта внешнего класса его методы или переменные
        Outer.Inner inner3 = new Outer(30).new Inner("Thirty");
        inner3.getInnerFields();

        // Можно не сохранять ссылку и на объект inner класса, если требуется только один раз вызвать
        // из этого объекта метод или переменную
        new Outer(40).new Inner("Forty").getInnerFields();
    }
}