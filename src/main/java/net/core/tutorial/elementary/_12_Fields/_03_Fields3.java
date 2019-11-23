package net.core.tutorial.elementary._12_Fields;

/**

 Поля класса (если они не финальные) можно не инициализировать явно. При этом они получают значения по умолчанию
 (числовые типы – 0, boolean – false, ссылочные типы – null). final поля класса необходимо инициализировать.

 Нестатические final поля класса можно инициализировать:
 1.	Сразу при объявлении;
 2.	При помощи конструктора;
 3.	При помощи блока non-static инициализатора.

 Статические final поля класса можно инициализировать:
 1.	Сразу при объявлении;
 2.	При помощи блока static инициализатора.

 non-static инициализатор и конструктор (может быть только нестатический) нельзя использовать для инициализации
 статического финального поля.
 Ведь может не быть ни одного объекта класса и тогда поле не будет инициализировано.

 В интерфейсах не может быть инициализаторов, а поскольку все поля неявно public final static, то они должны быть
 инициализированы сразу при объявлении.

 */

public class _03_Fields3 {

    public static void main(String[] args) {

        ClassWithNonStaticFields classWithNonStaticFields = new ClassWithNonStaticFields(222);
        System.out.println("inintialInt = " + classWithNonStaticFields.inintialInt);
        System.out.println("inintialLong = " + classWithNonStaticFields.inintialLong);
        System.out.println("inintialDouble = " + classWithNonStaticFields.inintialDouble);
        System.out.println("inintialBoolean = " + classWithNonStaticFields.inintialBoolean);
        System.out.println("inintialChar = " + classWithNonStaticFields.inintialChar);
        System.out.println("inintialString = " + classWithNonStaticFields.inintialString);
        System.out.println("finalInt1 = " + classWithNonStaticFields.finalInt1);
        System.out.println("finalInt2 = " + classWithNonStaticFields.finalInt2);
        System.out.println("finalInt3 = " + classWithNonStaticFields.finalInt3);
        System.out.println("--------------------------------");

        ClassWithStaticFields classWithStaticFields = new ClassWithStaticFields();
        System.out.println("finalInt1 = " + classWithNonStaticFields.finalInt1);
        System.out.println("finalInt3 = " + classWithNonStaticFields.finalInt3);
        System.out.println("--------------------------------");

        System.out.println("Класс получает статические поля от интерфейсов, которые имплементирует: " +
                Implementation.num);
    }

}

class ClassWithNonStaticFields {

    int inintialInt;
    long inintialLong;
    double inintialDouble;
    boolean inintialBoolean;
    char inintialChar;
    String inintialString;
    final int finalInt1 = 111;
    final int finalInt2;
    final int finalInt3;

    {
        finalInt3 = 333;
    }

    ClassWithNonStaticFields(int finalInt2) {
        this.finalInt2 = finalInt2;
    }
}

class ClassWithStaticFields {

    final static int finalInt1 = 111;
    final static int finalInt3;

    static {
        finalInt3 = 333;
    }
}

interface SomeInterface {

    public final static int num = 700;
}

class Implementation implements SomeInterface {}