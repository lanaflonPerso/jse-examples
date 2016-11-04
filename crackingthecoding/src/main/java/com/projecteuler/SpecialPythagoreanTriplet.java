package main.java.com.projecteuler;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * <p>
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * <p>
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class SpecialPythagoreanTriplet {
    public static void main(String...args) {
        for (int a = 1; a <= 1000; a++) {
            for (int b = 1; b <= 1000; b++) {
                for (int c = 1; c <= 1000; c++) {
                    if ((a * a + b * b == c * c) && (a < b) && (b < c) && (a + b + c == 1000)) {
                        System.out.print("Product of " + a + " ," + b + " and " + c + " is ");
                        System.out.print(a * b * c);
                    }
                }
            }
        }
    }
}
