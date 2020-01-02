package net.core.tutorial.elementary._24_NestedClasses;

/**

 Внутренние и вложенные классы.

 Классы могут быть top level или nested (вставленные в другие классы).
 Классы top level это классы, которые не находятся в блоке {} другого класса.
 Классы top level не могут быть статическими.

 Классы nested могут быть inner (внутренними) или static nested (вложенными).

 nested это любой класс, интерфейс, Enum, объявленный внутри чужих {}.
 При этом при компиляции создаются файлы MainClass$Nest_name.class.
 Внутрь nested (кроме Enum) можно поместить другой nested.

 Класс nested является inner, если он не static, иначе он static nested.

 Применение nested классов это один из способов сокрытия реализации, т.к. nested класс может быть абсолютно
 недоступен и не виден вне класса-владельца. Одной из важнейших причин использования nested классов является
 возможность независимого наследования nested классами.
 Фактически при этом реализуется множественное наследование со своими преимуществами и проблемами.

 */

public class _01_NestedClasses1 {

    public static void main(String[] args) {

        SomeTopLevelClass.SomeInnerClass innerClass = new SomeTopLevelClass().new SomeInnerClass();
        System.out.println(innerClass);

        System.out.println("-----------------");

        SomeTopLevelClass.SomeStaticNestedClass staticNestedClass = new SomeTopLevelClass.SomeStaticNestedClass();
        System.out.println(staticNestedClass);
    }
}

class SomeTopLevelClass {

    class SomeInnerClass extends Parent1 {

    }

    static class SomeStaticNestedClass extends Parent2 {

    }
}

class Parent1 {

    @Override
    public String toString() {
        return "Parent1{}";
    }
}

class Parent2 {

    @Override
    public String toString() {
        return "Parent2{}";
    }
}