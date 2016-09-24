package core.collection.custom.hashmap;

public class HashMapCustomMain {
    public static void main(String...args) {
        HashMapCustom hashMap = new HashMapCustom();

        hashMap.put("Himansu", "Nayak");
        hashMap.put("Harish", "Majji");
        hashMap.put("Siva", "Part 2");
        hashMap.put("MBRDI", "Whitefield");

        Entry e = hashMap.get("Harish");
        System.out.println("" + e.getValue());
    }
}
