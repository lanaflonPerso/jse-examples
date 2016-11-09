package com.corvil;

/**
 * You are given a non-empty string S consisting of N characters. In this problem we consider only strings that consist of lower-case English letters (a-z)
 * and spaces.
 *
 * S can be divided into words by splitting it at the spaces and removing them. We want to reverse every word in S.
 *
 * For example, given S = "we test coders'', there are three words: and "coders". Reversing the words gives and "sredoc".
 *
 * The goal is to return a string with every word in string S reversed and separated by spaces, so the result in the above example should be "ew tset sredoc".
 * You can assume that if there are K spaces in S then there are exactly K +1 words.
 *
 * Write a function:
 *          Class function MinNoSearch { Public String MinNoSearch(String S); }
 *
 * that, given a non-empty string S consisting of N characters, returns the reversal of every word of S.
 * For example, given S = "we test coders'', the function should return "ew tset sredoc", as explained above.
 *
 * Assume that
 *
 *          the length of S is within the range [1..100];
 *          string S consists only of lowercase letters (a-z)
 *
 */
public class SentenceReverse {

    public static void main(String[] args) {
        System.out.println(new SentenceReverse().reverse("Himansu Nayak"));
    }

    public static String reverse(String s) {
        final StringBuilder sb = new StringBuilder();
        for(final String word : s.split(" ")) {
            sb.append(new StringBuilder(word).reverse());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

}
