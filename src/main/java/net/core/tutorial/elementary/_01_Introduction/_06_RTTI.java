package net.core.tutorial.elementary._01_Introduction;

import java.util.ArrayList;
import java.util.List;

/**
 RTTI.

 Механизм динамического определения типов RTTI (Runtime Type Information) предназначен для получения и использования
 информации о типах во время выполнения программы.
 Обычно при разработке ООП программ в коде в основном используются ссылки на базовый класс. Это унифицирует код,
 упрощает его чтение и сопровождение. Основная часть кода не должна зависеть от точного типа объекта, она оперирует
 универсальным представлением целого семейства объектов (классом-предком). Если в базовом классе имеется метод draw(),
 а в классах наследниках этот метод переопределён, то этот метод является динамически связываемым. Т.е. объекты классов
 наследников будут вызывать каждый свой метод draw(), а использоваться при этом будет ссылка на базовый класс
 (динамическая диспетчеризация). Если вдруг в программу будет добавлен новый класс-наследник, то код менять
 не придется. Таким образом можно создать объект класса-наследника, сохранить ссылку на него в переменную базового
 типа (сужение ссылочного типа) и забыть точный тип объекта, везде далее используя ссылку на базовый класс.
 В процессе восходящего преобразования (сужения ссылочного типа) теряется конкретная информация о классах объектов.
 Например, мы сохраняем ссылки на объекты в переменных класса-предка в контейнере List. Контейнер просто хранит
 переменные класса-предка и ничего не знает о конкретных классах объектов. Так же и во время компиляции компилятор
 посчитает, что в контейнере хранятся переменные класса-предка.
 И только во время выполнения программы задействуется механизм RTTI, проверяется истинный тип объекта и вступает
 в дело полиморфизм.
 Компилятор проверяет только тип переменных, а тип (класс) объектов проверяется только во время исполнения программы.

 Такой подход позволяет использовать сторонний откомпилированный код основной программы в сочетании с собственными
 откомпилированными блоками (где реализованы классы конкретных объектов).

 */
public class _06_RTTI {

    public static void main(String[] args) {

        List<Parent> childs = new Mediator().createListOfChilds();

        for (Parent child: childs) {
            child.draw();
        }
    }

}

class Parent {

    public void draw(){
        System.out.println("I am parent");
    }
}

class Child1 extends Parent {

    public void draw(){
        System.out.println("I am child 1");
    }
}

class Child2 extends Parent {

    public void draw(){
        System.out.println("I am child 2");
    }
}

class Child3 extends Parent {

    public void draw(){
        System.out.println("I am child 3");
    }
}

class Assembly {

    private List<Parent> childs;

    public void addChild(Parent child){
        if(childs != null){
            childs.add(child);
        }
        else {
            childs = new ArrayList<>();
            childs.add(child);
        }
    }

    public List<Parent> getChilds() {
        return childs;
    }
}

class Mediator {

    public List<Parent> createListOfChilds(){

        Assembly assembly = new Assembly();
        assembly.addChild(new Parent());
        assembly.addChild(new Child1());
        assembly.addChild(new Child2());
        assembly.addChild(new Child3());
        return assembly.getChilds();
    }
}