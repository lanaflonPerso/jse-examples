package main.java.com.projecteuler;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * <p>
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * <p>
 * Using the rule above and starting with 13, we generate the following sequence:
 * <p>
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * <p>
 * Which starting number, under one million, produces the longest chain?
 * <p>
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class LongestCollatzSequence {
    public static void main(String...args) {
        int size = 0, number = 1;
        for (int i = 1; i < 1_0_00_000; i++) {
            int a = countCollatzSequence(i);
            if (a > size) {
                size = a;
                number = i;
            }
        }
        System.out.println(number + " produces longest chain " + size);
    }

    public static int countCollatzSequence(int n) {
        int count = 1;
        while (n > 1) {
            n = (n % 2 == 0) ? n / 2 : (3 * n) + 1;
            count++;
        }
        return count++;
    }

}
