package main.java.com.crackingthecode;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome. A palindrome is a word or phrase
 * that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to
 * be limited to just dictionary words.
 */
public class PalindromePermutation {
    static final int a = (int) 'a';
    static final int z = (int) 'z';

    public static void main(String...args) {
        String permutatPalindrome = "a toyota! race fast, safe car! a toyotA!";
        if (isPermutatePalindronUsingCharacterFrequencyTable(permutatPalindrome)) {
            System.out.println("Frequency Table : String is a permutated pallindrome.");
        } else {
            System.out.println("Frequency Table : String is a not a permutated pallindrome.");
        }
        if (isPermutatePalindronUsingCount(permutatPalindrome)) {
            System.out.println("Count : String is a permutated pallindrome.");
        } else {
            System.out.println("Count : String is a not a permutated pallindrome.");
        }

    }

    public static boolean isPermutatePalindronUsingCharacterFrequencyTable(final String string) {
        int[] table = new int[z - a + 1];
        for (char character : string.toCharArray()) {
            int x = getCharacterNumber(character);
            if (x != -1) {
                table[x]++;
            }
        }
        boolean isPalindrome = false;
        for (int integer : table) {
            if (integer % 2 != 0) {
                if (isPalindrome) {
                    return false;
                }
                isPalindrome = true;
            }
        }
        return true;
    }

    public static boolean isPermutatePalindronUsingCount(final String string) {
        int[] table = new int[z - a + 1];
        int count = 0;
        for (char character : string.toCharArray()) {
            int x = getCharacterNumber(character);
            if (x != -1) {
                table[x]++;
                if (table[x] % 2 == 1) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return count <= 1;
    }

    public static int getCharacterNumber(int character) {
        if (a <= character && character <= z) {
            return character - a;
        }
        return -1;
    }
}
