package com.synchronoss;

/**
 * Let's define the largest range of a finite ordered collection x as the max value of x - x where a < b and x > x
 * where a and b are positions of an individual element in x. For example, if x = {1,4,8} it implies that x =1, x =4,x =8.
 * Here the largest range is x -x =7 with a < b since a=1 and b=3. Please implement the function largestRange.
 * Implement it to return largest range for x as described above.
 * If no such number exists (e.g.: if x < x for all a > b), result should be -1.
 *
 * Input Format
 *  You do not need to worry about processing standard input as that is already implemented, so you just need to focus
 *  on the function that does the calculation. The first line contains Z (the number of elements in collection x).
 *  The Z subsequent lines each contain an ordered value of x; the i line of input (where 0 < i < Z-1) contains element x .
 *
 *  Constraints
 *      1 ≤ Z ≤ 10
 *      −10 ≤ x ≤ 10 ∀ i ∈ [0, Z-1]
 *
 *  Output Format
 *      Your largestRange function should return the largest range in parameter x. Printing to stdout is handled for you
 *      by the locked code in the editor.
 */
public class LargestRangeBetweenOrderedCollection {
    public static void main(String...args) {
        System.out.println(largestRange(new int[] {2, 3, 10, 2, 4, 8 , 1}));
        System.out.println(largestRange(new int[] {7, 9, 5, 6, 3, 2 }));
    }

    public static int largestRange(final int [] x) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minx = Integer.MAX_VALUE;
        for (int i = 0; i < x.length; i++) {
            if (min > x[i]) {
                min = x [i];
            }
            if (max <= x[i]) {
                max = x[i];
                minx = min;
            }
        }
        if (minx < max) {
            return max - minx;
        }
        return -1;
    }

}
