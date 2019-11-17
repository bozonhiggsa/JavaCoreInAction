package net.core.tutorial.elementary._00_Main;

/**

 Метод main() является точкой входа в проект на Java.
 Это должен быть именно public static void метод с аргументом в виде массива строк

 */
public class _01_Main {

    int main() {
        System.out.println("alpha");
        return 0;
    }

    public static void main(String args) {
        System.out.println("beta");
    }

    final public static void main(String[] s) {
        System.out.println("gamma");
    }
}
