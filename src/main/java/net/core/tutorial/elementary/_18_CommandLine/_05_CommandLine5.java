package net.core.tutorial.elementary._18_CommandLine;

/**
 * Прммер запуска из командной строки класса с методом main()
 * С подключением внешних библиотек
 *
 * Скопируем в отдельную директорию архивы .jar внешних библиотек и созданный пользовательский .jar,
 * например, application-1.0-SNAPSHOT.jar
 *
 * Перейдём в командной строке в данную директорию:
 *
 * C:\Users\Ihor>cd /d f:/jms/
 *
 * Добавим в classpath все внешние библиотеки, а также свой архив:
 *
 * f:\jms>set CP=.;amqp-client-5.8.0.jar;slf4j-api-1.7.29.jar;slf4j-simple-1.7.29.jar;application-1.0-SNAPSHOT.jar
 *
 * Запустим пользовательский класс на исполнение:
 *
 * f:\jms>java -cp %CP% net.jms.rabbitmq.application.Recv
 *
 */

public class _05_CommandLine5 {
}
