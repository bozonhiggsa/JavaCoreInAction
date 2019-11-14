package net.core.tutorial.elementary._03_Recursion;

/**
 The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
 The next number is found by adding up the two numbers before it.
 f[0] = 0, f[1] = 1, f(k) = f(k-2) + f(k-1)

 Рекурсия.

 Рекурсия бывает прямая (метод А вызывает метод А) и косвенная (метод А вызывает метод Б,
 а метод Б вызывает метод А), с ветвлением и без ветвления. Если просто в методе вызывать этот же метод,
 т.е. организовать бесконечную рекурсию, то произойдёт переполнение стека вызовов StackTrace, т.к. в Java
 на один поток выделяется порядка 1 Мбайт памяти. Выбъет исключение – переполнение стека StackOverflowError.
 В конце тела каждого метода неявно стоит return, который передаёт управление в конец строки кода,
 которая вызвала данный метод. Если из метода А вызвать метод Б, то в методе Б никак нельзя завершить
 метод А. В методе Б можно экстренно завершить выполнение только метода Б (например, используя условие
 и return, аналогичная ситуация при выбивании исключения). Но затем управление передаётся в метод А,
 который будет отработан до окончания тела метода или до экстренного завершения данного метода. И так далее.
 Говорят, что в этом случае разворачивается стек вызовов и управление передаётся на более высокий уровень.

 Пусть вызывается метод А с входным аргументом x. В теле метода А после проверки определённого условия
 происходит вызов этого же метода А, но с аргументом 2*x. Надо понимать, что у каждого метода свой
 аргумент x и когда управление вернётся в данный метод, то можно будет дальше использовать именно
 свой аргумент x.
 Если в цикле while локальная переменная существует только на данной итерации до выхода из итерации,
 то при рекурсии локальная переменная x сохраняется после возвращения управления из другого метода в
 данный метод.
 В теории алгоритмов разделяют обход по дереву в ширину и обход по дереву в глубину. В Java с помощью
 рекурсии обход всегда в глубину. При вычислении ряда Фибоначчи мы реализуем обход по дереву в глубину,
 т.е. f(k) = f(k-2) + f(k-1). Так как в Java вычисления выполняются слева направо, то сначала
 вызывается f(k-2). При этом мы погружаемся вглубь метода f, т.к. для вычисления f(k-2) надо опять
 вычислить f(k) = f(k-2) + f(k-1). И так далее. Только когда мы дойдём до дна левой ветки, вызовется
 самый нижний правый элемент f(k-1). Он тоже возможно потребует углубления. И так далее.

 Кроме рекурсивного вызова методов может применяться рекурсивное объявление типа.
 Когда в некоем классе объявляется переменная с типом этого же класса.

 */
public class _01_FibonacciSequence {

    private static int COUNTER = 1;

    public static int fibonacci(int index) {

        if(COUNTER > 0) {
            getStackTraceElements();
            COUNTER--;
        }

        System.out.println("Current index = " + index);
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int depth = stackTraceElements.length - 7;
        if(index == 0){
            System.out.println("From depth " + depth + " return 0");
            return 0;
        }
        else if(index == 1){
            System.out.println("From depth " + depth + " return 1");
            return 1;
        }
        else{
            int temp = fibonacci(index - 1) + fibonacci(index - 2);
            System.out.println("From depth " + depth + " return " + temp);
            return temp;
        }
    }

    public static void getStackTraceElements() {

        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        System.out.println("StackTraceElements:");
        for (StackTraceElement el: stackTraceElements) {
            System.out.println(el.toString());
        }
        System.out.println("---------------------");
    }

    public static void main(String[] args) {

        int N = 5;
        System.out.println("Fibonacci Sequence for N numbers:");
        for(int i = 0; i < N; i++){
            System.out.println("----------------");
            fibonacci(i);
        }
    }
}