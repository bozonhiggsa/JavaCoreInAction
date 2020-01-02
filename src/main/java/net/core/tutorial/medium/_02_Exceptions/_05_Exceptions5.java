package net.core.tutorial.medium._02_Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.rmi.AccessException;

/**

 Если метод должен возвращать результат, но в нём внутри есть создание исключения (не в секции try),
 которое пробрасывается дальше в сигнатуре метода, то он не может иметь return в конце.
 После кидания исключения до строки с return даже не дойдёт, поэтому её и не должно быть.

 Нельзя использовать return и в случае, когда исключение кидается в секции try, но нет секции catch (а есть finally),
 и идёт проброс сразу в сигнатуру метода.

 Из секций try, catch и finally можно выйти при помощи return без значения (если метод ничего не возвращает);

 Если метод возвращает значение и в секции try (или в секции catch) имеется return, а также в секции finally
 имеется return, то будет возвращено значение из секции finally.

 Если метод возвращает значение и в секции try или catch имеется return, возвращающий значение, а в секции
 finally переопределяется это значение, но нет return, то секция finally будет выполнена, но возвращено будет значение,
 которое было кэшировано (запомнено) при return из секции try или catch.

 Если метод возвращает значение и есть секции try-catch-finally, то хотя бы в одной из этих секций должен
 возвращаться return, который сработает по логике работы. Иначе будет ошибка компиляции.

 Секция finally выполняется даже в том случае, если в секции try вылетает исключение, которое не перехватывается
 в catch (например, Error). Или секция catch при этом вообще отсутствует.

 Если метод возвращает значение (в секции try через return возвращается некоторое значение), то сначала
 выполнится секция finally, а уже после значение будет возвращено в точку вызова метода.

 Если в секции try вылетает исключение на некоторой строке кода, после которой идут другие строки кода,
 то после обработки исключения в секции catch курсор не вернётся в секцию try – оставшиеся строки кода
 не будут выполнены.

 Не надо располагать логику после секции catch, если в секции try происходит инициализация/настройка объектов,
 с которыми она работает. Ведь в случае исключения в секции try объекты не будут настроены.
 Такой код, даже если он сам напрямую не может вызвать исключение, лучше располагать в секции try.

 Если в секции finally возникает исключение, то оно перезатирает те исключения, которые были брошены в
 секциях try или catch. И информация о последних теряется.

 */

public class _05_Exceptions5 {

    public static void main(String[] args) {

        try{
            SomeClass1.someMethod1();
        }
        catch (Exception e){
            System.out.println("Метод выбросил исключение: " + e.getMessage());
        }

        try{
            SomeClass1.someMethod2();
        }
        catch (Exception e){
            System.out.println("Метод выбросил исключение: " + e.getMessage());
        }

        System.out.println("-----------------------");

        SomeClass1.someMethod3();

        System.out.println("-----------------------");

        System.out.println(SomeClass1.someMethod4());

        System.out.println("-----------------------");

        System.out.println(SomeClass1.someMethod5());

        System.out.println("-----------------------");

        try {
            SomeClass1.someMethod6();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(String.format("Перехвачено исключение: %s", e.getMessage()));
        }
    }
}

class SomeClass1 {

    public static int someMethod1() throws Exception {

        throw new Exception("Исключение типа Exception");
    }

    public static String someMethod2() throws IOException {

        try{
            throw new IOException("Исключение типа IOException");
        }
        finally {
            System.out.println("Отработала секция finally");
        }
    }

    public static void someMethod3() {

        int number = (int) ((Math.random() - 0.5) * 100);

        try{
            if(number > 0){
                System.out.println("Выполнилось условие в секции try");
                System.out.println("Секция try отработала без исключения");
                return;
            }
            throw new FileNotFoundException("В секции try сгенерировано исключение FileNotFoundException");
        }
        catch (Exception e){
            System.out.println(String.format("Перехвачено исключение: %s", e.getMessage()));
            if(number < -25){
                System.out.println("Выполнилось условие в секции catch");
                return;
            }
            System.out.println("Секция catch отработала до конца");
        }
        finally {
            if(number > 0){
                System.out.println("Выполнилось условие в секции finally");
                return;
            }
            System.out.println("Секция finally отработала до конца");
        }
    }

    public static int someMethod4() {

        int number = (int) ((Math.random() - 0.5) * 100);

        try{
            if(number > 0){
                System.out.println("Условие в секции try выполнилось");
                return number;
            }
            throw new FileNotFoundException("Исключение FileNotFoundException");
        }
        catch (Exception e){
            if(number < -25){
                System.out.println("Условие в секции catch выполнилось");
                return number;
            }
            System.out.println("Секция catch отработала до конца");
        }
        finally {
            if(number > 0 || number < -25){
                return number*100;
            }
            System.out.println("Секция finally отработала до конца");
        }
        return 0;
    }

    public static int someMethod5() {

        int number = (int) ((Math.random() - 0.5) * 100);

        try{
            if(number > 0){
                System.out.println("Условие в секции try выполнилось");
                return number;
            }
            throw new IOException("Исключение IOException");
        }
        catch (Exception e){
            if(number < -25){
                System.out.println("Условие в секции catch выполнилось");
                return number;
            }
            System.out.println("Секция catch отработала до конца");
        }
        finally {
            if(number > 0 || number < -25){
                number = number*100;
            }
            System.out.println("Секция finally отработала до конца");
        }
        return 0;
    }

    public static void someMethod6() throws IOException {

        try{
            throw new FileNotFoundException("Исключение FileNotFoundException");
        }
        catch (IOException e){
            throw new AccessException("Исключение AccessException");
        }
        finally {
            throw new SocketException("Исключение SocketException");
        }
    }
}
