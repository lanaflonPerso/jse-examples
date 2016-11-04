package main.java.com.projecteuler;

import java.util.Arrays;

/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 * <p>
 * 012   021   102   120   201   210
 * <p>
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class LexicographicPermutations {
    static int count = 0;

    public static void main(String...args) {
        int[] arr = {0, 1, 2, 3};
        permute(arr, 0);
    }

    public static void permute(int[] arr, int i) {
        // base condition
        if (i == arr.length) {
            System.out.println(count + " " + Arrays.toString(arr));
            return;
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr, i, j);
            permute(arr, i + 1);  // recurse call
            swap(arr, i, j);      // backtracking
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
