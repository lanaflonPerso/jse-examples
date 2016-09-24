package com.org.puzzle;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        hashMap();
    }

    public static void hashMap() {
        Map<Dummy, Integer> map = new HashMap<>();
        Dummy dummy = new Dummy("A");
        Dummy dummy2 = new Dummy("B");
        Dummy dummy3 = new Dummy("C");
        map.put(dummy, 1);
        System.out.println(map);
        map.put(dummy, 2);
        System.out.println(map);
        map.put(dummy, 3);
        System.out.println(map);
    }

    public static void hashMap2() {
        Map<Dummy, Dummy> map = new HashMap<>();
        System.out.println("Put Operation");
        Dummy test = new Dummy("Himansu");
        map.put(test, test);
        System.out.println("Get Operation");
        map.get(test);
        Dummy test2 = new Dummy("Himansu");
        map.put(test2, test2);
        System.out.println("Get Operation");
        map.get(test2);
    }

}
