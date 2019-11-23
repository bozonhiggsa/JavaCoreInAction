package net.core.tutorial.elementary._14_StaticAndNonStatic;

/**

 Статические и нестатические поля и методы.

 Статические поля, static nested классы, байт коды классов загружаются в память PermGen в момент запуска программы,
 когда в коде встречается ссылка на соответствующий класс.

 Нестатические поля класса возникают в области Heap только тогда, когда создаётся объект соответствующего класса.
 При создании объекта вызывается (явно или неявно) конструктор, который инициализирует все поля объекта.

 Из нестатического метода можно вызвать как статические, так и нестатические поля класса, в котором он объявлен.
 Ведь нестатический метод можно вызвать только у конкретного объекта данного класса. А поскольку объект существует,
 то гарантированно существуют и нестатические поля в Heap. А значит метод имеет возможность к ним обратиться.

 Из статического метода можно вызвать статические поля класса, в котором он объявлен, а также статические поля других
 классов (через ClassName.name), если позволяет их модификатор доступа. Нестатические поля класса, того в котором
 объявлен метод или другого, так просто вызвать нельзя. Ведь статический метод можно вызвать как из объекта, так и
 просто по имени класса. Поэтому нет гарантии, что объект класса, а значит и его нестатические поля, существуют.
 Или же может быть непонятно к полю какого конкретного объекта следует обратиться. Однако, в статическом методе можно
 создать объект класса (можно даже анонимный) и обратиться к его нестатическому полю.

 Аналогично, в статическом методе класса нельзя напрямую вызвать нестатический метод этого же класса. Ведь нет гарантии,
 что объект класса существует. Или, если объектов несколько, непонятно, нестатический метод какого конкретно объекта надо
 вызывать. Прежде надо создать конкретный объект класса, а уже у объекта вызвать нестатический метод.
 Также и нестатические методы других классов можно вызвать только создав объекты этих классов и обратившись к ним.

 Метод main статический. Поэтому можно считать, что он запускается в момент начала исполнения программы по имени класса,
 в котором он написан. И при этом нет необходимости создавать конкретный объект этого класса. В методе main можно обратиться
 к нестатическим полям и нестатическим методам этого же класса, только если создать объект класса, в котором написан метод main.

 В методе main можно создавать объекты других классов top level. Можно создавать объекты static nested классов
 (даже тех, которые объявлены не в том же классе, в котором объявлен метод main). Но для того, чтобы создать объект
 inner класса придётся сначала создать объект его внешнего класса:

 Top_level.Inner h = new Top_level().new Inner();

 Во внешний класс можно импортировать классы, в том числе nested классы, а затем обращаться к ним,
 используя сокращённое (простое) имя. Нельзя импортировать классы с одинаковым именем из разных пакетов.
 Но можно использовать полные имена классов.

 */

public class _01_StaticAndNonStatic {
}
