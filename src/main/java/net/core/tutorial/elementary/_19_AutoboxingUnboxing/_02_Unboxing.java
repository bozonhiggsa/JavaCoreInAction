package net.core.tutorial.elementary._19_AutoboxingUnboxing;

/**

 Unboxing (автораспаковка).
 Это преобразование класса-обёртки в соответствующий ему примитивный тип. Если при распаковке
 класс-обёртка был равен null, то произойдет исключение java.lang.NullPointerException.

 Unboxing происходит:
 - при присвоении экземпляра класса-обёртки переменной соответствующего примитивного типа;
 - в выражениях, в которых один или оба аргумента являются экземплярами классов-обёрток (кроме операции == и !=);
 - при передаче объекта класса-обёртки в метод, ожидающий соответствующий примитивный тип.

 Так как арифметические операторы и операторы сравнения (за исключением == и !=) применяются только
 к примитивным типам, то приходилось делать распаковку вручную, что заметно снижало читабельность выражений,
 делая их код громоздким.
 Благодаря Unboxing, мы смело можем писать выражения, не используя методы конвертации.
 Теперь за этим следит компилятор Java.

 Следует помнить, что autoboxing/unboxing не работает для массивов:

 public class Main {

 public static void main(String[] args) {
 Integer[] iObs = new Integer[] {5, 10, 50, 2, 7};
 method(iObs); //Ошибка компиляции
 }

 public static void method(int ... i) {
 System.out.println("int[]");
 }
 }

 */

public class _02_Unboxing {

    // При присвоении, до JDK 1.5 необходимо было явно вызывать распаковывающий метод
    int i = new Integer(100).intValue();
    double d = new Double(3.0).doubleValue();
    char c = new Character('s').charValue();
    boolean b = new Boolean(true).booleanValue();

    // При присвоении, начиная с JDK 1.5 Unboxing выполняется автоматически
    int i2 = new Integer(100);
    double d2 = new Double(3.0);
    char c2 = new Character('s');
    boolean b2 = new Boolean(true);

    public static void main(String[] args) {

        _02_Unboxing entryPoint = new _02_Unboxing();

        System.out.println(entryPoint.i);
        System.out.println(entryPoint.d);
        System.out.println(entryPoint.c);
        System.out.println(entryPoint.b);

        System.out.println(entryPoint.i2);
        System.out.println(entryPoint.d2);
        System.out.println(entryPoint.c2);
        System.out.println(entryPoint.b2);

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");

        // В выражениях, до JDK 1.5
        Integer iOb1 = new Integer(5);
        Integer iOb2 = new Integer(7);
        System.out.println(iOb1.intValue() > iOb2.intValue());
        System.out.println(iOb1.intValue() + iOb2.intValue());
        // В выражениях, начиная с JDK 1.5
        System.out.println(iOb1 > iOb2);
        System.out.println(iOb1 + iOb2);

        // При сравнении классов-обёрток оператором == или !=, происходит сравнение по ссылкам,
        // а не по значениям и может возникнуть путаница
        Integer iOb3 = 100; // неявно выполняется Autoboxing при помощи Integer.valueOf(100)
        Integer iOb4 = 100;
        System.out.println("При создании объектов iOb3 и iOb4 задействуется кэш и поэтому сравнение" +
                " по ссылкам даст: " + (iOb3 == iOb4));

        Integer iOb5 = new Integer(120); // явно создаются новые объекты
        Integer iOb6 = new Integer(120);
        System.out.println("При создании объектов iOb5 и iOb6 используется new и поэтому сравнение" +
                " по ссылкам даст: " + (iOb5 == iOb6));

        Integer iOb7 = 200; // Значение выходит за диапазон кэша -128-127, поэтому неявно выполняется
                            // Autoboxing путём создания новых объектов
        Integer iOb8 = 200;
        System.out.println("При создании объектов iOb7 и iOb8 не задействуется кэш (превышен его диапазон)" +
                " и поэтому сравнение по ссылкам даст: " + (iOb7 == iOb8));

        /*В первом случае фактически вызывается статический метод Integer.valueOf(int), который кэширует
        значения от -128 до 127 (верхнюю границу можно изменить, если в параметрах JVM передать,
        например – XX:AutoBoxCacheMax=200) и при повторном использовании достает их из pool
        (набор инициализированных и готовых к использованию объектов). Аналогично кэшируются числа
        всех целых типов, сключая char, а также boolean. Во втором случае происходит явное создание объектов,
        следовательно они имеют разные ссылки. В третьем случае внутри Integer.valueOf(int), так как число
        выходит за диапазон кэша, неявно происходит создание объектов при помощи new, а поэтому они также
        имеют разные ссылки.*/

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");

        int num1 = 200;
        Integer num2 = num1;  // выполняется Autoboxing при помощи Integer.valueOf(200), т.е. new Integer(200)
        Integer num3 = num1;  // выполняется Autoboxing при помощи Integer.valueOf(200), т.е. new Integer(200)
        System.out.println(num1 == num2);
        System.out.println(num1 == num3);
        System.out.println(num2 == num3);
        /*В первом и втором случае получаем true, т.к. константа базового типа равна (==) объекту,
        который создан с её использованием. В третьем случае получаем false, т.к. как неявно
        создаются два объекта, которые имеют разные ссылки. Если бы объекты создавались на основе
        числа из диапазона -128-127, то из кэша при помощи Integer.valueOf(int) была бы получена
        ссылка на один и тот же объект.*/

        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");

        // При передаче в метод
        Integer iOb  = 10; // Выполняется Autoboxing
        someMethod(iOb); // Выполняется Unboxing при передаче в метод с аргументом типа int
    }

    // Данный метод будет использован благодаря Unboxing, если нет перегруженного
    // метода с аргументом типа Integer
    public static void someMethod(int i) {
        System.out.println("int");
    }

    // Если имеется перегруженный метод с аргументом типа Integer,
    // то вызовется именно он
    public static void someMethod(Integer iOb) {
        System.out.println("Integer");
    }
}
