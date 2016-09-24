package core.assignment;

public class Recursive {

    /**
     * @param args
     */
    public static void main(String...args) {
        template();
    }

    public static void template() {
        StringBuffer stringRev = new StringBuffer();
        stringReverse("Himansu", stringRev);
        System.out.println(stringRev);
        System.out.println(integerReverse(123456789L, 0l));
        for (int counter = 0; counter <= 10; counter++) {
            System.out.print(fibonacci(counter) + " ");
        }
        System.out.println(factorial(5));

        stringCombination("", "ABC");
    }

    public static void stringReverse(String string, StringBuffer stringRev) {
        // base case
        if (string.length() == 0) {
            return;
        } else {
            // recursive case
            int sizeMinus1 = string.length() - 1;
            stringRev.append(string.charAt(sizeMinus1));
            stringReverse(string.substring(0, sizeMinus1), stringRev);
        }

    }

    public static long integerReverse(long number, long numberRev) {
        long single = number % 10;
        numberRev = numberRev * 10 + single;
        number = number / 10;
        // base case
        if (number == 0) {
            return numberRev;
        } else {
            // recursive case
            numberRev = integerReverse(number, numberRev);
        }
        return numberRev;
    }

    public static int fibonacci(int number) {
        // base case
        if (number <= 1) {
            return number;
        } else {
            // recursive case
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static int factorial(int number) {
        if (number == 1) {
            return number;
        } else {
            return number * factorial(number - 1);
        }
    }

    public static void stringCombination(String perm, String string) {
        // base case
        if (string.length() == 0) {
            System.out.println(perm);
        } else {
            // recursive case
            for (int i = 0; i < string.length(); i++) {
                stringCombination(perm + string.charAt(i), string.substring(0, i) + string.substring(i + 1));
            }
        }
    }

}
