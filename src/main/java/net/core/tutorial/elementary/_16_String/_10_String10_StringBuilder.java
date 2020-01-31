package net.core.tutorial.elementary._16_String;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**

 StringBuilder (появился в JDK 1.5).

 Позволяет не создавать каждый раз новый объект при любом редактировании строки, а создать объект строки
 в виде массива чаров и редактировать далее один и тот же объект.
 Аналогичен классу StringBuffer (появился в JDK 1.0), однако в отличие от последнего не синхронизирован
 и поэтому не является потокобезопасным. Зато работает немного быстрее.

 Конструкторы:

 StringBuilder();
 резервирует место в Heap для 16 символов.

 StringBuilder(int capacity);
 резервирует место в Heap для указанного количества символов.

 StringBuilder(String str);
 получает начальное содержимое str плюс резервирует место в Heap для ещё 16 символов.

 StringBuilder(CharSequence seq);
 получает начальное содержимое seq плюс резервирует место в Heap для ещё 16 символов.

 Основные методы:

 .length();
 возвращает длину текущего содержимого.

 .capacity();
 возвращает ёмкость билдера в символах.
 .ensureCapacity(int minimumCapacity);
 расширяет ёмкость уже имеющегося билдера до указанного значения.

 .setLength(int newLength);
 устанавливает максимальную длину символьной строки в билдере. Если в билдере имеется строка большей длины,
 то последние символы отсекаются.

 .charAt(int index);

 .setCharAt(int index, char ch);

 .getChars(int indexOn, int indexEnd, char[] sink, int indexOnSink);

 .append();
 набор перегруженных методов, позволяющих присоединить к билдеру строковое представление любого типа данных.
 Строковое представление, как правило, получается при помощи .valueOf().
 Можно вызывать .append().append() цепочкой. Программа работает намного быстрее, если для конкатенации строк
 использовать StringBuilder и .append(), чем оператор +, особенно в цикле.

 При суммировании двух строк (s1 и s2) через оператор + в действительности создаётся StringBuilder,
 используется метод .append(), а затем результат преобразовывается в строку:
 s = s1 + s2  = = = =  s = new StringBuilder(s1).append(s2).toString();

 .insert();
 метод вставляет одну символьную строку в другую. Набор перегруженных методов, позволяет принимать все
 примитивные типы, а также String, CharSequence и Object.

 .reverse();
 изменение порядка следования символов в билдере.

 .delete(int start, int end);
 удаление символов от индекса start до end.

 .deleteCharAt(int index);
 удаление символа по индексу.

 .replace();
 заменяет один набор символов на другой.

 .substring();
 возвращает подстроку из билдера.

 */
public class _10_String10_StringBuilder {

    public static void main(String[] args) {

        String input = getInput("book.txt");
        System.out.println(input);
    }

    public static String getInput(String fileName) {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "utf8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(lineSeparator);
            }
            scanner.close();
            return sb.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString();
    }
}