package core.collection.set;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIterationPerformance {

    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    static {
        for (int i = 0; i < 10_00_000; i++) {
            hashMap.put("key_" + i, i);
        }
    }

    public static void main(String...args) {

        // First way using entrySet in for-each loop
        long startTime = Calendar.getInstance().getTimeInMillis();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            entry.getKey();
            entry.getValue();
        }
        System.out.println(
                "Using entrySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        // Second way using keySet() in for-each loop
        startTime = Calendar.getInstance().getTimeInMillis();
        for (String key : hashMap.keySet()) {
            hashMap.get(key);
        }
        System.out
                .println("Using keySet() in for-each loop : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        // Third way using Iterator on entrySet() in while loop
        startTime = Calendar.getInstance().getTimeInMillis();
        Iterator<Map.Entry<String, Integer>> itr1 = hashMap.entrySet().iterator();
        while (itr1.hasNext()) {
            Map.Entry<String, Integer> entry = itr1.next();
            entry.getKey();
            entry.getValue();
        }
        System.out.println("Using entrySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));

        // Third way using Iterator on keySet() in while loop
        startTime = Calendar.getInstance().getTimeInMillis();
        Iterator<String> itr2 = hashMap.keySet().iterator();
        while (itr2.hasNext()) {
            String key = itr2.next();
            hashMap.get(key);
        }
        System.out.println("Using keySet() and iterator : " + (Calendar.getInstance().getTimeInMillis() - startTime));
    }
}
