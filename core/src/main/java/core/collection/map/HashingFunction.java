package core.collection.map;

public abstract class HashingFunction {
    public static void main(String...args) {
        System.out.println(hash(99999999));
        System.out.println(hash(99999999));
    }

    /**
     * hashmap rehashing function
     */
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }
}
