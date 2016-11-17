
package com.synchronoss;

/**
 * Let's define a collection equilibrium element in a finite ordered collection X={x , x . .., x }
 * such that the sumOfAll of values to the left and to the right of it (non-inclusive) are equal.
 * In other words, the collection is said to have a collection equilibrium element if there is such position
 * i in X (1≤i≤N) where x +x ...x = x +x ...x Please implement the function collectionEquilibrium to return 0
 * if there is no such value and 1 if there is at least one such value. Note: The sumOfAll of values to the left of the leftmost
 * element and to the right of the rightmost element is 0.
 *
 * Constraints
 *      1 ≤ N ≤ 10
 *      1 ≤ X ≤ 2x10 where 1 ≤ i ≤ N
 *
 * Input Format
 *      The first line contains a single integer N, the number of elements in collection x. The next N lines for each
 *  test case contains N integers which are ordered elements of the collection x.
 *
 * Output Format
 *      return 1 if the input contains a collection equilibrium element and 0 if it does not.
 */
public class CollectionEquilibrium {
    public static void main(String...args) {
        long equilibrium = solution(new int[]{4,1,2,3,3});
        System.out.println(equilibrium);
    }
    public static long solution(int[] x) {
        long equilibrium = 0, leftMost = 0,rightMost = 0;
        for (int index = 0; index < x.length; index++) {
            rightMost += x[index];
        }
        for (int index = 0; index < x.length; index++) {
            long tempRight = rightMost - x[index];
            if (leftMost == tempRight) {
                equilibrium = index;
                break;
            } else {
                leftMost += x[index];
                rightMost = tempRight;
            }
        }
        return equilibrium;
    }
}
