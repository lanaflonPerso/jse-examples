package com.synchronoss;

import java.util.*;

/**
 * Write a program to establish the amount of unique numeric values that repeat more than once in a finite collection. Please make sure it returns the
 * quantity of such numbers rather than how many times they appear.
 * For example. Complete the function "countRepeatedValues" which contains an integer array "numbers" as its argument. Return an integer to indicate
 * the amount of such unique repeating values.
 * Constraints:
 *       1 ≤ length of collection ≤ 10000
 *       1 ≤ any value in collection ≤ 10000
 *
 * Input Format:
 *      Function "countRepeatedValues" gets an integer array "numbers" as an argument.
 * Output Format:
 *      Return an integer which denotes the amount of unique values that repeat in the collection.
 * Sample Input #00:
 *      13145632
 * Sample Output #00:
 *      2
 * Explanation #00:
 *      The input gives you have a collection x = {1,3,1,3,3,3,4,5,6,3,2}.
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
