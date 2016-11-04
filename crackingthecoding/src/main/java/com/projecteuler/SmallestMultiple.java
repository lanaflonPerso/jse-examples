package main.java.com.projecteuler;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class SmallestMultiple {
    public static void main(String...args) {
        for (int i = 2; ; i++) {
            boolean isDivisible = true;
            for (int j = 1; j <= 20; j++) {
                if (i % j != 0) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                System.out.println(i);
                break;
            }
        }
    }
}
