package com.amazon;

public class Solution {
    public static void main(String...args) {

        double[] d = new double[]{1.0, 0.1, -1.0, -7.0, 3.0, -5.0, -2.5, 0.0, 1};
        System.out.println(new Solution().solution(d));
    }

    public static double solution(double a[]) {
        double max = a[0];
        for (int i = 0; i < a.length; i++) {
            double productOfLine = 1.0d;
            for (int j = i; j < a.length; j++) {
                if (a[j] == 0.0d) {
                    break;
                }
                productOfLine *= a[j];
                if (productOfLine > 100000000) {
                    return 100000000;
                }
                if (max < productOfLine) {
                    max = productOfLine;
                }
            }
        }
        return max;
    }
}
