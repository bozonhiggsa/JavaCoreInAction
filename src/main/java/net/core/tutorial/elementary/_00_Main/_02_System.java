package net.core.tutorial.elementary._00_Main;

import java.io.*;
import java.util.Date;

/**

 Класс System.

 .in() - стандартный входной поток. Этот поток уже создан и готов к приёму данных.
 Обычно этот поток соответствует набору данных с консоли (клавиатуры).

 .out() - стандартный выходной поток. Этот поток уже создан и готов к выводу данных.
 Обычно этот поток соответствует выводу данных в консоль (монитор).

 .err() - стандартный выходной поток. Этот поток уже создан и готов к выводу данных.
 Этот поток принято использовать для вывода на монитор сообщений об ошибке.

 .currentTimeMillis() - возвращает текущее время в мс (с момента 01.01.1970).
 Класс Date получает в конструкторе без параметров вызов этого метода, после чего пересчитывает мс в дату.
 Но можно самим записать new Date(System.currentTimeMillis() - 3600 * 1000);
 если требуется вывести другое время (например, на 1 час меньше).

 .nanoTime() - возвращает время в нс, прошедшее с некоторого фиксированного момента времени.
 Удобно определять разницу во времени между двумя событиями.

 .arraycopy(array1, from index, array2, to index, number_elements) - копирование массивов.

 */
public class _02_System {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Час назад время было следующим:\r\n" +
                new Date(System.currentTimeMillis() - 3600 * 1000));

        PrintStream standardOut = System.out;

        OutputStream outputStream = new FileOutputStream("console_substitution.txt");
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        System.out.println("Время в нс, отсчитываемое от некоторого фиксированного момента,\r\n" +
                "который является точкой отсчёта для данной запущенной JVM:\r\n" +
                System.nanoTime());

        try {
            outputStream.flush();
            outputStream.close();
            printStream.flush();
            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.setOut(standardOut);

        System.out.println("----------------------");
        System.out.println("Время в нс, отсчитываемое от некоторого фиксированного момента,\r\n" +
                "который является точкой отсчёта для данной запущенной JVM:\r\n" +
                System.nanoTime());
    }
}
