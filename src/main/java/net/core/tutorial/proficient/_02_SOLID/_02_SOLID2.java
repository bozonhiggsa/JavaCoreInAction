package net.core.tutorial.proficient._02_SOLID;

import java.util.Arrays;
import java.util.List;

/**

 Open-Closed Principle.
 Программные сущности (классы, модули, функции) должны быть открыты для расширения, но не для модификации.

 */
public class _02_SOLID2 {

    private List<Animal> animals = Arrays.asList(new Animal("bear"), new Animal("fox"), new Animal("rabbit"));
    private List<Animal2> animals2 = Arrays.asList(new Bear("bear"), new Fox("fox"), new Rabbit("rabbit"));

    // Код нарушает принцип открытости/закрытости.
    // Метод определяет то, какой звук издаёт то или иное животное, анализируя конкретные объекты.
    // Поэтому при добавлении нового животного потребуется модифицировать данный метод
    public void animalSound(List<Animal> animals) {

        for (Animal animal: animals) {
            if(animal.getAnimalName().equals("bear")){
                System.out.println("roar");
            }
            if(animal.getAnimalName().equals("fox")){
                System.out.println("mimi");
            }
            if(animal.getAnimalName().equals("rabbit")){
                System.out.println("hrr");
            }
        }
    }

    // Теперь функция не знает, с какими конкретно объектами она будет работать, поэтому её код не будет изменяться
    // при добавлении в коллекцию animals2 новыъ сущностей
    public void animalSound2(List<Animal2> animals2) {

        for (Animal2 animal: animals2) {
            animal.makeSound();
        }
    }

    public static void main(String[] args) {

        _02_SOLID2 solid2 = new _02_SOLID2();
        solid2.animalSound(solid2.animals);

        System.out.println("----------------------");

        solid2.animalSound2(solid2.animals2);
    }
}

class Animal {

    private String animalName;

    public Animal(String animalName) {

        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }
}

// Рефакторинг кода
abstract class Animal2 {

    private String animalName;

    public Animal2(String animalName) {

        this.animalName = animalName;
    }

    public String getAnimalName() {
        return animalName;
    }

    abstract public void makeSound();

}

class Bear extends Animal2 {

    public Bear(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("roar");
    }
}

class Fox extends Animal2 {

    public Fox(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("mimi");
    }
}

class Rabbit extends Animal2 {

    public Rabbit(String animalName) {
        super(animalName);
    }

    @Override
    public void makeSound() {
        System.out.println("hrr");
    }
}