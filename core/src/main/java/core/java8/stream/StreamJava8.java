package core.java8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamJava8 {
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        streamParallelProcessing(strings);
        streamFilter(strings);
        streamCollect(strings);
        streamMap();
        streamMapStats();
        streamSort();
    }

    // parallel processing
    public static void streamParallelProcessing(List<String> strings) {
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings using stream parallel : " + count);
    }

    // filter
    public static void streamFilter(List<String> strings) {
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Empty Strings: " + count);

        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Strings of length 3: " + count);
    }

    // collect + Collectors
    public static void streamCollect(List<String> strings) {
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);

    }

    // map
    public static void streamMap() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
    }

    // stats
    public static void streamMapStats() {
        List<Integer> integers = Arrays.asList(1, 2, 13, 4, 15, 6, 17, 8, 19);
        System.out.println("List: " + integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }

    // sort
    public static void streamSort() {
        Random random = new Random(100);
        System.out.println("Random Numbers: ");
        random.ints().limit(10).sorted().forEach(s -> System.out.print(s + " " ));
    }
}
