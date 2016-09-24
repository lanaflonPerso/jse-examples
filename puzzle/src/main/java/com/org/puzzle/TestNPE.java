package com.org.puzzle;

public class TestNPE {
    public static void main(String...args) {
        Account object = new Account(1);
        System.out.println(object instanceof Account);

        object = null;
        System.out.println(object instanceof Account);

        object = (Account) null;
        System.out.println(object instanceof Account);
    }
}

class Account {
    private int i;

    Account(int i) {
        this.i = i;
    }
}