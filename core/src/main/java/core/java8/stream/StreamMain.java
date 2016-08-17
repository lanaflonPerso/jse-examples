package core.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * * Java program to demonstrate how to use Java 8 Stream API with simple * examples
 * like filter objects, transforming objects and creating subsets.
 */

public class StreamMain {
    public static void main(String... args) {
        streamArray();
        streamArgument();
        streamList();
        streamBuilder();
    }

    public static void streamArray(){
        String token[] = {"Himansu", "Ericcson", "PMIC", "Athlone"};
        Stream<String> stringStream = Stream.of(token);
        stringStream.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    public static void streamArgument(){
        Stream<Integer> stringStream = Stream.of(1,2,3,4,5);
                stringStream.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    public static void streamList(){
        List<String> list = Arrays.asList("A", "BB", "CCC", "DDDD");
        Stream<String> stringStream = list.stream();
        stringStream.forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    public static void streamBuilder(){
        IntStream stream = "xyzabcmnodefg".chars().sorted();
        stream.forEach(p -> System.out.print((char)p + " "));
        System.out.println();
    }


}
