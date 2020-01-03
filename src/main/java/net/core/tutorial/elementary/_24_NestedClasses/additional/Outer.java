package net.core.tutorial.elementary._24_NestedClasses.additional;

public class Outer {

    public int number1;
    public static int number2 = 100;
    // чтобы из внешнего класса обратиться к переменной или методу его inner класса,
    // надо сначала создать объект inner класса
    public String referenceToInner = new Inner("One thousand").string1;

    public Outer(int number1) {
        this.number1 = number1;
    }

    public void getOuterFields(){
        System.out.println("It's outer class " + getClass().getName() + ", number1 is: " + number1);
        System.out.println("It's outer class " + getClass().getName() + ", referenceToInner is: " + referenceToInner);
    }

    // inner class
    class Inner {

        public String string1;

        public Inner(String string1) {
            this.string1 = string1;
        }
        // inner class не может содержать статические поля или методы
        // public static String string2 = "One hundred";

        public void getInnerFields(){
            // в inner классе доступны все поля и методы (и нестатические и статические) его внешнего класса
            getOuterFields();
            System.out.println("It's inner class " + getClass().getName() + ", number1 is: " + number1);
            System.out.println("It's inner class " + getClass().getName() + ", number2 is: " + number2);
            // доступ к внутренней переменной
            System.out.println("It's inner class " + getClass().getName() + ", string1 is: " + string1);
        }
    }
}
