package net.core.tutorial.elementary._20_Enum;

/**

 Enum.

 Специальный перечислимый тип (класс), у которого можно создать ограниченное количество экземпляров.
 Имеет смысл использовать для задания фиксированного количества значений,
 которое не может изменяться в будущем.

 Иногда требуется реализовать класс так, чтобы у него был всего один объект (Singleton).
 Enum это Multiton – у него фиксированное количество экземпляров.
 Но простейший способ создать Singleton это использовать Enum.
 Фактически Enum это набор синглетонов, которые находятся в памяти в единственном экземпляре и на которые
 может быть множество ссылок из программы.

 Объекты Enum нельзя складывать между собой или вычитать. Это объекты, которые не надо сравнивать между собой.
 Тип Enum нельзя наследовать.

 Фактически Enum это такой специальный класс:
 - класс является финальным, т.е. от него нельзя наследоваться.
 - у класса приватный конструктор – объектов класса будет ровно столько, сколько объявлено в самом классе.
 - в классе можно объявлять поля и методы. Внутри может быть метод public static void main,
 но в нём нельзя создавать новые объекты Enum.
 - Enum является наследником класса Object и в нём есть доступ к методам класса Object,
 но переопределить можно только .toString().

 */

public class _01_Enum1 {

    public static void main(String[] args) {

        Color color = Color.RED;
        System.out.println(color);

        Color c1 = Color.GREEN;
        Color c2 = null;
        // Color c3 = new Color(); // запрещено создавать новые объекты Enum, даже так
        System.out.println(c1.hashCode());

        System.out.println("------------------");

        Color2.main(null);

        System.out.println("------------------");
    }
}

enum Color{

    RED, GREEN, BLACK;

    @Override
    public String toString() {
        return "Override string";
    }
}

//Фактически Enum это такой специальный класс:
final class Color2{

    public static Color2 RED = new Color2();
    public static Color2 GREEN = new Color2();
    public static Color2 BLACK = new Color2();

    public int number = 100;
    public String message = "Hello!";

    private Color2() {}

    @Override
    public int hashCode() {
        return 333;
    }

    @Override
    public String toString() {
        return "Some permanent string";
    }

    public static void main(String[] args) {

        System.out.println(Color2.BLACK + ", " + Color2.GREEN + ", " + Color2.RED);
        System.out.println(Color2.BLACK.hashCode() + ", " + Color2.GREEN.hashCode());
    }
}
