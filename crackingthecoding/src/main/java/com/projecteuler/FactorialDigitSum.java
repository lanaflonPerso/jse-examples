package main.java.com.projecteuler;

/**
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * <p>
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sumOfAll of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * <p>
 * Find the sumOfAll of the digits in the number 100!
 */
public class FactorialDigitSum {
    public static void main(String...args) {
        long sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum = sum + factorial(i);
        }
        System.out.println(sumOfDigits(sum));
    }

    public static long factorial(int n) {
        long sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        System.out.println(sum);
        return sum;
    }

    public static long sumOfDigits(long n) {
        long sum = 0;
        while (n >= 1) {
            sum = sum + n % 10;
            n = n / 10;
        }
        return sum;
    }
}
