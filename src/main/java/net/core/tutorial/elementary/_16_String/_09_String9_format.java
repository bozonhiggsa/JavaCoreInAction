package net.core.tutorial.elementary._16_String;

import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

/**

 Форматированный вывод.

 В классе String имеется метод
 static String format(String format, Object… args)
 внутри которого создаётся объект класса Formatter и из этого объекта вызывается метод .format() класса Formatter.
 Возвращаемый результат метода (также типа Formatter) преобразовывается в String.
 Также можно самостоятельно вызвать из объекта класса Formatter метод .format().
 Класс Formatter обеспечивает возможность форматированного вывода.
 Если необходимо выполнить форматированный вывод в консоль, то аналогичную задачу выполняет метод
 System.out.printf(String format, Object… args).

 Форматирующая строка String format состоит из элементов двух типов:
 - к первому типу относятся символы, которые просто копируются в буфер вывода;
 - ко второму типу относятся спецификаторы формата, которые определяют способ,
 которым должны выводиться указываемые далее аргументы метода.

 Для форматирования отдельных символов используется спецификатор %c. В итоге символ будет выведен без изменения.
 Имеются два специальных спецификатора: %n – перевод каретки на новую строку, %% – выводит символ %.
 %t – используется для форматированного вывода времени и даты. Но использовать его надо с суффиксом,
 который задаст конкретный способ вывода времени и даты. Например, %tM – вывод времени в минутах (из двух символов).


 */
public class _09_String9_format {

    public static void main(String[] args) {

        System.out.println(String.format("%s%d%s", "Developer experience is ", 5, " years"));
        System.out.println(String.format("%s%f%s", "Constant value = ", 9.6, " inches"));
        System.out.println(String.format("%s%e", "Value = ", 1.5e7));
        System.out.println(String.format("%s%tc", "Current time is ", new Date()));
        System.out.println(String.format("%s%tD", "Current time is ", new Date()));
        System.out.println(String.format("%s%tF", "Current time is ", new Date()));
        System.out.println(String.format("%s%tF", "Current time is ", new GregorianCalendar().getTime()));
        System.out.println(String.format("Now is %tj day of year", new GregorianCalendar().getTime()));
        System.out.println(String.format("Now is %tj day %nof year", new Date()));

        System.out.println("---------------------");

        // Имеются и другие суффиксы, позволяющие определить формат вывода.
        // Здесь %-10s означает, что строковый аргумент должен занимать интервал из 10-ти символов
        // с выравниванием по левому краю. Второй строковый аргумент будет занимать интервал из 7-ми символов
        // %7s с выравниванием по правому краю.
        Formatter fm = new Formatter();
        System.out.println(fm.format("Hello, %-10s my name is %7s", "Olga", "Max"));

        // Можно указать другой порядок следования аргументов при помощи №$:
        System.out.println(String.format("Hello, %2$-10s my name is %1$7s", "Olga", "Max"));
    }
}
