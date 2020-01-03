package net.core.tutorial.elementary._24_NestedClasses.additional;

public class InnerClassInMethod {

    int number = 1001;
    static int staticNumber = 30003;

    public void nonStaticMethod(){

        int localNumber = 2222;

        // Внутри нестатического метода можно объявить только inner class
        class InnerIntoMethod {
            // внутри inner класса не может быть статических переменных и методов
            int number2 = 111;
            // из inner класса видны статические переменные внешнего класса
            int a  = staticNumber;
            // из inner класса можно напрямую обратиться к нестатической переменной внешнего класса
            int c = number;
            // из inner класса видны локальные переменные содержащего его метода
            int b  = localNumber;
            // В Java8 локальная переменная метода, используемая в nested классе может не быть явно final,
            // но должна быть фактически финальной (её значение нельзя изменять)
            // localNumber = 2000;

            void getFields(){
                System.out.println(number2);
                System.out.println(staticNumber);
                System.out.println(localNumber);
                System.out.println(c);
            }
        }

        new InnerIntoMethod().getFields();
    }
}
