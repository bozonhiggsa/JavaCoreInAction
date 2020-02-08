package net.core.tutorial.elementary._18_CommandLine;

/**

 Пример создания и сборки проекта при помощи Maven из командной строки.

 1.	Перейти в папку, в которой будет создан проект.

 2.	Выполнить в командной строке

 mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

 3. Если это первый запуск Maven, то будет загружено множество файлов из сети в локальный репозиторий
 c:\Users\Ihor\.m2\repository\
 В том числе сюда будут загружены плагины Maven.

 4. Будет создана директория проекта с названием artifactId, т.е my-app
 5. В данной директории будет директория src с сорцами программы и тестов
 src\main\java\com\mycompany\app\App.java
 src\test\java\com\mycompany\app\AppTest.java

 6. Также в корне проекта будет создан файл pom.xml

 <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
 <modelVersion>4.0.0</modelVersion>
 <groupId>com.mycompany.app</groupId>
 <artifactId>my-app</artifactId>
 <packaging>jar</packaging>
 <version>1.0-SNAPSHOT</version>
 <name>my-app</name>
 <url>http://maven.apache.org</url>
 - <dependencies>
 - <dependency>
 <groupId>junit</groupId>
 <artifactId>junit</artifactId>
 <version>3.8.1</version>
 <scope>test</scope>
 </dependency>
 </dependencies>
 </project>

 7. Перейдём в директорию артефакта my-app, в которой находится файл pom.xml и выполним сборку проекта

 mvn package

 8.	После сборки в директории артефакта появится папка target, в которой находятся откомпилированные классы
 программы и тестов, результаты тестов и архив my-app-1.0-SNAPSHOT.jar.

 mvn clean – обратная команда – удаление сборки (папки target).

 Если требуется упростить название итогового архива, то следует использовать в pom.xml

 <build>
 <finalName>myApp</finalName>
 </build>

 и тогда будет создан архив myApp.jar.

 9.	Запустим вновь созданный архив на выполнение из командной строки

 java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.App

 Получим результат в командной строке:

 Hello World!

 */

public class _04_CommandLine4 {
}
