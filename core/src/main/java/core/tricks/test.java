package core.tricks;

import java.util.Scanner;

/**
 * Created by ehimnay on 20/07/2016.
 */
public class test {
    public static void main(String...args) {
        int[] A = { 1, 2, 3, 4, 5, 6 };
        solution(A, 2);
    }

    public static void solution(int[] A, int K) {
        int index = 0, count = 0;
        while (index <= K && count < A.length) {
            index++;
            System.out.print(A[count++]);
            if (index == K) {
                index = 0;
                drawbox(3);
                System.out.println();
            }
        }
    }

    public static void drawbox(int size) {
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                if (row == 0 || row == size - 1) {
                    System.out.print("*");
                    if (row == size - 1) {
                        System.out.println();
                    }
                } else {
                    if (col == size - 1 || col == 0) {
                        System.out.print("*");
                        if (row == size - 1) {
                            System.out.println();
                        }
                    } else {
                        //call the solution() here
                        if (row == size - 1) {
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
