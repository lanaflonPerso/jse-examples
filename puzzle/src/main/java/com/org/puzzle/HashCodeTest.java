package com.org.puzzle;

public class HashCodeTest {
    public static void main(String...args) {
        String Aa = "Aa";
        String BB = new String("BB");
        String cc = "CC";
        String CC = new String("CC");

        System.out.println(Aa.hashCode());
        System.out.println(BB.hashCode());
        System.out.println(cc.equals(CC));
    }
}