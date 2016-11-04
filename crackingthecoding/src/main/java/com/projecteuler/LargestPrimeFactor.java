package main.java.com.projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * <p>
 * What is the largest prime factor of the number 600851475143 ?
 */
public class LargestPrimeFactor {
    public static void main(String...args) {
        long number = 600851475143L;
        final List<Integer> factorial = new ArrayList<>();
        for (int divisor = 2; number > 1; divisor++) {
            while (number % divisor == 0) {
                number = number / divisor;
                factorial.add(divisor);
            }
        }
        Collections.sort(factorial, Collections.reverseOrder());
        System.out.println(factorial.get(0));
    }
}