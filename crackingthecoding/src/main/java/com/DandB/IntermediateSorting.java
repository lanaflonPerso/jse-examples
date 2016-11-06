package com.DandB;

public class IntermediateSorting {
    public static void main(String... args) {
        int[] A = {1, 2, 3, 4, 7, 8, 9, 10};
        final int noOfPass = bubblesort(A);
        System.out.println("No of pass : " + noOfPass);
    }

    private static int bubblesort(int[] nums) {
        boolean done = false;
        int pass = 1;
        for (int i = 0; i < nums.length && !done; i++) {
            done = true;
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    done = false;
                    pass++;
                }
            }
        }
        display(nums);
        return done ? --pass : pass;
    }

    public static void display(final int[] A) {
        for (int counter = 0; counter < A.length; counter++) {
            System.out.print(A[counter] + " ");
        }
        System.out.println();
    }
}
