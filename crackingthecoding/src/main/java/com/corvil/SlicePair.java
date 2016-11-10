package com.corvil;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. A slice of that array is a pair of integers (P, Q) such that 0 , P , Q c N.
 * Integer P is called the beginning of the slice; Integer Q is called the end of the slice. The number Q - P + 1 is called the size of the slice.
 * A slice (P, Q) of array A is called ascending if the corresponding items form a strictly increasing sequence: A[Pl< A[P+1]< ...< A[Q-1]< A[Q].
 *
 * Note that we consider a slice (P, P) consisting of one element to be ascending. For example, consider array A such that:
 *
 * A[0] = 2, A[1] = 2, A[2] = 2, A[3] = 2, A[4] = 1, A[5] = 2, A[6] = -1, A[7] = 2, A[8] = 1, A[9] = -3
 *
 * Pair (0, 3) is a slice of array A of size 4 that is not ascending. Pair (2, 2) is a slice of size 1 that is ascending. Pair (4, 5) is a slice of size 2
 * that is ascending. Pairs (6, 7) and (8, 9) are other slices of size 2
 * that are ascending. There is no slice of array A that is ascending and has size greater than 2.
 *
 * Write a function:
 *
 * class MinNoSearch { public int solution (int[] A); }
 *
 * that, given a zero-indexed array A consisting of N integers, returns the beginning of any ascending slice of A of maximal size.
 * For instance, in the above example the function may return 4, 6 or 8 as explained above. For the following array A consisting of N = 3
 * elements: A[0] = 30, A[1] = 20, A[2] = 10 the function may return 0,1 or 2, because all ascending slices of this array have size 1.
 *
 * Assume that
 *       N is an integer within the range [1..150,000];
 *       each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
 *
 * Complexity:
 *      expected worst-case time complexity is 0(N);
 *      expected worst-case space complexity is 0(6), beyond input storage (not counting the storage required for input arguments).
 *
 */
public class SlicePair {
    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 1, 2, -1, 2, 1, 3};
        System.out.println(new SlicePair().maxSlice(A));


        int[] B = {30, 20, 10};
        System.out.println(new SlicePair().maxSlice(B));

    }

    public static int maxSlice(final int[] x) {

        int maxPair = 1;
        int maxPairStart = 0;

        int currentSize = 1;
        int currentStart = 0;
        for (int i = 0; i < x.length -1; i++) {
            if (x[i] < x [i+1]) {
                currentSize++;
                if (currentSize > maxPair ) {
                    maxPair++;
                    maxPairStart = currentStart;
                }
            } else {
                currentSize = 1;
                currentStart = i + 1;
            }
        }
        return maxPairStart;
    }
}
