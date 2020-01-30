package net.core.tutorial.elementary._25_Collections._03_Maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapBasedOnObjects {

    public static void main(String[] args) {

        Map<SomeKey, SomeValue> map = new HashMap<>();

        map.put(new SomeKey(10, 11), new SomeValue("Oleg", 40));
        map.put(new SomeKey(100, 110), new SomeValue("Irina", 50));
        map.put(new SomeKey(1000, 1100), new SomeValue("Max", 30));
        map.put(new SomeKey(101, 102), new SomeValue("Anna", 20));
        map.put(new SomeKey(101, 102), new SomeValue("Elena", 25));

        System.out.println("Map is empty? : " + map.isEmpty());
        System.out.println("Map size : " + map.size());
        System.out.println("Map contains key? : " + map.containsKey(new SomeKey(1000, 1100)));
        System.out.println("Map contains value? : " + map.containsValue(new SomeValue("Anna", 20)));
        System.out.println("Map contains value? : " + map.containsValue(new SomeValue("Elena", 25)));

        System.out.println("----------------------------");

        for(Map.Entry<SomeKey, SomeValue> entry: map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("----------------------------");

        SomeKey dangerousKey = new SomeKey(33, 44);
        map.put(dangerousKey, new SomeValue("Leonid", 45));

        for(Map.Entry<SomeKey, SomeValue> entry: map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        System.out.println("----------------------------");

        // После добавления в map можно изменить ключ пары, из-за чего эта пара потеряется
        dangerousKey.setValue1(10);
        dangerousKey.setValue2(11);

        for(Map.Entry<SomeKey, SomeValue> entry: map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("Map contains key? : " + map.containsKey(new SomeKey(10, 11)));
        System.out.println("Value for key : " + map.get(new SomeKey(10, 11)));
    }
}
