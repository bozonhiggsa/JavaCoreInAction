package net.core.tutorial.elementary._11_SOLID;

import java.util.Arrays;
import java.util.List;

/**

 Liskov Substitution Principle (Принцип подстановки Барбары Лисков).
 Необходимо, чтобы подклассы могли бы служить заменой для своих суперклассов.
 Должна обеспечиваться возможность, чтобы  классы-наследники могли использоваться вместо родительских классов,
 от которых они образованы, не нарушая работу программы.
 Если оказывается, что в коде проверяется тип класса, значит принцип подстановки нарушается.

 Методы, принимающие или возвращающие значения с типом некоего суперкласса должны также без нарушения работы кода
 принимать и возвращать значения, типами которых являются его подклассы.

 */

public class _03_SOLID3 {

    private static List<Animal3> animals3 = Arrays.asList(new Bear2("bear"), new Snake2("snake"));
    private static List<Animal4> animals4 = Arrays.asList(new Bear3("bear"), new Snake3("snake"));

    // Код метода нарушает принцип подстановки.
    // Метод определяет количество лап животных, проверяя тип конкретного объекта
    public static int numberOfLegs(Animal3 animal3) {

        if(animal3 instanceof Bear2){
            return 4;
        }
        else if(animal3 instanceof Snake2){
            return 0;
        }
        else return -1;
    }

    // Внутри метода выполняется работа с объектами классов-наследников, но аргумент и выходной тип
    // представлены классом предка
    public static Animal4 chooseAnimalWithLessNumberOfLegs(List<Animal4> animals4) {

        Animal4 tempAnimal = animals4.get(0);
        for (Animal4 animal: animals4) {
            if(animal.getNumberOfLegs() < tempAnimal.getNumberOfLegs()){
                tempAnimal = animal;
            }
        }

        return tempAnimal;
    }

    public static void main(String[] args) {

        for (Animal3 animal: animals3) {
            System.out.println("Количество лап животного " + animal.getAnimalName() + " равно " + numberOfLegs(animal));
        }

        System.out.println("----------------------");

        for (Animal4 animal: animals4) {
            System.out.println("Количество лап животного " + animal.getAnimalName() + " равно " + animal.getNumberOfLegs());
        }

        System.out.println("----------------------");

        System.out.println("Животное с меньшим числом лап: " + chooseAnimalWithLessNumberOfLegs(animals4).getAnimalName());
    }
}

abstract class Animal3 {

    private String animalName;

    public Animal3(String animalName) {

        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    abstract public void makeSound();

}

class Bear2 extends Animal3 {

    public Bear2(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("roar");
    }
}

class Snake2 extends Animal3 {

    public Snake2(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("shhhhh");
    }
}

// Рефакторинг кода
abstract class Animal4 {

    private String animalName;

    public Animal4(String animalName) {

        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    abstract public void makeSound();

    abstract public int getNumberOfLegs();

}

class Bear3 extends Animal4 {

    private int numberOfLegs = 4;

    public Bear3(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("roar");
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}

class Snake3 extends Animal4 {

    private int numberOfLegs = 0;

    public Snake3(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("shhhhh");
    }

    @Override
    public int getNumberOfLegs() {
        return numberOfLegs;
    }
}