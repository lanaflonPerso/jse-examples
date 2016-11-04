package main.java.com.projecteuler;

import java.math.BigInteger;

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * <p>
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be: 0 1 1
 * <p>
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 * <p>
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class _1000DigitFibonacciNumber {

    public static void main(String...args) {
        printFibonacci();
    }

    public static void printFibonacci(){
        BigInteger fibo;
        BigInteger prev = BigInteger.valueOf(0);
        BigInteger cur = BigInteger.valueOf(1);
        int count = 1;
        while(true){
            fibo = prev.add(cur);
            count++;
            if(fibo.toString().length() == 1000){
                System.out.println(count);
                break;
            }

            prev = cur;
            cur = fibo;
        }
    }
}
