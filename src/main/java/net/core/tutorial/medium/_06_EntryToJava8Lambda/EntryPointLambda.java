package net.core.tutorial.medium._06_EntryToJava8Lambda;

/**
 * Entry point for a lambda expressions demonstrating
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPointLambda {

    public static void main(String[] args) {

        // for several arguments
        new ActivityTwoArgument() {
            @Override
            public void write(String message, int number) {
                number = number + 1;
                System.out.println(message + " : " + number);
            }
        }.write("Hello!", 22);

        // using lambda expression
        ((ActivityTwoArgument) (message, number) -> {
            number = number + 1;
            System.out.println(message + " : " + number);
        }).write("Hello!", 22);


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        // simplification for case with one argument
        ((ActivityOneArgument) message -> System.out.println(message)).write("Hello!");

        // using standard method as an implementation of the interface
        ((ActivityOneArgument) System.out::println).write("Hello!");


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        // the same as if a reference is saved
        ActivityOneArgument activity = new ActivityOneArgument() {
            @Override
            public void write(String message) {
                System.out.println(message);
            }
        };
        activity.write("Bye!");

        // using lambda expression
        ActivityOneArgument activity2 = message -> System.out.println(message);
        activity2.write("Bye!");

        // using standard method as an implementation of the interface
        ActivityOneArgument activity3 = System.out :: println;
        activity3.write("Bye!");


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        // using customer's method as an implementation of the interface
        ((ActivityOneArgument) EntryPointLambda::writeVariant).write("Hello!");
        ((ActivityOneArgument) new EntryPointLambda()::writeAnotherVariant).write("Hello!");


        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");


        // if method return a result
        System.out.println(new ActivityWithReturningResult() {
            @Override
            public String write(String message) {
                return message + "!!!";
            }
        }.write("Hi, there"));

        System.out.println(((ActivityWithReturningResult) message -> message + "!!!").write("Hi, there"));

    }

    static void writeVariant(String phrase){
        System.out.println("Variant: " + phrase);
    }

    void writeAnotherVariant(String phrase){
        System.out.println("And another variant: " + phrase);
    }

}
