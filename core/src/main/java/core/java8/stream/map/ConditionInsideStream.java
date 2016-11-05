package core.java8.stream.map;

import java.util.*;
import java.util.stream.*;

public class ConditionInsideStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("abC", "Long Mixed", "SHORT");

        // using map
        List<String> listMap = list.stream()
                .map(str -> str.length() > 5 ? str.toUpperCase() : str.toLowerCase())
                .collect(Collectors.toList());
        System.out.println(listMap);

        // using foreach
        List<String> listForEach = Arrays.asList("abC", "Long Mixed", "SHORT");
        listForEach.stream()
                .forEach(s -> {
                    if (s.length() > 5)
                        s.toUpperCase();
                    else
                        s.toLowerCase();
                });

    }
}
