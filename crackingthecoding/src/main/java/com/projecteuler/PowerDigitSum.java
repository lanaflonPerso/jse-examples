package main.java.com.projecteuler;

/**
 * 2^15 = 32768 and the sumOfAll of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * <p>
 * What is the sumOfAll of the digits of the number 2^1000?
 */
public class PowerDigitSum {

    public static void main(String...args) {
        int power = (int) Math.pow(2.0, 1000.0);
        System.out.println(sumOfNumber(power));
    }

    public static int sumOfNumber(int n) {
        int sum = 0;
        while (n >= 1) {
            sum += +n % 10;
            n = n / 10;
        }
        return sum;
    }
}
