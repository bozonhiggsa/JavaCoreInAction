package net.core.tutorial.elementary._24_Exceptions;

/**

 Если при разработке программы необходимо создать набор собственных исключений, то принято делать их
 наследниками Exception (если исключения должны быть checked) или RuntimeException (если unchecked).
 Нежелательно создавать исключения – наследники Error или Throwable.

 Если есть набор связанных исключений, то целесообразно не делать каждое из них наследником Exception,
 а сделать для них общего предка, который будет наследником Exception. В этом случае можно будет написать
 один catch (для предка) и перехватывать сразу все исключения, а при необходимости добавлять новые исключения.

 При создании собственного исключения желательно вставить в него

 private static final long serialVersionUID = someLong;

 В блоке catch может быть несколько вариантов перехватываемых исключений:

 catch(Exception1 | Exception2 | Exception3) {
 }

 После секции catch может быть секция finally{}, которая выполняется в любом случае, независимо от того,
 выполнилась ли секция try или секция catch.
 Можно использовать несколько последовательных секций catch, но необходимо сначала отлавливать
 более узкие исключения (исключения-наследники), а затем уже исключения-предки.
 Если в одной секции catch создаётся и пробрасывается новый объект исключения, то такое исключение
 не может быть перехвачено в другой последовательной секции catch.

 В Java есть специальная коллекция – Stack. Это коллекция, у которой есть методы «добавить элемент» и
 «достать элемент» в режиме LIFO. Первым будет взят элемент, который добавлен последним.

 Java-машина записывает в Stack вызовы всех методов. Когда один метод вызывает другой, Java-машина помещает
 в этот стек новый элемент StackTraceElement. Когда метод завершается, этот элемент удаляется из стека.
 Таким образом, в этом стеке всегда хранится актуальная информация о текущем состоянии «стека вызовов методов».

 В секции catch удобно использовать методы:

 e.printStackTrace();

 e.getStackTrace();
 возвращает объект StackTraceElement, по которому можно пройтись итератором:
 for(StackTraceElement element: e.getStackTrace()){
 }

 Каждый StackTraceElement содержит информацию о методе, который был вызван. В частности можно получить имя
 этого метода с помощью функции .getMethodName().

 throw e;
 пробросить исключение дальше

 Две последовательные секции catch не могут перехватывать одно и то же исключение. Секции try и catch могут быть
 пустыми. Секции catch может не быть (а соответственно может не быть и указания перехватываемого исключения),
 если есть секция finally.

 Не может быть двух секций try подряд.

 После секции try нельзя размещать выражение. Сразу за try должна располагаться секция catch и/или finally.
 Но если используется секция try-with-resources, а возможное исключение в этой секции пробрасывается дальше
 в сигнатуре метода, то секций catch и finally может не быть.

 Не может быть двух секций finally подряд.

 */

public class _03_Exceptions3 {
}
