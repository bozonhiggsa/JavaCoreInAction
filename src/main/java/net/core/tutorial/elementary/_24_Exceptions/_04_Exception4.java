package net.core.tutorial.elementary._24_Exceptions;

import java.io.FileNotFoundException;

/**

 В блоке catch может быть несколько вариантов перехватываемых исключений:

 catch(Exception1 | Exception2 | Exception3) {
 }

  Можно использовать несколько последовательных секций catch, но необходимо сначала отлавливать
 более узкие исключения (исключения-наследники), а затем уже исключения-предки.
 Если в одной секции catch создаётся и пробрасывается новый объект исключения, то такое исключение
 не может быть перехвачено в другой последовательной секции catch.

 После секции catch может быть секция finally{}, которая выполняется в любом случае, независимо от того,
 выполнилась ли секция try или секция catch.

 Две последовательные секции catch не могут перехватывать одно и то же исключение. Секции try и catch могут быть
 пустыми. Секции catch может не быть (а соответственно может не быть и указания перехватываемого исключения),
 если есть секция finally.

 Не может быть двух секций try подряд.

 После секции try нельзя размещать выражение. Сразу за try должна располагаться секция catch и/или finally.
 Но если используется секция try-with-resources, а возможное исключение в этой секции пробрасывается дальше
 в сигнатуре метода, то секций catch и finally может не быть.

 Не может быть двух секций finally подряд.

 */

public class _04_Exception4 {

    public static void main(String[] args) {

        try{
            invokeOneOfMethod();
        }
        catch (SomeException2 | SomeException3 e){
            e.printStackTrace();
        }
        catch (SomeException1 e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Выполнение секции finally");
        }
    }

    public static void invokeOneOfMethod() throws Exception {

        int variant = 3;

        switch (variant){
            case 0:
                method1();
                break;
            case 1:
                method2();
                break;
            case 2:
                method3();
                break;
            case 3:
                method4();
                break;
        }

    }

    public static void method1() throws SomeException2 {

        throw new SomeException2();
    }

    public static void method2() throws SomeException1 {

        throw new SomeException1();
    }

    public static void method3() throws Exception {

        throw new Exception();
    }

    public static void method4() throws FileNotFoundException {

        throw new FileNotFoundException();
    }
}

class SomeException1 extends Exception {

}

class SomeException2 extends SomeException1 {

}

class SomeException3 extends FileNotFoundException {

}
