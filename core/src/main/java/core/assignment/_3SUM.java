package core.assignment;

import java.util.Arrays;

public class _3SUM {

    public static void main(String...args) {
        int values[] = { 1, 7, 2, 3, 11, 4 };
        System.out.println(sumsTo(values));
    }

    public static int sumsTo(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length - 1; ++i) {
            for (int j = i + 1; j < values.length; ++j) {
                for (int k = j + 1; k < values.length; ++k) {
                    sum = values[i] + values[j] + values[k];
                    if (Arrays.binarySearch(values, sum) > 0) {
                        System.out.println("Numbers are : " + values[i] + " " + values[j] + " " + values[k]);
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}