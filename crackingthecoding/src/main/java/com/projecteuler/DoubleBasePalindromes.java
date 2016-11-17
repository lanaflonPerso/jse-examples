package main.java.com.projecteuler;

/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases. Find the sumOfAll of all numbers, less than
 * one million, which are palindromic in base 10 and base 2. (Please note that the palindromic number, in either base,
 * may not include leading zeros.)
 */
public class DoubleBasePalindromes {
    public static void main(String[] args) {
        long sum = 0;
        // only odd cannot end with zero
        for (int i = 1; i < 10_00_000; i += 2) {
            if (isPalindrome(Integer.toBinaryString(i)) && isPalindrome(Integer.toString(i))) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static boolean isPalindrome(String number) {
        return number.equals(new StringBuffer(number).reverse().toString());
    }

}
