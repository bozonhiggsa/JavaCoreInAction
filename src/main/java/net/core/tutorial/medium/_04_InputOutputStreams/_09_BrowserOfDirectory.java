package net.core.tutorial.medium._04_InputOutputStreams;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;

public class _09_BrowserOfDirectory {

    private static String FILE_NAME = "home/ihor/temp/";

    public static void main(String[] args) {

        File file = new File(FILE_NAME);
        browse1(file);
        System.out.println("--------------------");
        browse2(file);
        System.out.println("--------------------");
        try {
            browseAsVisitor(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Рекурсия по файлу/директории. Определяет файл это или директория и выдаёт список
     * всех файлов в директории.
     */
    public static void browse1(File root){

        if(root.isFile()){
            System.out.println("File: " + root);
        }
        else{
            System.out.println("dir: " + root);
            File[] files = root.listFiles();
            for (File file: files){
                browse1(file);
            }
        }
    }

    /**
     * Рекурсия по файлу/директории. Определяет файл это или директория и выдаёт список
     * всех файлов в директории. Используются предикаты файлов.
     */
    public static void browse2(File root){

        if(root.isFile()){
            System.out.println("File: " + root);
        }
        else{
            System.out.println("dir: " + root);
            File[] files = root.listFiles(new FileFilter() {
                @Override
                // использование предиката файла для ограничения поиска
                public boolean accept(File pathname) {
                    //return !pathname.toString().contains("$RECYCLE.BIN");
                    // выдавать в списке все файлы, которые в пути не содержат "$RECYCLE.BIN"
                    return !(pathname.toString().length() > 20);  // выдавать в списке все файлы, длина пути
                                                                    // которых <= 20
                }
            });
            for (File file: files){
                browse2(file);
            }
        }
    }

    /**
     * Поиск по директории в ширину (в отличие от рекурсии, которая всегда в глубину)
     * Определяет файл это или директория и выдаёт список всех файлов в директории (и директорий)
     * Использование java.nio
     */
    public static void browseAsVisitor(File root) throws IOException {

        Files.walkFileTree(root.toPath(), new MyVisitor());
    }

    public static class MyVisitor implements FileVisitor {

        @Override
        public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("dir: " + dir);
            return FileVisitResult.CONTINUE;  // стратегия посетителя перед посещением директории
        }

        @Override
        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            System.out.println("file: " + file);
            return FileVisitResult.CONTINUE; // стратегия посетителя перед посещением файла
        }

        @Override
        public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE; // стратегия посетителя при ошибке посещения файла
        }

        @Override
        public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE; // стратегия посетителя после посещения директории
        }
    }
}
