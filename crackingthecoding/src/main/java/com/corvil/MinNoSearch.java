package com.corvil;

/**
 * Write a function:
 *          class MinNoSearch { public int solution(int I, A); }
 *
 * that, given a non-empty zero-indexed array A of N integers, returns the minimum value from array A:
 *          min { A[i] : 0 A i < N }
 *
 * For example, given:
 *     A[0] = 1, A[1] = 2, A[2] = 3, A[3] = 42, A[4] = 1, A[5] = -10
 *
 * your function should return -10.
 *
 * Assume that:
 *      NO an integer within the range [1_100,0001;
 *      each element of array A is an integer within the range 1-2,147,483,698..2,142,483,642].
 *
 * Complexity:
 *      expected worst-case time complexity is 0(N);
 *      expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 *
 * Elements of input arrays can be modified.
 */
class MinNoSearch {

    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 42, 1, -10};
        System.out.println(new MinNoSearch().solution(A));

        int[] B = new int[] {-2147483648, 0, -999, 23, 2147483647, 3, 42, 1, -10};
        System.out.println(new MinNoSearch().solution(B));
    }

    public int solution(int[] A) {

        int smallest = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < smallest) {
                smallest = A[i];
            }
        }
        return smallest;
    }
}
