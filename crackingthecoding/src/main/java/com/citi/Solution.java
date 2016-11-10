package com.citi;
/**
 * You have an array of numbers and you would like to print these numbers in a tabular format to make them look more
 * organized. Each cell of the table contains exactly one number and is surrounded by exactly four edges:
 *
 *              +-+
 *              |4|
 *              +-----+
 *              +12345\
 * 1123451 + + As you can see above, each corner of the cell is represented by a sign, vertical edges by •-• signs and
 * horizontal edges by • I. signs. The width of the cell adjusts to accommodate the number of digits of the number
 * written within A There can be many cells Ill row. Adjacent cells share an edge: + + + + + 1 41 al 1 1011231 + + + + +
 * Note that each cell has the same width. The width of the cell adjusts to match the width at 151 longest number in the
 * table. The numbers in cells are aligned to the right, with any unused area in each cell filled with spaces. The table
 * can consist of many rows, and adjacent rows share an edge:
 *
 *
 *
 *
 * 
 */

class PrintNumberTabular {
    public static void main(String[] args) {

    }

        public static void printTable(int[] vals, int width) {

                int fullRaws = vals.length / width;
                int halfRaws = vals.length % width;

                int maxWidth = 0;

                for (int i = 0; i < vals.length; i++) {
                        if (maxWidth < ("" + vals[i]).length()) {
                                maxWidth = ("" + vals[i]).length();
                        }

                }

                maxWidth+=2;

                int[] row = new int[width];
                for (int i = 0; i <= fullRaws; i++) {
                        for (int j = 0; j < width; j++) {
                                row[j] = vals[i + j];
                        }
                        if (i != fullRaws) {
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