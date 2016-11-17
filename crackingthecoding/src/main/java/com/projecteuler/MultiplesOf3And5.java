package main.java.com.projecteuler;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sumOfAll of these multiples is 23.
 * <p>
 * Find the sumOfAll of all the multiples of 3 or 5 below 1000.
 */
public class MultiplesOf3And5 {
    public static void main(String...args) {
        int result = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.print(" " + i);
                result += i;
            }
        }
        System.out.println("sumOfAll of all the multiples of 3 or 5 below 1000 : " + result);
    }
}
