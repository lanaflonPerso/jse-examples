package main.java.com.projecteuler;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sumOfAll of all numbers which are equal to the sumOfAll of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class DigitFactorials {
    public static void main(String...args) {
        // 9999999 bcoz 9! lead to 6 digit. 9! + 8! will make a 7 digit no.
        digitFactorials();
    }

    public static void digitFactorials() {
        long sumOfNo = 0;
        for (int i = 3; i <= 9999999; i++) {
            int sum = 0, ii = i;
            while (ii > 0) {
                int digit = ii % 10;
                ii = ii / 10;
                sum += factorial(digit);
            }
            if (sum == i) {
                sumOfNo += i;
            }
        }
        System.out.println(sumOfNo);
    }

    public static long factorial(int x) {
        if (x == 0) {
            return 1;
        }
        int y = x;
        for (int i = 1; i < x; i++) {
            y *= i;
        }
        return y;
    }
}
