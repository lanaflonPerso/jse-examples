package main.java.com.projecteuler;

/**
 * Euler discovered the remarkable quadratic formula:

 n^2+n+41
 It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤390≤n≤39.
 However, when n=40,40^2+40+41=40(40+1)+41 n=40,40^2+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,41^2+41+41n=41,41^2+41+41 is clearly divisible by 41.

 The incredible formula n^2−79n+1601 was discovered, which produces 80 primes for the consecutive values 0≤n≤79. The product of the coefficients, −79 and 1601, is −126479.

 Considering quadratics of the form:

 n^2+an+bn2+an+b, where |a|<1000|a|<1000 and |b|≤1000|b|≤1000

 where |n||n| is the modulus/absolute value of nn
 e.g. |11|=11|11|=11 and |−4|=4|−4|=4
 Find the product of the coefficients, aa and bb, for the quadratic expression that produces the maximum number of primes for consecutive values of nn, starting with n=0n=0.
 */
public class QuadraticPrimes {
    static int[] primes = new int[87400];

    public static void main(String...args) {
        eulerFormula();
        primeFormula();

        int aMax = 0, bMax = 0, nMax = 0;
        for (int a = -1000; a <= 1000; a++) {
            for(int b = -1000; b <= 1000; b++){
                int n = 0;
                while (isPrime(Math.abs(n * n + a * n + b))) {
                    n++;
                }

                if (n > nMax) {
                    aMax = a;
                    bMax = b;
                    nMax = n;
                }
            }
        }
    }

    public static boolean isPrime(int testNumber) {
        int i = 0;
        while (primes[i] <= testNumber) {
            if (primes[i] == testNumber) {
                return true;
            }
            i++;
        }
        return false;
    }

    // n^2+n+41, 0≤n≤39
    public static void eulerFormula() {
        for (int i = 0; i <= 41; i++) {
            int euler = i * i + i + 41;
            System.out.print(euler + " ");
        }
    }

    //n^2−79n+1601, 0≤n≤79
    public static void primeFormula() {
        System.out.println();
        for (int i = 0; i <= 79; i++) {
            int prime = i * i - 79 * i + 1601;
            System.out.print(prime + " ");
        }
    }
}
