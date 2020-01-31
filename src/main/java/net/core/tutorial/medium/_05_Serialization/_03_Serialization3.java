package net.core.tutorial.medium._05_Serialization;

import java.io.*;

/**

 Для того, чтобы изменить механизм сериализации/десериализации
 (например, для того, чтобы сериализовать в том числе transient поля), необходимо в сериализуемый
 класс добавить два метода:

 private void writeObject(ObjectOutputStream out) throws IOException {}

 и

 private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {}

 Они позволяют изменить процедуру записи полей текущего класса (не влияют на запись метаданных).
 Если у текущего класса есть сериализованный предок, то поля предка сериализуются вне зависимости
 от содержимого данных методов.

 В методе .writeObject рекомендуется сначала реализовать стандартную функциональность, вызвав метод

 out.defaultWriteObject(),

 а уже затем добавлять новый функционал. Например, можно транзиентные поля сериализовать при помощи методов

 out.writeObject(Object o); // для ссылочных полей
 out.writeInt(int val); // и подобных методов для полей примитивных типов

 Аналогично в методе .readObject рекомендуется сначала вызвать метод

 in.defaultReadObject(),

 а уже затем добавлять новый функционал. Например, десериализовать транзиентные поля при помощи методов:

 name = (String) in.readObject(); // для ссылочных полей
 age = in.readInt(); // и подобных методов для полей примитивных типов


 Имеется похожий интерфейс java.io.Externalizable, который объявляет два метода:

 @Override
 public void writeExternal(ObjectOutput out) throws IOException {
 }

 @Override
 public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
 }

 Эти методы должны быть обязательно реализованы (в отличие от предыдущих методов) и позволяют чётко определить,
 какие поля класса следует сериализовать. При этом не будут сериализоваться метаданные класса и его предков.
 Не будут сериализоваться поля, унаследованные от предка, если только это не прописать явно в данных методах.
 Например, можно сериализовать transient поля, если их транзиентность нужна для других задач в коде.
 При использовании Externalizable при десериализации сначала вызывается конструктор без аргументов
 сериализованного класса, а потом уже на созданном объекте вызывается метод .readExternal(),
 который и вычитывает, собственно, все свои данные. Поэтому любой класс, реализующий интерфейс Externalizable,
 обязан иметь public конструктор без аргументов.
 Все наследники такого класса тоже будут считаться реализующими интерфейс Externalizable и у них тоже должен
 быть конструктор без аргументов.

 Поля с модификатором final сериализуются как и обычные. За одним исключением – их невозможно десериализовать
 при использовании Externalizable, т.к. final поля должны быть инициализированы в конструкторе.
 А после этого в .readExternal() изменить значение этого поля будет невозможно. Соответственно – если
 необходимо сериализовать объект, имеющий final поле, то следует использовать только стандартную сериализацию.

 */

public class _03_Serialization3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        CustomersClass customersClass = new CustomersClass(true, "Oleg", 2020);
        System.out.println("Fields of class until serialization: " + customersClass.isMark() + ", "
                + customersClass.getName() + ", " + customersClass.getCost());

        FileOutputStream fos = new FileOutputStream("another_tester.bin");
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(customersClass);
        outputStream.close();

        FileInputStream fis = new FileInputStream("another_tester.bin");
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        CustomersClass customersClassNew = (CustomersClass) inputStream.readObject();
        inputStream.close();

        System.out.println("--------------------");
        System.out.println("Fields of class until serialization: " + customersClassNew.isMark() + ", "
                + customersClassNew.getName() + ", " + customersClassNew.getCost());
    }
}

class CustomersClass implements Serializable {

    private boolean mark;
    private transient String name;
    private transient int cost;

    public CustomersClass(boolean mark, String name, int cost) {
        this.mark = mark;
        this.name = name;
        this.cost = cost;
    }

    public boolean isMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {

        out.defaultWriteObject();
        out.writeObject(name);
        out.writeInt(cost);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {

        in.defaultReadObject();
        name = (String) in.readObject();
        cost = in.readInt();
    }
}