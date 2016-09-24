package com.org.puzzle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForEachTest {

    /**
     * @param args
     */
    public static void main(String...args) {
        List<String> test = new ArrayList<String>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        for (String temp : emptyIfNull(test)) {
            System.out.println(temp);

        }

    }

    public static List<String> emptyIfNull(List<String> other) {
        System.out.println(other);
        return other == null ? Collections.EMPTY_LIST : other;
    }

}
