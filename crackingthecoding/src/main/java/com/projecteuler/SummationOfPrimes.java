package main.java.com.projecteuler;

/**
 * The sumOfAll of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * <p>
 * Find the sumOfAll of all the primes below two million.
 */
public class SummationOfPrimes {
    public static void main(String...args) {
        System.out.println(sumOfNthPrimeNumber(2_0_00_000));
    }

    public static long sumOfNthPrimeNumber(final int n) {
        long sum = 0;
        for (int i = 2; i < n; i++) {
            int flag = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    flag = j;
                    break;
                }
            }
            if (i == flag) {
                sum += i;
            }
        }
        return sum;
    }
}
