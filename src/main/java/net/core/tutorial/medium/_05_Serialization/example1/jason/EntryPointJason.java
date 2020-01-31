package net.core.tutorial.medium._05_Serialization.example1.jason;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Entry Point for demonstrating the marshaling and unmarshaling using JASON.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class EntryPointJason {

    public static void main(String[] args) {

        DataObjectJason dataObj = new DataObjectJason();
        dataObj.setNumber(33);
        dataObj.setAge(99);
        dataObj.setS("Hey!");
        dataObj.setList(Arrays.asList("One", "Two", "Three", "Four", "One"));
        Set<String> set = new HashSet<>();
        set.add("One");
        set.add("Two");
        dataObj.setSet(set);
        HashSet<CustomObjectJason> customSet = new HashSet<CustomObjectJason>();
        customSet.add(new CustomObjectJason("Green", 10));
        customSet.add(new CustomObjectJason("Red", 100));
        customSet.add(new CustomObjectJason("Blue", 1000));
        dataObj.setSetCustomObject(customSet);
        AnotherCustomObjectJason anotherCustomObjectJason = new AnotherCustomObjectJason(80);
        AnotherCustomObjectJason.setStature(180);
        dataObj.setAnotherCustomObjectJason(anotherCustomObjectJason);

        Gson gson = new Gson();
        String json = gson.toJson(dataObj);
        DataObjectJason dataObjFromJson1 = gson.fromJson(json, DataObjectJason.class);
        System.out.println(dataObjFromJson1);

        Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
        String jsonPretty = gsonPretty.toJson(dataObj);
        DataObjectJason dataObjFromJson2 = gsonPretty.fromJson(jsonPretty, DataObjectJason.class);
        System.out.println(dataObjFromJson2);

    }
}
