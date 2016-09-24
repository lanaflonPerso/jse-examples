package com.org.puzzle;

import static java.lang.Math.sqrt;

public class VirtualExtensionMethod {

    public static void main(String...args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a);
            }
        };

        System.out.println(formula.calculate(25));
    }

    interface Formula {
        double calculate(int a);
    }

}