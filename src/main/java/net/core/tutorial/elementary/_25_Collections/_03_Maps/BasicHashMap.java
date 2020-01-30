package net.core.tutorial.elementary._25_Collections._03_Maps;

import java.util.*;

public class BasicHashMap {

    public static void main(String[] args) {

        Map<Integer, String> map1 = new HashMap<>();

        System.out.println("Map is empty? : " + map1.isEmpty());
        System.out.println("Map size : " + map1.size());

        System.out.println("-----------------------");

        map1.put(1, "Developer");
        map1.put(2, "QA");
        map1.put(3, "DevOps");
        map1.put(10, "PM");
        map1.put(1, "HR");
        System.out.println("Map is empty? : " + map1.isEmpty());
        System.out.println("Map size : " + map1.size());
        System.out.println("Map contains key? : " + map1.containsKey(3));
        System.out.println("Map contains value? : " + map1.containsValue("DevOps"));
        map1.replace(3, "DataScientist");

        System.out.println("-----------------------");

        Set<Map.Entry<Integer, String>> entries = map1.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-----------------------");

        for (Map.Entry<Integer, String> entry: map1.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());

        System.out.println("-----------------------");

        for (Integer key: map1.keySet())
            System.out.println(map1.get(key));

        System.out.println("-----------------------");

        Set<Integer> keys = map1.keySet();
        System.out.println(keys);
        Collection<String> values = map1.values();
        System.out.println(values);

        System.out.println("-----------------------");

        keys.remove(10);
        values.remove("DataScientist");
        for (Map.Entry<Integer, String> entry: map1.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }
}
