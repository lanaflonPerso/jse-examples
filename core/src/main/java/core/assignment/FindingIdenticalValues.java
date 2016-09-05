package core.assignment;

import java.util.*;

/**
 * Created by ehimnay on 03/09/2016.
 */
public class FindingIdenticalValues {
    public static void main(String...args) {
        System.out.println(countRepeatedValue(new int[]{1,3,1,3,3,3,4,5,6,3,2}));
        System.out.println(countRepeatedValue(new int[]{1,3,1,4,5,6,3,2}));
    }

    public static int countRepeatedValue(final int[] numbers) {
        final Map<Integer, Integer> map = new TreeMap<>();
        if(numbers.length > 10_000) return 0;
        for (final int number : numbers) {
            if(number > 10_000)continue;
            if (map.get(number) != null) {
                int value = map.get(number);
                map.put(number, ++value);
            } else {
                int value = 1;
                map.put(number, value);
            }
        }
        Set<Integer> set = new HashSet<>(map.values());
        set.remove(1);
        return set.size();
    }
}
