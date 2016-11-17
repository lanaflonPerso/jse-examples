package main.java.com.projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 * Find the sumOfAll of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sumOfAll.
 */
public class PandigitalProducts {
    public static void main(String...args) {
        final Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int multiplicand = 1; multiplicand <= 9999; multiplicand++) {
            for (int multiplier = multiplicand; multiplier <= 9999; multiplier++) {
                int concat = concatDigit(multiplicand, multiplier);
                int prod = multiplicand * multiplier;
                Integer finalConcat = concatDigit(concat, prod);
                if (finalConcat.toString().length() == 9 && isPandigital(finalConcat)) {
                    if (!set.contains(prod)) {
                        set.add(prod);
                        sum += prod;
                        System.out.println(sum);
                    }
                }
            }
        }
    }

    public static boolean isPandigital(final int n) {
        Set<Character> set = new HashSet<>();
        String string = Integer.toString(n);
        for (char c : string.toCharArray()) {
            if (c == '0') return false;
            set.add(c);
        }
        return set.size() == string.length();
    }

    public static int concatDigit(int a, int b) {
        int c = b;
        while (c > 0) {
            a *= 10;
            c /= 10;
        }
        return a + b;
    }
}
