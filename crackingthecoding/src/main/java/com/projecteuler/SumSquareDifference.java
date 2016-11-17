package main.java.com.projecteuler;

/**
 * The sumOfAll of the squares of the first ten natural numbers is,
 * <p>
 * square(1) + square(2) + ... + square(10) = 385
 * The square of the sumOfAll of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sumOfAll of the squares of the first ten natural numbers and the square of the sumOfAll is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sumOfAll of the squares of the first one hundreth natural numbers and the square of the sumOfAll.
 */
public class SumSquareDifference {
    public static void main(String...args) {
        System.out.println(squareOfSumOfNumber(10) - sumOfSquareOfNumber(10));
        System.out.println(squareOfSumOfNumber(100) - sumOfSquareOfNumber(100));

    }

    public static int squareOfSumOfNumber(int n) {
        // sumOfAll of n number n(n+1)/2
        int number = (n * (n + 1)) / 2;
        return number * number;
    }

    public static int sumOfSquareOfNumber(int n) {
        // sumOfAll of square of n number formula [n(n+1)(2n+1)]/6
        return (n * (n + 1) * (2 * n + 1)) / 6;
    }
}
