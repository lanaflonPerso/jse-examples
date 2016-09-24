package core.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;

public class ReverseAndAdd {
    public static void main(String...args) throws IOException {
        readFile(args[0]);
    }

    public static void readFile(String filePath) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            // bufferedReader = new BufferedReader(new FileReader(filePath));
            String number = "196";
            // while ((number = bufferedReader.readLine()) != null) {
            reverseAndAdd(new BigInteger(number));
            // }
            System.exit(0);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    public static void reverseAndAdd(BigInteger number) {
        final BigInteger MAX = new BigInteger("4294967295");
        final int COUNT = 1000;
        if (number.compareTo(MAX) == -1) {
            for (int counter = 0; counter <= COUNT; counter++) {
                System.out.println("Counter : " + counter + " number : " + number);
                if (checkPallindrome(number, reverseNumber(number))) {
                    System.out.println("number of iterations : " + counter + " resulting palindrome : " + number);
                    return;
                } else {
                    number = reverseNumber(number.add(reverseNumber(number)));
                }
            }
        }
    }

    public static boolean checkPallindrome(BigInteger number, BigInteger reverse) {
        return number == reverseNumber(number);
    }

    public static BigInteger reverseNumber(BigInteger number) {
        BigInteger reverseNumber = BigInteger.ZERO;
        final BigInteger TEN = new BigInteger("10");
        for (; number.compareTo(BigInteger.ZERO) != 0; number = number.divide(TEN)) {
            reverseNumber = reverseNumber.multiply(TEN);
            reverseNumber = reverseNumber.add(number.mod(TEN));
        }
        return reverseNumber;
    }

}