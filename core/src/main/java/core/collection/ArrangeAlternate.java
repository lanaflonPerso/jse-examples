package core.collection;

public class ArrangeAlternate {
    public static void main(String...args) {
        int[] array = { 1, 3, 5, 7, 2, 4, 6, 8 };
        interleave(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void interleave(int[] array) {
        int i = 0;
        int j = 0;
        int mid = (array.length / 2) - 1;// points the end of first half

        // the outer loop runs for (length/2) - 1 times
        for (i = 0; i < mid; i++) {
            // runs for (i+1) times
            for (j = 0; j <= i; j++) {
                // calculate the indices to be swapped
                int l = mid - i + (2 * j);
                int r = mid - i + (2 * j) + 1;

                // swap the elements at left (l) and right (r)
                int temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

    }
}