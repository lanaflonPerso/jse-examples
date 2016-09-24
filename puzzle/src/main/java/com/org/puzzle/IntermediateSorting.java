package com.org.puzzle;

public class IntermediateSorting {
    public static void main(String...args) {
        int[] A = { 1, 2, 3, 4, 7, 8, 9, 10 };
        final int noOfPass = solution(A);
        System.out.println("No of pass : " + noOfPass);
    }

    public static int solution(int[] A) {
        int counter, index, pass = 1;
        final int sizeOfArray = A.length;
        boolean flag = true, check =true;
        for (index = 0; index < sizeOfArray - 1; index++) {
            if (flag) {
                flag = false;
                for (counter = 0; counter < sizeOfArray - 1; counter++) {
                    if (A[counter] > A[counter + 1]) {
                        swap(A, counter);
                        flag = true;
                        pass++;
                        check = false;
                    }
                }
                display(A);
            }
        }
        return check ? --pass : pass;
    }

    public static void swap(final int[] A, final int counter){
        A[counter] = A[counter] + A[counter + 1];
        A[counter + 1] = A[counter] - A[counter + 1];
        A[counter] = A[counter] - A[counter + 1];
    }

    public static void display(final int[] A){
        for (int counter = 0; counter < A.length; counter++) {
            System.out.print(A[counter] + " ");
        }
        System.out.println();
    }
}
