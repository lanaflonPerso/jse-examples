package main.java.com.projecteuler;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class SieveOfEratosthenesPrimeNumber {
    public static void main(String...args) {
        sieveOfEratos(10_00_000);
    }

    public static void sieveOfEratos(int n) {
        boolean isPrime[] = new boolean[n];
        isPrime[0] = false;
        for (int index = 1; index < n; index++) {
            isPrime[index] = true;
        }

        for (int no = 2; no <= n; no++) {
            if (isPrime[no - 1]) {
                System.out.println(no);
                for (int index = no * no; index <= n; index += no) {
                    isPrime[index - 1] = false;
                }
            }
        }

    }
}
