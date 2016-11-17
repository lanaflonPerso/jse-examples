package main.java.com.projecteuler;

import java.util.*;

/**
 * The prime 41, can be written as the sumOfAll of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sumOfAll of consecutive primes that adds to a prime below one-hundred.
 * 
 * The longest sumOfAll of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to
 * 953.
 * 
 * Which prime, below one-million, can be written as the sumOfAll of the most consecutive primes?
 */
public class ConsecutivePrimeSum {
    public static void main(String[] args) {
        System.out.println(consecutivePrimeSum(100_000));
    }

    public static Long consecutivePrimeSum(int n) {
        List<Integer> consecutivePrime = new ArrayList<>();
        List<Long> primeSum = new ArrayList<>();
        long consecutivePrimeSum = 0;
        long sum = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                sum += i;
                consecutivePrime.add(i);
                primeSum.add(sum);

            }
        }
        System.out.println(primeSum);
        System.out.println(consecutivePrime);

        Collections.reverse(consecutivePrime);
        for (Integer prime : consecutivePrime) {
//            System.out.println(consecutivePrimeSum + " " + prime);
            if (isPrime(consecutivePrimeSum) && consecutivePrimeSum <= n) {
                return consecutivePrimeSum;
            }
            consecutivePrimeSum -= prime;
        }
        return consecutivePrimeSum;
    }

    public static boolean isPrime(long n) {
        int i = 2;
        for (; i <= n; i++) {
            if (n % i == 0) {
                break;
            }
        }
        if (i == n) {
            return true;
        }
        return false;
    }

}
