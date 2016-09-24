package com.org.puzzle;

public class CurseOfLooper {
    public static void main(String...args) {
        referenceCompare();
    }

    public static void referenceCompare() {
        System.out.println(new Integer(0) == new Integer(0));
    }

    public void infiniteLoop() {
        int i = 0, j = 0;
        while (i <= j && j <= i && i != j) {
            System.out.println(i);
            System.out.println(j);
        }
    }

}