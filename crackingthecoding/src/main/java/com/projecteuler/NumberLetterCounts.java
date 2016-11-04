package main.java.com.projecteuler;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * <p>
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * <p>
 * <p>
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.
 */
public class NumberLetterCounts {
    private static final String[] ONE = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    private static final String[] ELEVEN = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static final String[] TWENTY = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private static final String[] HUNDRED = {"hundred", "thousand"};
    private static int letterCount = 0;

    public static void main(String...args) {
        for (int i = 1; i <= 1000; i++) {
            if (i <= 99) {
                tenth(i);
            } else if (i <= 999) {
                tenth(i / 100);
                hundreth(i);
            } else {
                tenth(i / 1000);
                thousand();
            }
            System.out.println();
        }
        System.out.println("Letter Count : " + letterCount);
    }

    public static void tenth(int i) {
        if (i <= 10) {
            countLetter(ONE, i);
        } else if (i >= 11 && i <= 19) {
            countLetter(ELEVEN, i - 11);
        } else if (i >= 20 && i <= 99) {
            int tenth = i / 10;
            int unit = i % 10;
            countLetter(TWENTY, tenth - 2);
            countLetter(ONE, unit);
        }
    }

    public static void hundreth(final int i) {
        if (i % 100 >= 0) {
            countLetter(HUNDRED, 0);
        }
        int unitTenth = i % 100;
        if (unitTenth >= 1) {
            System.out.print("and");
            letterCount += 3;
            tenth(unitTenth);
        }
    }

    public static void thousand() {
        countLetter(HUNDRED, 1);
    }

    public static void countLetter(String[] array, int index) {
        String word = array[index];
        System.out.print(word);
        letterCount += word.length();
    }
}
