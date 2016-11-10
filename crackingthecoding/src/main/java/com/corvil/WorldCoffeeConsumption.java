package com.corvil;

/**
 * The goal of this task is to write a program that outputs average yearly coffee consumption per-person (in liters)
 * across all people living in a given set of countries.
 *
 * Program has two inputs:
 *
 * an array containing average yearly coffee consumption (in liters) per-person in each country (none of the values
 * exceeds 1 000 000) an array containing population of each country (the total population of all countries doesn’t
 * exceed 8 000 000 000)
 *
 * The two input arrays have the same length and the order of countries in both arrays is the same. The number of
 * countries does n’t exceed 200.
 *
 * Output is a single number: average yearly per-person coffee consumption (in liters) across all people in all given
 * countries.
 *
 * Examples: {1}, {1} => 1 {0, 1000}, {999, 1} => 1
 *
 * 999 * 0 + 1 * 1000/ (0 + 1000)
 */
public class WorldCoffeeConsumption {
    public static void main(String[] args) {
        int[] a = { 1 };
        int[] b = { 1 };
        System.out.println(new WorldCoffeeConsumption().solution(a, b));
    }

    public long solution(int[] a, int[] b) {
        long numerator = 0;
        long denominator = 0;
        for (int i = 0; i < a.length; i++) {
            numerator += (a[i] * b[i]);
            denominator += a[i];
        }
        return numerator / denominator;
    }
}
