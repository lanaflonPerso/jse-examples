package core;

import core.puzzle.AccessModifier;

public class AccessModifierMain {
    public static void main(String[] args) {
        AccessModifier am = new AccessModifier();
        System.out.println("AccessModifierMain.main" + am.pubField);
        am.getPubField();
    }
}
