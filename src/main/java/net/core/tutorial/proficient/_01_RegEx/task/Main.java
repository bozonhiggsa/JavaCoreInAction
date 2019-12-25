package net.core.tutorial.proficient._01_RegEx.task;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**

 Простой пример использования потоков ввода/вывода, чтения/записи в файл, использования
 регулярных выражений.

 */

public class Main {

    static int num;
    public static String FILE_NAME = "f:/temp/text.txt";
    public static String ENCODING = "utf-8";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите колличество строк: ");
        num = input.nextInt();
        System.out.println("Введите строки текста:");
        String[] lines = new String[num];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < num; i++) {
            try {
                lines[i] = reader.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("Введённые строки:");
        for (String line: lines) {
            System.out.println(line);
        }

        try {
            OutputStream outputStream = new FileOutputStream(FILE_NAME);
            for (int i = 0; i < num; i++) {
                if(i != (num - 1)){
                    lines[i] = lines[i] + "\r\n";
                }
                outputStream.write(lines[i].getBytes());
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("f:/temp/text.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        new Main().show(fis);
    }

    public void show(FileInputStream fis){

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, Charset.forName(ENCODING)));
        String[] inputString = new String[num];
        for(int i = 0; i < num; i++) {
            try {
                inputString[i] = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Результат считывания из файла:");
        for (String s: inputString) {
            System.out.println(s);
        }

        String input = "";
        for(int i = 0; i < num; i++){
            inputString[i] = inputString[i].replaceAll("\\s", "");
            input += inputString[i];
        }

        System.out.println("Символы, встречающиеся более одного раза:");

        Set<String> uniqueChars = new HashSet<>();
        for(int i = 0; i < input.length()-1; i++){
            String regex = input.substring(i,i+1);
            // string.replaceFirst() даёт такой же результат, как и matcher.replaceFirst()
            input = input.replaceFirst(regex, " ");
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            int counter = 0;
            while (matcher.find()) {
                counter++;
            }
            if(counter > 0){
                uniqueChars.add(regex);
            }
        }

        for (String chars: uniqueChars) {
            System.out.print(chars + " ");
        }
    }
}
