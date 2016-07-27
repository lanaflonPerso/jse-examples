package core.collection.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeHashMap {

    public void threadSafeR() {
        Map<String, String> map = new HashMap<>();
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock wl = rwl.writeLock();
    }

    public void threadSafeC(Map<String, String> map) {
        Map<String, String> threadSafeMap = Collections.synchronizedMap(map);
    }

    public void threadSafeS(Map<String, String> map) {
        synchronized (map) {
            map.put("A", "B");
        }
    }

    private String get(Map<String, String> map, ReadWriteLock readWriteLock) {
        Lock rl = readWriteLock.readLock();
        rl.lock();
        try {
            return map.get("A");
        } finally {
            rl.unlock();
        }
    }

    private String put(Map<String, String> map, ReadWriteLock readWriteLock) {
        Lock wl = readWriteLock.writeLock();
        wl.lock();
        try {
            return map.put("A", "B");
        } finally {
            wl.unlock();
        }
    }
}
