package main.java.com.crackingthecode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ehimnay on 28/09/2016.
 */
public class MergeSort {
    public static void main(String...args) {
        int[] array = { 8, 3, 123, 0, 77, 5, 9, 2, 8, 10, 6, 1, 4, -1 };
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        final List<Integer> list =  Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(list);
    }

    public static void mergeSort(int[] array, int[] helper, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            mergeSort(array, helper, startIndex, mid);
            mergeSort(array, helper, mid + 1, endIndex);
            merge(array, helper, startIndex, mid, endIndex);
        }
    }

    public static void merge(int[] array, int[] helper, int low, int middle, int high) {
        /* Copy both halves into a helper array */
        for (int i = low; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperleft = low;
        int helperRight = middle + 1;
        int current = low;

        /*
         * Iterate through helper array. Compare the left and right half, copying back the smaller element from the two
         * halves into the original array.
         */
        while (helperleft <= middle && helperRight <= high) {
            if (helper[helperleft] <= helper[helperRight]) {
                array[current] = helper[helperleft];
                helperleft++;
            } else {//If right element is smaller than left element
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* Copy the rest of the left side of the array into the target array */
        int remaining = middle - helperleft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperleft + i];
        }
    }
}
