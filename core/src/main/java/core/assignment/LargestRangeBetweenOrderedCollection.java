package core.assignment;

/**
 * Created by ehimnay on 03/09/2016.
 */
public class LargestRangeBetweenOrderedCollection {
    public static void main(String[] args) {
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
