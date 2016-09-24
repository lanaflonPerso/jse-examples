package core.tricks;

import java.util.Arrays;

public class ArrayBox {
    public static void main(String...args) {
        int[] A = { 1111, 3212, 13, 65433334, 65433211, 1234321 };
        drawRow(A, 2);
        solution(A, 2);
    }

    public static void drawRow(int[] A, int K) {
        int index = 1, count = 0;
        System.out.print("+");
        while (index <= K && count < A.length) {
            index++;
            int dashCount = Integer.toString(A[count++]).length();
            for (int i = 1; i <= dashCount; i++) {
                System.out.format("-");
            }
            System.out.print("+");
        }
        System.out.println();
    }

    public static void solution(int[] A, int K) {
        int index = 0, count = 0;
        while (index <= K && count < A.length) {
            index++;
            System.out.print("|");
            System.out.print(A[count++]);
            if (index == K) {
                index = 0;
                System.out.print("|");
                System.out.println();
                drawRow(Arrays.copyOfRange(A, K, A.length), K);
            }

        }
    }
}
