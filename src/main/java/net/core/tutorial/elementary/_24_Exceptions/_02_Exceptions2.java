package net.core.tutorial.elementary._24_Exceptions;

/**

 В каждом методе исключение можно перехватить, при необходимости обработать и продолжить выполнение программы.
 Исключения могут вкладываться в другие исключения. Например, в секции catch можно пробросить новое исключение,
 вложив в него текущее (в конструкторе):

 throw new SomeException(e);

 После этого можно будет обрабатывать новое исключение, но при этом сохраняется информация о типе
 вложенного исключения (конкретной причине поломки). Эту информацию можно извлечь из объекта нового исключения
 при помощи метода .getCause().
 Новый объект исключения можно создать на основе любого другого объекта исключения (наследника Throwable),
 вне зависимости от наследственных связей.

 */

public class _02_Exceptions2 {

    public static void main(String[] args) {

        try{
            new _02_Exceptions2().sourceOfException();
        }
        catch (ConcreteUserException e){
            Throwable cause = e.getCause();
            System.out.println("Причиной поломки было исключение: " + cause.toString());
            System.out.println(e.getMessage());
        }

    }

    public void sourceOfException() throws ConcreteUserException {

        int number = 0;

        try{
            int num = 100 / number;
        }
        catch (ArithmeticException e){
            throw new ConcreteUserException("Исключение было вызвано делением на число number", e);
        }
    }
}

class ConcreteUserException extends Exception {

    public ConcreteUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
