package core.assignment;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {

    /**
     * @param args
     */
    public static void main(String...args) {
        Map<Dummy, Dummy> map = new HashMap<>();
        System.out.println("Put Operation");
        Dummy test = new Dummy("Himansu");
        map.put(test, test);
        System.out.println("Get Operation");
        map.get(test);
        System.out.println("Test 2");
        Dummy test2 = new Dummy("Himansu");
        map.put(test2, test2);
        System.out.println("Get Operation");
        map.get(test2);
    }

}
