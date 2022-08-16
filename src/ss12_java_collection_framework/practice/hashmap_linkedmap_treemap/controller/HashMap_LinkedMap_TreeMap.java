package ss12_java_collection_framework.practice.hashmap_linkedmap_treemap.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class HashMap_LinkedMap_TreeMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Son", 30);
        hashMap.put("Vinh", 25);
        hashMap.put("Peter", 20);
        hashMap.put("Switch", 28);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in ascending order of key");
        System.out.println(treeMap);

        Map<String, Integer> linkedMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedMap.put("Son", 30);
        linkedMap.put("Vinh", 25);
        linkedMap.put("Peter", 20);
        linkedMap.put("Switch", 28);
        System.out.println("\n The age for Son is "+linkedMap.get("Son"));
    }
}
