package net.core.tutorial.elementary._24_NestedClasses.additional;

public class Outer2 {

    // обращение к статической переменной static nested класса из внешнего класса возможно просто
    // по имени static nested класса
    int x = Static_nested1.staticNumber1;
    // или от имени одного из объектов static nested класса
    int y1 = new Static_nested1().staticNumber1;
    int y2 = new Static_nested1().staticNumber1;

    static int d = 8;

    static class Static_nested1 {
        int number1 = 10;
        static int staticNumber1 = 100;
        // обращение к нестатической переменной static nested класса из другого static nested класса
        int z = new Static_nested2().number2;
        // обращение к статической переменной static nested класса из другого static nested класса
        int g = Static_nested2.staticNumber2;
    }

    static class Static_nested2{
        static int staticNumber2 = 800;
        // из static nested класса видны статические переменные внешнего класса
        int number2  = d;
        // из static nested класса обратиться к нестатической переменной внешнего класса можно только создав его объект
        // закомментировано, т.к. в данном примере вызывает рекурсию и переполнение стека
        //int e = new Outer2().x;
    }
}
