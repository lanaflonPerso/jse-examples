package com.crackingthecode;

import java.util.Arrays;

/**
 * Implement an algorithm to determine if a string has all unique characters. What if you
 * cannot use additional data structures?
 */
public class UniqueCharInAString {
    public static void main(String...args) {
        final String test = "Himansu";

        if (isUniqueUsingASCII(test)) {
            System.out.println("ASCII : String has unique character");
        } else {
            System.out.println("ASCII : String do not have unique character");
        }

        if (isUniqueUsingBruteForce(test)) {
            System.out.println("Brute Force : String has unique character");
        } else {
            System.out.println("Brute Force : String do not have unique character");
        }

        if (isUniqueUsingSorting(test)) {
            System.out.println("Sorting : String has unique character");
        } else {
            System.out.println("Sorting : String do not have unique character");
        }
    }

    public static boolean isUniqueUsingASCII(String string) {
        if (string.length() > 128) {
            return false;
        }
        boolean char_set[] = new boolean[128];
        for (int i = 0; i < string.length(); i++) {
            int charAt = string.charAt(i);
            if (char_set[charAt]) {
                return false;
            }
            char_set[charAt] = true;
        }
        return true;
    }

    public static boolean isUniqueUsingBruteForce(String string) {
        if (string.length() > 128) {
            return false;
        }
        int size = string.length();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (string.charAt(i) == string.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUniqueUsingSorting(String string) {
        if (string.length() > 128) {
            return false;
        }
        char[] charArray = string.toCharArray();
        Arrays.sort(charArray);
        int size = charArray.length;
        for (int i = 0; i < size; i++) {
            if (i < size - 1 && charArray[i] == charArray[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
