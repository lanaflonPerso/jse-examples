package core.assignment;

public class PallindromeCheckMain {
    public static void main(String...args) {
        reverseAndAdd(195L);
    }

    public static void reverseAndAdd(long number) {
        final int COUNT = 1000;
        for (int counter = 1; counter <= COUNT; counter++) {
            if (checkPallindrome(number, reverseNumber(number))) {
                System.out.println(number);
                System.exit(0);
            } else {
                number = reverseNumber(number + reverseNumber(number));
            }
        }
        System.out.println(number);
        int length = Long.toString(number).length();
        System.out.println(length);
    }

    public static boolean checkPallindrome(long number, long reverse) {
        return number == reverseNumber(number);
    }

    public static long reverseNumber(long number) {
        long reverseNumber = 0;
        for (; number != 0; number = number / 10) {
            reverseNumber = reverseNumber * 10;
            reverseNumber = reverseNumber + number % 10;
        }
        return reverseNumber;
    }

}