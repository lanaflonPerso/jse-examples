package core.collection.custom.hashmap;

public class HashMapCustom<V, K> {
    private static final int SIZE = 16;
    private Entry table[] = new Entry[SIZE];

    public Entry get(String k) {
        int hash = k.hashCode() % SIZE;

        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.key.equals(k)) {
                return e;
            }
        }
        return null;
    }

    public void put(String k, String v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];
        if (e != null) {
            if (e.key.equals(k)) {
                e.value = v;
            } else {
                while (e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(k, v);
                e.next = entryInOldBucket;
            }
        } else {
            Entry entryInNewBucket = new Entry(k, v);
            table[hash] = entryInNewBucket;
        }
    }
}
