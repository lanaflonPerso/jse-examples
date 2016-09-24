package core.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapRead {
    public static void main(String...args) {
        Map<String, String> loans = new HashMap<>();
        entrySet(loans);
        keySet(loans);
        iterator(loans);
    }

    public static void keySet(Map<String, String> loans) {
        loans.put("Himansu Nayak", "Ericsson");
        loans.put("Country", "Ireland");

        for (String key : loans.keySet()) {
            System.out.println("key: " + key + " value: " + loans.get(key));
        }
    }

    public static void entrySet(Map<String, String> loans) {
        Set<Map.Entry<String, String>> entrySet = loans.entrySet();
        for (Map.Entry entry : entrySet) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    public static void iterator(Map<String, String> loans) {
        // keyset iterator
        Set<String> keySet = loans.keySet();
        Iterator<String> keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext()) {
            String key = keySetIterator.next();
            System.out.println("key: " + key + " value: " + loans.get(key));
        }

        // entryset iterator
        Set<Map.Entry<String, String>> entrySet1 = loans.entrySet();
        Iterator<Map.Entry<String, String>> entrySetIterator = entrySet1.iterator();
        while (entrySetIterator.hasNext()) {
            Map.Entry entry = entrySetIterator.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
