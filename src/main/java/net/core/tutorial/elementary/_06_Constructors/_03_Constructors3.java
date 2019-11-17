package net.core.tutorial.elementary._06_Constructors;

/**

 Конструкторы классов не наследуются. Поэтому их нельзя переопределять.
 Но можно перегружать (overload) (использовать конструкторы с разным количеством/типом аргументов).
 Если у класса наследника есть явный конструктор, а у предка нет, то при создании объекта наследника в первой строке
 конструктора будет вызван конструктор по умолчанию предка.
 В конструкторе в первой строке всегда стоит или super() (явно или неявно) или this(). this() можно использовать
 для вызова из одного конструктора другого конструктора этого же класса (с другим набором аргументов). Но это не могут
 быть циклические вызовы. Какой-то из конструкторов должен в конце концов всё равно вызвать в первой строке super().

 */

public class _03_Constructors3 {

    public static void main(String[] args) {

        Child7 child7 = new Child7();
        System.out.println("value from Child7 = " + child7.value + ", number from Child7 = " + child7.number
                + ", message from Child7 = " + child7.message);
        System.out.println("---------------------");

        child7 = new Child7("Hello!");
        System.out.println("value from Child7 = " + child7.value + ", number from Child7 = " + child7.number
                + ", message from Child7 = " + child7.message);
        System.out.println("---------------------");

        child7 = new Child7("Hello!", 500);
        System.out.println("value from Child7 = " + child7.value + ", number from Child7 = " + child7.number
                + ", message from Child7 = " + child7.message);
        System.out.println("---------------------");

        child7 = new Child7("Hello!", 500, -30);
        System.out.println("value from Child7 = " + child7.value + ", number from Child7 = " + child7.number
                + ", message from Child7 = " + child7.message);
    }
}

class Parent5 {

    int value;
    int DEFAULT_VALUE = 3003;


    public Parent5(int value) {
        this.value = value;
    }

    public Parent5() {
        value = DEFAULT_VALUE;
    }
}

class Child7 extends Parent5 {

    String message;
    int number;

    public Child7() {
        super();
    }

    public Child7(String message) {
        super();
        this.message = message;
    }

    public Child7(String message, int value) {
        super(value);
        this.message = message;
    }

    public Child7(String message, int value, int number) {
        this(message, value);
        this.number = number;
    }
}