package net.core.tutorial.elementary._15_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**

 Массивы.

 Массив - это отдельный ссылочный тип данных в Java.
 Для создания переменной массива можно использовать квадратные скобки, расположив их справа от имени массива
 или справа от типа объектов, из которых составлен массив, например:

 int nNumbers[];
 int[] nAnotherNumbers;
 Допустимы оба варианта, но согласно Code Convention следует всегда использовать вариант int[] nNumbers.

 Данные записи позволяют лишь создать переменную для хранения ссылки на массив, но не сам массив
 (не происходит резервирования памяти). Создание объекта массива выполняется при помощи ключевого слова new.

 Массивы могут быть многомерными и несимметричными. Фактически многомерный массив в Java это массив массивов.
 В первом одномерном массиве хранятся ссылки на одномерные массивы второго уровня и т.д.

 */
public class _01_Arrays1 {

    public static void main(String[] args) {

        // Динамическая инициализация элементов массива.
        // При динамической инициализации необходимо явно указывать размерность массива.
        int[] numbers1;
        numbers1 = new int[15];
        int nInitialValue = 7;
        for(int i = 0; i < 15; i++)
        {
            numbers1[i] = nInitialValue;
        }

        // Статическая инициализация элементов массива.
        // Выполняется сразу при объявлении переменной массива. И при этом нельзя указывать размерность,
        // т.к. она очевидна:
        int[] numbers2 = {255, 255, 100, 0, 10};

        // Аналогом статической инициализации является создание анонимного массива:
        int[] numbers3 = new int[] {255, 255, 100, 0, 10};

        // Можно создавать массивы не только из переменных примитивных типов, но и из произвольных объектов.
        // Каждый элемент такого массива должен инициализироваться оператором new:
        Object[] arrayOfObjects1 = new Object[]{new ArrayList<Integer>(), new LinkedList<Integer>(),
                new HashMap<Integer, String>()};

        Object[] arrayOfObjects2 = new Object[3];
        arrayOfObjects2[0] = new ArrayList<Integer>();
        arrayOfObjects2[1] = new ArrayList<Integer>();
        arrayOfObjects2[2] = new ArrayList<Integer>();

        // Если некоторые ячейки ещё не инициализированы, то они равны null (для объектов) или значениям
        // по умолчанию (для примитивных типов). Если попытаться записать значение в несуществующую ячейку
        // (превысить размер массива), то получим ArrayIndexOutOfBoundsException.
        try{
            arrayOfObjects2[3] = new ArrayList<Integer>();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Вылетело исключение ArrayIndexOutOfBoundsException при попытке доступа" +
                    " к ячейке, индекс которой выходит за диапазон существующего массива");
        }

        // Если применить к массиву  toString(), то получим просто ссылку на массив объектов.
        // Для отображения содержимого элементов массива можно воспользоваться переопределённым
        // методом .toString() из утилитарного класса Arrays, который позволяет корректно отображать
        // различные типы содержимого массива. Например:

        System.out.println("-----------------------------");
        System.out.println("Отображение ссылки на массив в памяти при помощи toString(): " + numbers3.toString());
        System.out.println("Отображение содержимого массива при помощи Arrays.toString(): " + Arrays.toString(numbers3));

        System.out.println("-----------------------------");

        // При динамической инициализации при создании многомерного массива можно сразу жёстко указать размерность:
        int[][] a = new int[5][3];
        a[1][0] = 4;
        a[1][2] = 5;
        a[2] = new int[]{1,2,3,4,5,6,7,8}; // статическая инициализация с изменением размерности
        a[2][7] = 30;
        a[3] = new int[12]; // создание вектора без инициализации элементов
        a[4] = new int[10];
        System.out.println("Отображение содержимого многомерного массива: " + Arrays.toString(a));
        System.out.println("Отображение содержимого массивов второго уровня:");
        for (int[] innerArr: a) {
            System.out.println(Arrays.toString(innerArr));
        }
        System.out.println("-----------------------------");

        // При этом можно выполнять инициализацию элементов строго в заданной размерности:
        // a[1][0] = 4;
        // a[1][2] = 5;
        // Но можно и изменить размерность для какого либо вектора:
        // a[2] = new int[]{1,2,3,4,5,6,7,8};
        // И тогда появится возможность получить доступ к значениям вектора с новой размерностью:
       //  a[2][7] = 30;

        // При создании многомерного массива допускается указывать только первые размерности, но при этом потребуется
        // в дальнейшем при помощи new создать в памяти новые размерности (массивы верхних уровней):
        int[][] arr = new int[5][];
        try{
            arr[1][0] = 4;
            arr[1][2] = 5;
        }
        catch(NullPointerException e){
            System.out.println("Возникло NullPointerException, т.к. ссылки на данные элементы в массиве первого уровня пока равны null");
        }
        arr[2] = new int[]{1,2,3,4,5,6,7,8};
        arr[2][7] = 30;
        arr[3] = new int[12];
        arr[4] = new int[10];

        System.out.println("-----------------------------");

        System.out.println("Обращение к параметру length многомерного массива возвращает размерность массива первого уровня:");
        System.out.println("arr.length = " + arr.length);
        System.out.println("Получить значение размерности для одного из векторов второго уровня можно при помощи:");
        try{
            System.out.println("arr[0].length = " + arr[0].length);
        }
        catch(NullPointerException e){
            System.out.println("Для arr[0].length возникло NullPointerException, т.к. так как данная размерность ещё не задана");
        }
        System.out.println("arr[2].length = " + arr[2].length);
        System.out.println("arr[3].length = " + arr[3].length);

        System.out.println("-----------------------------");

        String[] strings = getArray();
        System.out.println(Arrays.toString(strings));
    }

    // Способ вернуть массив из метода
    public static String[] getArray() {
        String[] s = new String[3];
        s[0] = "Hi!";
        s[1] = "Hello!";
        s[2] = "Hey!";
        return s;
    }
}
