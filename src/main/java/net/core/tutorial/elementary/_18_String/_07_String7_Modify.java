package net.core.tutorial.elementary._18_String;

/**

 Видоизменение строк.

 .substring(int beginIndex);
 .substring(int beginIndex, int endIndex);
 возвращает подстроку, извлечённую из строки начиная с символа с индексом beginIndex и заканчивая символом
 с индексом endIndex-1. Так как нумерация символов в строке начинается с нуля, то число символов в подстроке
 будет endIndex-beginIndex.

 До Java 6 включительно метод .substring() возвращал новый объект, в котором хранилась ссылка на исходный
 объект String, а также индексы для доступа к исходному объекту. При этом, если было необходимо из длинной
 строки извлечь маленькую подстроку, то в последней хранилась ссылка на исходный объект.
 И мусорщик не мог удалить длинную строку, даже если прямая ссылка на неё была утрачена. Начиная с Java 7
 метод .substring() просто вырезает из исходной строки подстроку и возвращает новый независимый объект.

 .concat(String s1);
 объединяет две строки, возвращает новый объект.

 .replace(char origin, char new);
 заменяет все символы origin на символы new. Или заменяет последовательность чаров CharSequence на другую
 последовательность чаров.

 .trim();
 возвращает строку, из которой удалены все начальные и конечные пробелы.

 .toLowerCase(String s1);

 .toUpperCase(String s1);

 static String join(CharSequence delimiter, CharSequence s1, CharSequence s2, ...);
 объединяет две и более строк (последовательностей символов, String реализует интерфейс CharSequence),
 разделяя их специально предопределённым разделителем delimiter.

 */

public class _07_String7_Modify {

    public static void main(String[] args) {

        System.out.println("Hello".substring(1, 4));
        // .subSequence() делегирует работу методу .substring()
        System.out.println("Hello".subSequence(1, 4));
        System.out.println("Hello".concat(", friends!"));

        String message1 = "     Everything is good, good.   ";
        System.out.println(message1.replace("good", "not bad"));

        System.out.println(message1.trim());
        System.out.println(message1.toLowerCase());
        System.out.println(message1.toUpperCase());

        System.out.println("------------------");

        System.out.println(String.join(";\n", "A", "third", "is", "not", "given"));
    }
}
