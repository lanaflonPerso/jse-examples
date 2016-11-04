package main.java.com.projecteuler;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class LargestPalindromeProduct {
    public static void main(String...args) {
        int product = 0;
        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j <= 999; j++) {
                if (isPalindrome(i * j) && i * j > product) {
                    product = i * j;
                }
            }
        }
        System.out.println(product);
    }

    public static boolean isPalindrome(int number) {
        int actualNumber = number;
        int reverseNumber = 0;
        while (number >= 1) {
            int digit = number % 10;
            reverseNumber = reverseNumber * 10 + digit;
            number = number / 10;
        }
        return actualNumber == reverseNumber;
    }
}
