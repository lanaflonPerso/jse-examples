package com.projecteuler.puzzle;

/**
 * The sum of the squares of the first ten natural numbers is,
 * <p>
 * square(1) + square(2) + ... + square(10) = 385
 * The square of the sum of the first ten natural numbers is,
 * <p>
 * (1 + 2 + ... + 10)2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * <p>
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class SumSquareDifference {
    public static void main(String[] args) {
        System.out.println(squareOfSumOfNumber(10) - sumOfSquareOfNumber(10));
        System.out.println(squareOfSumOfNumber(100) - sumOfSquareOfNumber(100));

    }

    public static int squareOfSumOfNumber(int n){
        // sum of n number n(n+1)/2
        int number = (n*(n+1))/2;
        return number * number;
    }

    public static int sumOfSquareOfNumber(int n){
        // sum of square of n number formula [n(n+1)(2n+1)]/6
        return (n*(n+1)*(2*n+1))/6;
    }
}
