package net.core.tutorial.elementary._18_CommandLine;

/**

 Переменные среды.

 Для запуска системных Java утилит (javac.exe, java.exe, jar.exe, javadoc.exe и др.) из командной строки необходимо
 прописать переменную среды, в которой указать путь к папке, в которой находятся утилиты.

 Компьютер-Свойства-Дополнительные_параметры_системы-
 Переменные среды.

 Здесь необходимо создать системную переменную JAVA_HOME, указав для неё путь к установленной JDK. Например:
 c:\Program Files\Java\jdk1.7.0_79
 Затем необходимо изменить системную переменную Path, дописав к имеющемуся пути через точку с запятой следующее:
 %JAVA_HOME%\bin
 Здесь bin - это каталог в директории c:\Program Files\Java\jdk1.7.0_79, в котором находятся утилиты.
 Или можно создать переменную среды прямо из командной строки командами:
 set JAVA_HOME= c:\Program Files\Java\jdk1.7.0_79
 set PATH=%PATH%;%JAVA_HOME%\bin

 Теперь, если в командной строке ввести path, то получим значение соответствующей системной переменной, включающее путь
 c:\Program Files\Java\jdk1.7.0_79\bin

 Аналогично необходимо прописать переменную среды M2_HOME и указать в ней путь к Maven (входит в состав IDE).
 Это необходимо для запуска Maven из командной строки.

 */

public class _01_CommandLine1 {

}
