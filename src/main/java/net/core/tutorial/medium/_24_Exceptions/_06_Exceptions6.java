package net.core.tutorial.medium._24_Exceptions;

import java.io.*;
import java.nio.charset.Charset;

/**

 Начиная с Java 7 можно использовать секцию try с ресурсами – try-with-resources.

 Неправильное освобождение ресурсов – одна из наиболее часто допускаемых ошибок среди Java-программистов.

 */

public class _06_Exceptions6 {

    public static String FILE_NAME = "c:/temp/text.txt";


    public static void main(String[] args) throws IOException {

        // Пусть имеется OutputStream, который необходимо закрыть после окончания работы с ним.
        // Если при работе с OutputStream вылетит исключение, то метод .close() не будет вызван.
        // Проблемный код
        try {
            OutputStream outputStream = new FileOutputStream(FILE_NAME);
            outputStream.write("Произвольное сообщение.".getBytes(Charset.forName("cp1251")));

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Неправильное решение
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(FILE_NAME);
            outputStream.write("Произвольное сообщение.".getBytes(Charset.forName("cp1251")));
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e);
        }
        finally {
            if(outputStream != null){
                outputStream.close();
            }
        }
        // Здесь метод .close() будет вызван в любом случае, но может вылететь исключение при обработке
        // самого метода .close(). И если при этом секция try выкинет исключение, то оно перезатрётся
        // исключением из секции finally. В результате поток может остаться открытым и мы потеряем сообщение
        // об ошибке в секции try.


        // Приемлемое решение
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(FILE_NAME));
            outputStream.write("Произвольное сообщение.".getBytes(Charset.forName("cp1251")));
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e);
        }
        finally {
            try{
                if(outputStream != null){
                    outputStream.close();
                }
            }
            catch (IOException e){
                System.err.println("Ошибка закрытия потока: " + e);
            }
        }
        // В данном случае также есть вероятность, что выходной поток не будет закрыт. Допустим,
        // что OutputStream – это FileOutputStream, обёрнутый в BufferedOutputStream. Так как
        // BufferedOutputStream делает .flush() на низлежащий поток порциями, то есть вероятность, что он
        // его вызовет во время вызова .close() перед закрытием потока. Теперь представим, что файл,
        // в который мы пишем, заблокирован. Тогда метод .flush() выбросит IOException и
        // метод .close() не отработает. Но мы, во всяком случае, получим сообщение об ошибке.
        // Если вместо OutputStream используется InputStream, то такой код вполне годен. Дело в том,
        // что если в InputStream.close() выбрасывается исключение, то (скорее всего) никаких плохих
        // последствий не будет, так как мы уже считали из этого потока всё, что хотели.


        // Правильное решение
        try (OutputStream stream2 = new FileOutputStream(FILE_NAME)) {
                stream2.write("Произвольное сообщение.".getBytes(Charset.forName("cp1251")));
        }
        finally {
            System.out.println("Отработала секция явного finally");
        }
        // Оператор try-with-resources позволяет объявить и проинициализировать один или несколько ресурсов
        // (в круглых скобках после оператора try – как обычное Java выражение или несколько выражений через ;).
        // При этом переменная ресурса может быть использована в блоке try. По завершении этого блока переменная
        // автоматически удаляется, а ресурс автоматически закрывается. Компилятор сам неявно создаёт секцию finally,
        // в которой и происходит закрытие ресурсов без участия разработчика.
        // Конструкция try-with-resources является так называемым «синтаксическим сахаром» и создана для облегчения
        // жизни программиста. Под ресурсами подразумеваются сущности, реализующие интерфейс java.lang.AutoCloseable.
        // Интерфейс AutoCloseable ввели в Java 7 как раз для реализации try-with-resources. И поэтому его сделали
        // предком интерфейса Closeable, что в общем-то нелогично. Стоит заметить, что блоки catch и явный finally,
        // если они есть, выполняются уже после того, как закрываются ресурсы в неявном finally.
        // Если вылетает исключение и в секции try и при закрытии ресурса в секции неявного finally, то последнее
        // исключение подавляется.
        // Часто используют только секцию try (с ресурсами), а возможное исключение в этой секции пробрасывают
        // дальше в сигнатуре метода.


        System.out.println("---------------------");

        // Можно использовать секцию try с несколькими ресурсами
        try(FileInputStream input = new FileInputStream("text2.txt");
            BufferedInputStream bufferedInput = new BufferedInputStream(input))
        {
            int data = bufferedInput.read();
            while(data != -1){
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        }
        // Оба ресурса будут автоматически закрыты, как только код дойдёт до конца блока try.
        // Ресурсы будут закрыты в обратном порядке тому, в котором они создавались в круглых скобках.
    }
}
