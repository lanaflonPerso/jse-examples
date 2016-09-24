package com.org.puzzle;

public class NumberSystem {

    public static void main(String...args) {
        Integer decimalNumber = 2;
        System.out.println(decimalNumber.toBinaryString(decimalNumber));
        System.out.println(decimalNumber.toOctalString(decimalNumber));
        System.out.println(decimalNumber.toHexString(decimalNumber));
    }
}