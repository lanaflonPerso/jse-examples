package main.java.com.crackingthecode;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other.
 */
public class PermutationOfStrings {
    public static void main(String...args) {
        String str1 = "Himansu";
        String str2 = "usnamiH";
        if (isOnePermutationOfOtherUsingSorting(str1, str2)) {
            System.out.println("Sorting : One is Permutation of other string.");
        } else {
            System.out.println("Sorting : One is not Permutation of other string.");
        }

        if (isOnePermutationOfOtherUsingCount(str1, str2)) {
            System.out.println("Count : One is Permutation of other string.");
        } else {
            System.out.println("Count : One is not Permutation of other string.");
        }
    }

    public static boolean isOnePermutationOfOtherUsingSorting(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        return Arrays.equals(sort(str1), sort(str2));
    }

    public static char[] sort(String str) {
        final char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return charArray;
    }

    public static boolean isOnePermutationOfOtherUsingCount(final String str1, final String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        final int[] ascii = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            int asciiChar = str1.charAt(i);
            ascii[asciiChar]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int asciiChar = str2.charAt(i);
            ascii[asciiChar]--;
            if (ascii[asciiChar] < 0) {
                return false;
            }
        }
        return true;
    }
}
