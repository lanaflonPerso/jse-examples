package com.citi;

/**
 * You have an array of numbers and you would like to print these numbers in a tabular format to make them look more
 * organized. Each cell of the table contains exactly one number and is surrounded by exactly four edges:
 *
 *              +-+
 *              |4|
 *              +-----+
 *              +12345|
 *              +-----+
 *
 * As you can see above, each corner of the cell is represented by a sign "+", vertical edges by "-" signs and
 * horizontal edges by "I". signs. The width of the cell adjusts to accommodate the number of digits of the number
 * written within it. There can be many cells in a row. Adjacent cells share an edge:
 *
 *              +-+-+-+-+-+-+
                |4|35|80|123|
 *              +-+--+--+---+
 *
 * Note that each cell has the same width. The width of the cell adjusts to match the width at 151 longest number in the
 * table. The numbers in cells are aligned to the right, with any unused area in each cell filled with spaces.
 *
 * The table can consist of many rows, and adjacent rows share an edge:
 *
 * Your goal is to output a table containing all the numbers from a given array such that each row contains exactly K numbers.
 * The last row can contain fewer numbers.
 *
 * Write a function:
 *          class Solution { public void solution(int[] A, int K); }
 *
 * that, given a nor-empty array A consisting of N integers and an integer K, prints a string representing the formatted array.
 * The numbers in the table should appear in the same order as the numbers in the array.
 *
 * *
 */

class PrintNumberTabular {
    public static void main(String...args) {
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 1);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 2);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 3);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 4);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 5);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 6);
        printTable(new int[] { 1, 10, 1000, 10000, 10, 12 }, 7);

    }

    public static void printTable(int[] vals, int widthIn) {

        int width;

        if (vals.length < widthIn) {
            width = vals.length;
        } else {
            width = widthIn;
        }

        int fullRaws = vals.length / width;
        int halfRaws = vals.length % width;

        int maxWidth = 0;

        for (int i = 0; i < vals.length; i++) {
            if (maxWidth < ("" + vals[i]).length()) {
                maxWidth = ("" + vals[i]).length();
            }

        }

        maxWidth += 2;

        int[] row = new int[width];
        for (int i = 0; i < fullRaws; i++) {
            for (int j = 0; j < width; j++) {
                row[j] = vals[i * width + j];
            }
            if (i != fullRaws - 1) {
                printLine(maxWidth, row, true, false);
            } else {
                printLine(maxWidth, row, true, true);
            }

        }

        if (halfRaws > 0) {
            int[] halfRow = new int[halfRaws];
            int j = 0;
            for (int i = vals.length - halfRaws; i < vals.length; i++) {
                halfRow[j++] = vals[i];
            }
            printLine(maxWidth, halfRow, false, true);

        }

        System.out.println();
    }

    public static void printLine(int width, int[] vals, boolean drawFirst, boolean drawLast) {

        if (drawFirst) {
            drawLine(width, vals.length);
        }
        System.out.println();
        for (int i = 0; i < vals.length; i++) {
            for (int j = 0; j < width - 1 - (("" + vals[i]).length()); j++) {
                if (j == 0) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print(vals[i]);

        }
        System.out.print("|");

        System.out.println();

        if (drawLast) {
            drawLine(width, vals.length);
        }

    }

    private static void drawLine(int width, int cells) {
        for (int i = 0; i < cells; i++) {
            for (int j = 0; j < width - 1; j++) {
                if (j == 0) {
                    System.out.print("+");
                } else {
                    System.out.print("-");
                }
            }
        }

        System.out.print("+");
    }
}