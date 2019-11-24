package net.core.tutorial.elementary._16_ReferenceTypes;

import java.lang.ref.*;

/**

 In Java there are four types of references differentiated on the way by which they are garbage collected:

 - Strong References
 - Weak References
 - Soft References
 - Phantom References

 Strong References:
 This is the default type/class of Reference Object. Any object which has an active
 strong reference are not eligible for garbage collection. The object is garbage collected only when the variable
 which was strongly referenced points to null.

 Weak References:
 Weak Reference Objects are not the default type/class of Reference Object and they should
 be explicitly specified while using them.
 - This type of reference is used in WeakHashMap to reference the entry objects.
 - If JVM detects an object with only weak references (i.e. no strong or soft references linked to any object object),
 this object will be marked for garbage collection.
 - To create such references java.lang.ref.WeakReference class is used.
 - These references are used in real time applications while establishing a DBConnection which might be cleaned up
 by Garbage Collector when the application using the database gets closed.

 Soft References:
 In Soft reference, even if the object is free for garbage collection then also its not garbage collected,
 until JVM is in need of memory badly. The objects gets cleared from the memory when JVM runs out of memory.
 To create such references java.lang.ref.SoftReference class is used.

 Phantom References:
 The objects which are being referenced by phantom references are eligible for garbage collection. But,
 before removing them from the memory, JVM puts them in a queue called ‘reference queue’. They are put in a
 reference queue after calling finalize() method on them.
 To create such references java.lang.ref.PhantomReference class is used.

 Главное отличие SoftReference от WeakReference в том как сборщик мусора будет с ними работать. Он может удалить
 объект в любой момент если на него указывают только weak ссылки, с другой стороны объекты с soft ссылкой будут
 удалены только когда JVM очень нужна память. Благодаря таким особенностям ссылочных классов каждый из них имеет
 свое применение. SoftReference можно использовать для реализации кэшей и когда JVM понадобится память она освободит
 ее за счет удаления таких объектов. А WeakReference отлично подойдут для хранения метаданных, например для хранения
 ссылки на ClassLoader. Если нет классов для загрузки то нет смысла хранить ссылку на ClassLoader, слабая ссылка
 делает ClassLoader доступным для удаления как только мы назначим ее вместо крепкой ссылки (Strong reference).

 Кроме классов WeakReference, SoftReference, PhantomReference, WeakHashMap, полезно знать о классе ReferenceQueue.
 Вы можете воспользоваться этим классом при создании объекта класса WeakReference, SoftReference или PhantomReference:

 ReferenceQueue refQueue = new ReferenceQueue();
 DigitalCounter digit = new DigitalCounter();
 PhantomReference phantom = new PhantomReference(digit, refQueue);

 Ссылка на объект будет добавлена в ReferenceQueue и вы сможете контролировать состояние
 ссылок путем опроса ReferenceQueue.

 */

public class _03_TypesOfReferences {

    public static void main(String[] args) {

        // Strong Reference - by default
        MyClass myClass1 = new MyClass();
        System.out.println(myClass1.toString());

        myClass1 = null;
        // Now, object to which 'myClass' was pointing earlier is
        // eligible for garbage collection.

        System.out.println("------------------------");

        // Strong Reference
        MyClass myClass2 = new MyClass();
        System.out.println(myClass2.toString());

        // Creating Weak Reference to MyClass-type object to which 'myClass2' is also pointing.
        WeakReference<MyClass> weakref = new WeakReference<>(myClass2);

        // Now, MyClass-type object to which 'myClass2' was pointing earlier
        // is available for garbage collection.
        // But, it will be garbage collected only when JVM needs memory.
        myClass2 = null;
        System.out.println(myClass2);

        // You can retrieve back the object which has been weakly referenced.
        // It succesfully calls the method.
        myClass2 = weakref.get();
        System.out.println(myClass2.toString());

        System.out.println("------------------------");

        // Strong Reference
        MyClass myClass3 = new MyClass();
        System.out.println(myClass3.toString());

        // Creating Soft Reference to MyClass-type object to which 'myClass3' is also pointing.
        SoftReference<MyClass> softref = new SoftReference<MyClass>(myClass3);

        // Now, MyClass-type object to which 'myClass3' was pointing
        // earlier is available for garbage collection.
        myClass3 = null;
        System.out.println(myClass3);

        // You can retrieve back the object which has been softly referenced.
        // It succesfully calls the method.
        myClass3 = softref.get();
        System.out.println(myClass3);

        System.out.println("------------------------");

        // Strong Reference
        MyClass myClass4 = new MyClass();
        System.out.println(myClass4.toString());

        // Creating reference queue
        ReferenceQueue<MyClass> refQueue = new ReferenceQueue<>();

        // Creating Phantom Reference to MyClass-type object to which 'myClass4' is also pointing.
        PhantomReference<MyClass> phantomRef = null;
        phantomRef = new PhantomReference<>(myClass4,refQueue);

        // Now, MyClass-type object to which 'myClass4' was pointing earlier is available for garbage collection.
        // But, this object is kept in 'refQueue' before removing it from the memory.
        myClass4 = null;
        System.out.println(myClass4);

        //It always returns null.
        myClass4 = phantomRef.get();

        //It shows NullPointerException.
        try{
            System.out.println(myClass4.toString());
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException is occurred");
        }

        Reference<? extends MyClass> poll = refQueue.poll();

        try{
            System.out.println(poll.toString());
        }
        catch (NullPointerException e){
            System.out.println("NullPointerException is occurred");
            System.out.println("Фантомная ссылка ещё не была удалена мусорщиком, а поэтому не была" +
                    "ещё добавлена в ReferenceQueue");
        }
    }
}

class MyClass {}