package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**

 При считывании символьной информации, в том числе из консоли, удобно использовать
 класс BufferedReader, который является наследником абстрактного класса Reader.
 В конструкторе BufferedReader получает ссылку на любого наследника Reader и сохраняет
 её себе в приватное поле. И затем в некоторых методах делегирует свои задачи данному объекту
 (типичный случай использования паттерна Decorator).

 Создание BufferedReader для чтения символьной информации из файла:

 BufferedReader reader =
 new BufferedReader(new InputStreamReader(fileInputStream));

 Здесь InputStreamReader получает в конструкторе некоторый InputStream. Но также вторым
 аргументом в конструкторе ему можно передать кодировку, в которой представлена символьная
 информация, например, в файле:

 BufferedReader reader = new BufferedReader
 (new InputStreamReader(inputStream, Charset.forName("WINDOWS-1251")));

 Аналогичным образом можно передать кодировку в конструкторе класса OutputStreamWriter.

 Создание BufferedReader для чтения символьной информации из консоли:

 BufferedReader reader =
 new BufferedReader(new InputStreamReader(System.in));

 Здесь InputStreamReader это наследник Reader и получает в конструкторе InputStream, в виде
 экземпляра его подкласса System.in. Такой InputStream уже открыт и готов к приёму входных данных.
 Обычно это данные, вводимые с клавиатуры.

 Наследником класса InputStreamReader является класс FileReader. Использовать его не рекомендуется,
 т.к. в его конструкторе нельзя явно задать кодировку – используется дефолтная кодировка в системе.
 А так как на разных компьютерах могут стоять разные системы (и кодировки), то такой код
 потенциально имеет проблемы с интернационализацией.

 */

public class _04_Simple_IO_BufferedReader {

    private static String CHARSET = "UTF-8";

    public static void main(String[] args) {

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите 5 целых чисел, каждое с новой строки:");
        int [] arr = new int[5];

        try{
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(reader1.readLine());
            }
        }
        catch (NumberFormatException e){
            System.out.println("Возникло исключение при парсинге введёных символов в целое число");
        }
        catch (IOException e){
            System.out.println("Возникло исключение при считывании целых чисел");
        }

        System.out.println("Были введены числа:");
        System.out.println(Arrays.toString(arr));

        // Если количество вводимых с консоли строк заранее неизвестно, то можно
        // использовать такой код
        StringBuffer sbf = new StringBuffer();
        String nextString = "";
        BufferedReader reader2 = null;
        try {
            reader2 = new BufferedReader(new InputStreamReader(System.in, CHARSET));
        }
        catch (UnsupportedEncodingException e) {
            System.out.println("Задана кодировка символов, которая не поддерживается");
        }

        if(reader2 != null){
            System.out.println("Введите несколько строк, каждую с новой строки.");
            System.out.println("Для окончания ввода используйте Ctrl-D (для IntelliJ IDEA):");
            try {
                while((nextString = reader2.readLine()) != null){
                    sbf.append(nextString + "\r\n");
                }
            } catch (IOException e) {
                System.out.println("Возникло исключение при считывании строк");
            }
            System.out.println("Были введены строки:");
            System.out.println(sbf.toString());
        }
    }
}
