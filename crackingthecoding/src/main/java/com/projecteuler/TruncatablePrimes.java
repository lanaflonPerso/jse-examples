package main.java.com.projecteuler;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797,
 * 379, 37, and 3. Find the sumOfAll of the only eleven primes that are both truncatable from left to right and right to
 * left. NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class TruncatablePrimes {
    public static void main(String[] args) {
        int count = 0;
        int i = 11;
        int sum = 0;
        while (count <= 11) {
            if (isPrime(i) && isPrime(Integer.reverse(i))) {
                System.out.println(i);
                count++;
                sum += i;
            }
            i += 2;
        }
        System.out.println(sum);
    }

    public static boolean isPrime(int number) {
        int primeNumber = number;
        while (primeNumber > 0) {
            int i = 2;
            while (i <= primeNumber) {
                if (primeNumber % i == 0) {
                    break;
                }
                i++;
            }
            if (i == primeNumber) {
                primeNumber /= 10;
            } else {
                return false;
            }
        }
        return true;
    }
}
