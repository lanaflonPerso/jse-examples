package com.org.puzzle;

public class AccessModifierMain {
    public static void main(String...args) {
        AccessModifier am = new AccessModifier();
        System.out.println("AccessModifierMain.main" + am.pubField);
        am.getPubField();
    }
}
