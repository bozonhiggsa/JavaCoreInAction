package net.core.tutorial.elementary._25_Collections._03_Maps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapBasedOnObjects {

    public static void main(String[] args) {

        Map<SomeTreeKey, String> map = new TreeMap<>(new SomeTreeKeyComparator());

        map.put(new SomeTreeKey(200, 300), "Elena");
        map.put(new SomeTreeKey(200, 300), "Masha");
        map.put(new SomeTreeKey(100, 300), "Igor");
        map.put(new SomeTreeKey(-100, 300), "Sergey");

        System.out.println("Map is empty? : " + map.isEmpty());
        System.out.println("Map size : " + map.size());
        System.out.println("Map contains key? : " + map.containsKey(new SomeTreeKey(200, 300)));
        System.out.println("Map contains value? : " + map.containsValue("Elena"));
        System.out.println("Map contains value? : " + map.containsValue("Masha"));

        System.out.println("----------------------------");

        for(Map.Entry<SomeTreeKey, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
