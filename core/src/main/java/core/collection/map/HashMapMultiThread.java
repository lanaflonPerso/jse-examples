package core.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapMultiThread {
    public static void main(String...args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("DELTA", "DELTA");
        map.put("OMEGA", "OMEGA");
        new ReadThread(map).start();
        new WriteThread(map).start();
    }
}
