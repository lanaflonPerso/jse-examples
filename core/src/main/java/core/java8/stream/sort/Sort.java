package core.java8.stream.sort;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ehimnay on 05/11/2016.
 */
public class Sort {
    public static void main(String[] args) {

        String S= "a0bb1aB2xyZ2mnoP2aA";

            Optional<String> list = Stream.of(S.split("[0-9]"))
                .filter(s -> s.chars().anyMatch(Character::isUpperCase))
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst();




        System.out.println(list.get());

    }
}
