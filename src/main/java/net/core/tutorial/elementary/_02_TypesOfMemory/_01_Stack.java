package net.core.tutorial.elementary._02_TypesOfMemory;

import java.util.Arrays;

/**
 Stack.

 Когда вызывается метод, то в стеке под него выделяется область памяти "фрейм метода".
 Во фрейме хранятся локальные переменные метода (примитивные типы в виде конкретных значений, а
 ссылочные типы в виде ссылок на объекты в Heap). Но небольшой фрейм выделяется даже для пустого метода.
 Инструкции, размещённые в методе, хранятся не в стеке и не влияют на размер фрейма метода в стеке.
 Как только мы вышли из метода, выделенный для него фрейм удаляется. Вместе с локальными переменными метода.
 Для одного потока выделяется порядка 256кБайт-1МБайт стека. При переполнении стека вылетает исключение StackOverflowError.
 В настройках JVM можно увеличить объём стека, выделяемый при запуске JVM.

 Чтобы задать новое значение размера стека, равное 64 Мбайт, необходимо установить следующий флаг:

 -Xss64m – размер стека

 Аргументы метода можно также считать локальными переменными. И при вызове каждого метода выделяется фрейм для хранения
 этих переменных. При прямой рекурсии в каждом фрейме создаются копии локальных переменных, переданных в качестве аогументов.
 Эти локальные переменные если и содержат одинаковые значения, то всё равно в новой области памяти стека.
 Если же переменная ссылочного типа (объект класса, массив ...), то во фрейме метода хранится ссылка на область памяти в Heap,
 где хранится сам объект/массив. Ссылка занимает 4 байта памяти. При этом, если при рекурсии вложенный метод получает в качестве
 аргумента массив, то в его фрейме сохраняется та же ссылка, что и во внешнем методе. И если вложенный метод изменяет значение
 в массиве, то при передаче управления во внешний метод изменённое значение массива в Heap сохранится.

 */

public class _01_Stack {

    public void someMethod1(int number) {

        System.out.println("Number in an external argument = " + number);

        number+=10;

        System.out.println("Number in an external method1 = " + number);
        someMethod2(number);
    }

    public void someMethod2(int number) {

        System.out.println("Number in an external argument = " + number);

        number+=100;

        System.out.println("Number in an internal method2 = " + number);
    }

    public void someMethod3(int[] arr) {

        System.out.println("Array in an external argument = " + Arrays.toString(arr));

        arr[0] = 700;

        System.out.println("Array in external method3 = " + Arrays.toString(arr));
        someMethod4(arr);
    }

    public void someMethod4(int[] arr) {

        System.out.println("Array in external argument = " + Arrays.toString(arr));

        arr[0] = 900;

        System.out.println("Array in internal method4 = " + Arrays.toString(arr));
    }

    public void f(){
        f();
    }

    public static void main(String[] args) {

        int number = 10;
        int[] arr = new int[]{1, 2, 3, 4, 5};

        _01_Stack obj = new _01_Stack();

        obj.someMethod1(number);
        System.out.println("Number at the end = " + number);

        System.out.println("--------------------------");

        obj.someMethod3(arr);
        System.out.println("Array at the end = " + Arrays.toString(arr));

        System.out.println("--------------------------");

        while (true){
            obj.f();
        }
    }
}
