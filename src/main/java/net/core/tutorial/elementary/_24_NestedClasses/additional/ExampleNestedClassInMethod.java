package net.core.tutorial.elementary._24_NestedClasses.additional;

public class ExampleNestedClassInMethod {

    int number = 10;
    static int staticNumber = 100;

    public static void main(String[] args) {

        int localNumber = 1000;

        // Nested class, объявленный в статическом методе, автоматически становится static nested классом
        class Static_nested {
            // поскольку класс объявлен внутри метода, то в нём не может быть статических переменных и методов
            int number2 = 22;
            // из static nested класса видны статические переменные внешнего класса
            int a  = staticNumber;
            // из static nested класса можно обратиться к нестатической переменной внешнего класса создав его объект
            int c = new ExampleNestedClassInMethod().number;
            // из static nested класса видны локальные переменные содержащего его метода
            int b  = localNumber;
            // В Java8 локальная переменная метода, используемая в nested классе может не быть явно final,
            // но должна быть фактически финальной (её значение нельзя изменять)
            //localNumber = 2000;

            void getFields(){
                System.out.println(number2);
                System.out.println(staticNumber);
                System.out.println(localNumber);
                System.out.println(c);
            }
        }

        new Static_nested().getFields();
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%");
        new InnerClassInMethod().nonStaticMethod();
    }
}
