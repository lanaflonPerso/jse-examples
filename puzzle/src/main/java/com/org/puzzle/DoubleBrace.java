package com.org.puzzle;

import java.util.ArrayList;
import java.util.List;

public class DoubleBrace {
    public static void main(String...args) {
        List<String> params = new ArrayList<String>() {
            {
                add("param one");
                add("param two");
                add("param three");
                add("param four");
            }
        };
        useParamsInSomeMethod(params);
    }

    private static void useParamsInSomeMethod(List<String> params) {
        System.out.println(params);
    }
}