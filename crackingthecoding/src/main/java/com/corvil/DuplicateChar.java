package com.corvil;

import java.util.Arrays;

/**
 * find if a string has all unique characters without using any additional data structure
 */
public class DuplicateChar {
    public static void main(String...args) {
        System.out.println(new DuplicateChar().isUniqueUsingSorting("Himansu Himansu"));
    }

    public boolean isUniqueUsingSorting(String string) {
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
