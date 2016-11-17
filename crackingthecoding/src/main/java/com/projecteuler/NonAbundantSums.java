package main.java.com.projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A perfect number is a number for which the sumOfAll of its proper divisors is exactly equal to the number. For example, the sumOfAll of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * <p>
 * A number n is called deficient if the sumOfAll of its proper divisors is less than n and it is called abundant if this sumOfAll exceeds n.
 * <p>
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sumOfAll of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sumOfAll of two abundant numbers. However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot be expressed as the sumOfAll of two abundant numbers is less than this limit.
 * <p>
 * Find the sumOfAll of all the positive integers which cannot be written as the sumOfAll of two abundant numbers.
 */
public class NonAbundantSums {
    public static void main(String...args) {
        final List<Integer> abundantNumber = new ArrayList<>();
        for (int i = 1; i <= 28123; i++) {
            int sum;
            if ((sum = sumOfAllDivisor(i)) > i) {
                abundantNumber.add(sum);
            }
        }
        final int sum = sumOfIntegers(sumOf2AbundantNumber(abundantNumber));
        System.out.println(sum);
    }

    public static int sumOfAllDivisor(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static Set<Integer> sumOf2AbundantNumber(List<Integer> abundantNumber) {
        final Set<Integer> integers = new HashSet<>();
        for (int i = 0; i < abundantNumber.size(); i++) {
            for (int j = i + 1; j < abundantNumber.size(); j++) {
                integers.add(abundantNumber.get(i) + abundantNumber.get(j));
            }
        }
        return integers;
    }

    public static int sumOfIntegers(Set<Integer> set){
        int sum = 0;
        for(int i = 1; i <= 28123; i++){
            sum += set.contains(i) ? 0 : i;
        }
        return sum;
    }
}
