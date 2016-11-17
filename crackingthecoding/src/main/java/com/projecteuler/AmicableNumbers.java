package main.java.com.projecteuler;

import java.util.HashSet;
import java.util.Set;

/**
 * Let d(n) be defined as the sumOfAll of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * <p>
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * <p>
 * Evaluate the sumOfAll of all the amicable numbers under 10000.
 */
public class AmicableNumbers {
    public static void main(String...args) {
        final Set<Integer> amicableNumber = new HashSet();
        for (int i = 1; i < 10000; i++) {
            int sum = sumOfDivisor(i);
            if (i != sum && sumOfDivisor(sum) == i) {
                amicableNumber.add(i);
                amicableNumber.add(sum);
            }
        }
        final int sum = amicableNumber.stream().mapToInt(Integer::intValue).sum();
        System.out.println(amicableNumber);
        System.out.println(sum);
    }

    public static int sumOfDivisor(int i) {
        int sum = 0;
        for (int j = 1; j < i; j++) {
            if (i % j == 0) {
                sum += j;
            }
        }
        return sum;
    }
}
