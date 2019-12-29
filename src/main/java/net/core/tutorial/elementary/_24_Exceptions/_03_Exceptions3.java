package net.core.tutorial.elementary._24_Exceptions;

/**

 Если при разработке программы необходимо создать набор собственных исключений, то принято делать их
 наследниками Exception (если исключения должны быть checked) или RuntimeException (если unchecked).
 Нежелательно создавать исключения – наследники Error или Throwable.

 Если есть набор связанных исключений, то целесообразно не делать каждое из них наследником Exception,
 а сделать для них общего предка, который будет наследником Exception. В этом случае можно будет написать
 один catch (для предка) и перехватывать сразу все исключения, а при необходимости добавлять новые исключения.

 При создании собственного исключения желательно вставить в него

 private static final long serialVersionUID = someLong;

 В Java есть специальная коллекция – Stack. Это коллекция, у которой есть методы «добавить элемент» и
 «достать элемент» в режиме LIFO. Первым будет взят элемент, который добавлен последним.

 Java-машина записывает в Stack вызовы всех методов. Когда один метод вызывает другой, Java-машина помещает
 в этот стек новый элемент StackTraceElement. Когда метод завершается, этот элемент удаляется из стека.
 Таким образом, в этом стеке всегда хранится актуальная информация о текущем состоянии «стека вызовов методов».

 В секции catch удобно использовать методы:

 e.printStackTrace();

 e.getStackTrace();
 возвращает объект StackTraceElement, по которому можно пройтись итератором:
 for(StackTraceElement element: e.getStackTrace()){
 }

 Каждый StackTraceElement содержит информацию о методе, который был вызван. В частности можно получить имя
 этого метода с помощью функции .getMethodName().

 throw e;
 пробросить исключение дальше.

 */

public class _03_Exceptions3 {

    public static void main(String[] args) {

        try{
            method1();
        }
        catch (UserAggregateException e){
            //e.printStackTrace();
            System.out.println(e.getMessage());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for(StackTraceElement element: e.getStackTrace()){
                String methodName = element.getMethodName();
                int lineNumber = element.getLineNumber();
                System.out.println("Исключение возникло в методе: " + methodName + ", в строке " + lineNumber);
            }
        }
    }

    public static void method1() throws UserException1, UserException2, UserException3 {

        method2();
    }

    public static void method2() throws UserException1, UserException2, UserException3 {

        int variant = 0;

        switch (variant){
            case 0:
                method3();
                break;
            case 1:
                method4();
                break;
            case 2:
                method5();
                break;
        }
    }

    public static void method3() throws UserException1 {

        throw new UserException1("Исключение UserException1 возникло в методе .method3()");
    }

    public static void method4() throws UserException2 {

        throw new UserException2("Исключение UserException2 возникло в методе .method4()");
    }

    public static void method5() throws UserException3 {

        throw new UserException3("Исключение UserException3 возникло в методе .method5()");
    }
}

class UserAggregateException extends Exception {

    public UserAggregateException(String message) {
        super(message);
    }
}

class UserException1 extends UserAggregateException {

    private static final long serialVersionUID = 101000L;

    public UserException1(String message) {
        super(message);
    }
}

class UserException2 extends UserAggregateException {

    private static final long serialVersionUID = 110000L;

    public UserException2(String message) {
        super(message);
    }
}

class UserException3 extends UserAggregateException {

    private static final long serialVersionUID = 100000L;

    public UserException3(String message) {
        super(message);
    }
}