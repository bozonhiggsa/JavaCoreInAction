package net.core.tutorial.medium._24_Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**

 Exceptions.

 Когда возникает исключительная ситуация, Java-машина создаёт специальный объект – exception, в который
 записывается информация об исключительной ситуации. Затем это «исключение» приводит к тому,
 что программа тут же выходит из текущего метода, затем выходит из следующего метода и так далее,
 пока не выйдет из метода main. Затем программа завершается.
 Еще говорят, что Java-машина «раскручивает назад стек вызовов».

 В Java все исключения делятся на два типа:
 - контролируемые/проверяемые (checked);
 - неконтролируемые/непроверяемые (unchecked).

 - checked (Throwable, Exception, IOException) обязательно надо обрабатывать в секции try-catch
 или пробрасывать в сигнатуре метода.

 - unchecked (RuntimeException, Error) можно создавать и пробрасывать дальше через
 throw new NameException(),
 можно но не обязательно указывать в сигнатуре метода (они пробрасываются автоматически).
 Эти исключения можно, но не обязательно, обрабатывать в секции try-catch.

 Error – предок исключений, которые возникают из-за ошибок самой JVM, с которыми бороться бессмысленно.

 RuntimeException – предок исключений, которые возникают преимущественно из-за алгоритмических ошибок.
 То, что наследники RuntimeException не обрабатываются, означает, что такие ситуации должны быть выявлены
 на этапе тестирования и отладки. Например, NullPointerException или ситуация с делением на ноль (ArithmeticException).

 Исключения могут быть синхронными (вылетают в ответ на конкретные операции).
 Например, инструкция new (создание объекта в Heap) при нехватке памяти выдаст исключение OutOfMemoryError.

 Исключения могут быть асинхронными. Например, это все наследники Internal Error. Такие исключения вылетают
 не в ответ на конкретные инструкции, а когда JVM обнаружила ошибку/повреждение внутренних данных/процессов.

 Если в каком-то классе переопределяется некоторый метод предка или интерфейса, то checked exception,
 который кидает этот метод не может быть более общим, чем тот exception, который указан для этого метода
 в предке/интерфейсе.
 Но наследник может кидать более узкое исключение или вообще не кидать никакого.
 А если исключение у предка не указано, то метод наследника не может кидать какое-либо checked exception.
 Но переопределяемые методы наследников могут кидать более широкие чем у методов предков unchecked исключения.

 Например, метод .run() в интерфейсе Runnable не кидает исключение. Поэтому при его переопределении в
 конкретном классе метод .run() также не должен кидать исключение. И если в нём приходится использовать
 метод .wait() (или .sleep(), .join()), то приходится его checked исключение InterruptedException обрабатывать
 здесь же в секции try-catch.

 Если возникает ситуация, когда в переопределяемом методе надо пробросить некоторое собственное исключение,
 которое не является наследником исключения, которое пробрасывается в одноимённом методе предка,
 то можно пробросить unchecked exception, например, RuntimeException, вложив в него объект собственного исключения.
 В частности, из метода .run() можно пробросить RuntimeException (например, для реализации особого завершения .run()).
 Но в данном конкретном случае делать это не рекомендуется, т.к. причину такого исключения после
 будет очень сложно определить.

 */

public class _01_Exceptions1 {

    public static void main(String[] args) {

        try{
            new Child1().otherMethod();
        }
        catch (RuntimeException e){
            System.out.println(e.getCause().getMessage());
        }
    }
}

abstract class Parent {

    public abstract void someMethod() throws Exception;

    public abstract void anotherMethod();

    public void otherMethod() throws FileNotFoundException {
        /*NOP*/
    }
}

class Child1 extends Parent {

    @Override
    public void someMethod() throws IOException {
        /*NOP*/
    }

    @Override
    public void anotherMethod() throws Error {

    }

    public void otherMethod() {

        try{
            // Some actions
            throw new RuntimeException();
        }
        catch (RuntimeException e){
            throw new RuntimeException(new SomeUserException("Some message"));
        }
    }
}

class Child2 extends Parent {

    @Override
    public void someMethod() {
        /*NOP*/
    }

    @Override
    public void anotherMethod() {
        throw new ArithmeticException();
    }
}

class Child3 extends Parent {

    @Override
    public void someMethod() throws Error {
        /*NOP*/
    }

    @Override
    public void anotherMethod() /*throws Exception*/ {
        /*NOP*/
    }
}

class SomeUserException extends Exception {

    public SomeUserException(String message) {
        super(message);
    }
}
