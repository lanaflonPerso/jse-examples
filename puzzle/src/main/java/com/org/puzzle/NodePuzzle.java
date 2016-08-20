package com.org.puzzle;

public class NodePuzzle {
    public static void main(String...args) {
        final int[] a = { 1, 4, -1, 3, 2 };
        System.out.println(solution(a));
    }

    public static int solution(final int[] a) {
        int index = 0, length = 0;
        while (index != -1) {
            index = a[index];
            length++;
        }
        return length;
    }

}
