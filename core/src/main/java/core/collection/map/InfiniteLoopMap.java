package core.collection.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InfiniteLoopMap {
    public static void main(String...args) {
        Map<Long, Long> map = new ConcurrentHashMap<>();
        map.put(0L, 0L);
        map.put((1L << 32) + 1, 0L); // hash collision
        for (long key : map.keySet()) {
            map.put(key, map.remove(key));
            System.out.println("InfiniteLoopMap.main");
        }
    }
} 