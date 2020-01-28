package net.core.tutorial.elementary._05_Loops;

/**

 Switch.

 Это оператор многозначного выбора.

 Выполняется секция, для которой найдено совпадение, а также все секции, следующие за ней.
 Если требуется, чтобы была выполнена только одна секция, то в ней надо расположить break.

 После секций case (или между ними) можно расположить секцию default, которая выполняется,
 если ни одна из секций case не сработала (имеется в виду, что в секциях case стоят операторы break).
 Если операторов break не стоит, то выполнятся все секции case после первого совпадения и после
 секция default.

 В качестве типа для сравнения в операторе Switch могут использоваться int (а также byte, short, char),
 обёртки данных типов, String и Enum.

 */

public class _02_Switch {

    public static void main(String[] args) {

        String s = "Hi";

        switch (s){
            case "Hello":
                System.out.println("One");
            case "Hi":
                System.out.println("Two");
            case "Hey":
                System.out.println("Three");
        }

        System.out.println("------------------");

        switch (s){
            case "Hello":
                System.out.println("One");
            case "Hi":
                System.out.println("Two");
                break;
            case "Hey":
                System.out.println("Three");
        }

        System.out.println("------------------");

        switch ("Bye"){
            case "Hello":
                System.out.println("One");
                break;
            case "Hi":
                System.out.println("Two");
                break;
            case "Hey":
                System.out.println("Three");
                break;
            default:
                System.out.println("Default section");
        }
    }
}
