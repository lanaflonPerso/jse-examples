package main.java.com.projecteuler;

import java.util.ArrayList;
import java.util.List;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */
public class _10001stPrime {
    public static void main(String...args) {
        System.out.println(nthPrimeNumber(10001));
    }

    public static int nthPrimeNumber(final int n) {
        final List<Integer> primeList = new ArrayList<>();
        for (int i = 2; primeList.size() <= n; i++) {
            int flag = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    flag = j;
                    break;
                }
            }
            if (i == flag) {
                primeList.add(i);
            }
        }
        return primeList.get(n - 1);
    }
}
