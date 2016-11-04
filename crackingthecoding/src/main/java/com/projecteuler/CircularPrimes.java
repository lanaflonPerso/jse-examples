package main.java.com.projecteuler;

import java.util.Arrays;

/**
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 * How many circular primes are there below one million?
 */
public class CircularPrimes {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        permute(0, a);
    }

    public static void permute(int start, int[] input) {
        if (start == input.length) {
            int number = Integer.parseInt(Arrays.toString(input).replaceAll("\\[|\\]|,|\\s", ""));
            System.out.print(number);
            System.out.println("");
            return;
        }
        for (int i = start; i < input.length; i++) {
            // swapping
            int temp = input[i];
            input[i] = input[start];
            input[start] = temp;
            // swap(input[i], input[start]);

            permute(start + 1, input);
            // swap(input[i],input[start]);

            int temp2 = input[i];
            input[i] = input[start];
            input[start] = temp2;
        }
    }


}
