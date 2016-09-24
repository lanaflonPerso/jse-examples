package com.org.java8;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPuzzle {
    public static void main(String...args) {
        System.out.println("StreamPuzzle.streamList");
        streamList();
        System.out.println("StreamPuzzle.streamSubList");
        //        streamSubList();
        System.out.println("StreamPuzzle.streamWrite");
        streamWrite();
        System.out.println("StreamPuzzle.streamMax");
        streamMax();

        System.out.println("StreamPuzzle.mapSwap");
        mapSwap();

        System.out.println("StreamPuzzle.streamCompare");
//        streamCompare();

        System.out.println("StreamPuzzle.stringSupplier");
        stringSupplier();

        System.out.println("StreamPuzzle.streamRemove");
//        streamRemove();

        System.out.println("StreamPuzzle.Optional");
        Optional();
    }

    public static void streamList() {
        List streamList = new ArrayList<>();
        streamList.add("Himansu");
        streamList.add("Nayak");
        Stream<String> stream = streamList.stream();
        streamList.add("Ericsson");
        stream.forEach(System.out::println);
    }

    public static void streamSubList() {
        List streamList = new ArrayList<>();
        streamList.add("Himansu");
        streamList.add("Nayak");
        List subStream = streamList.subList(0, 2);
        streamList.add("Ericsson");
        Stream<String> stringStream = subStream.stream();
        stringStream.forEach(System.out::println);
    }

    public static void streamWrite() {
        ExecutorService es = Executors.newSingleThreadExecutor();
        List<String> sentence = Arrays.asList("Himansu", "Nayak");
        es.submit(() -> Files.write(Paths.get("file.txt"), sentence));
        es.shutdown();
    }

    public static void streamMax() {
        System.out.println(Stream.of(-3, -2, -1, 1, 2, 3, 4, 5).max(Math::max).get());
    }

    public static void mapSwap() {
        Map<String, String> oldSchool = new HashMap<String, String>() {
            {
                put("buildtool", "maven");
                put("lang", "java");
                put("db", "db2");
            }
        };
        Map<String, String> newSchool = new HashMap<String, String>() {
            {
                put("buildtool", "npm");
                put("lang", "javascript");
                put("db", "elasticsearch");
            }
        };

        oldSchool.replaceAll(newSchool::put);
        System.out.println(oldSchool);
        System.out.println(newSchool);
    }

    public static void streamCompare(){
        List<String> kitties = Arrays.asList("Bread", null, "Butter","Egg");
        Comparator<String> kittiesComparator = Comparator.nullsLast(Comparator.naturalOrder());
        System.out.println(Collections.max(kitties, kittiesComparator));
        System.out.println(kitties.stream().collect(Collectors.maxBy(kittiesComparator)).get());
        System.out.println(kitties.stream().max(kittiesComparator).get());
    }

    public static void stringSupplier(){
        String str = "Himansu";
        Supplier<String> s1 = str::toUpperCase;
        Supplier<String> s2 = str::toLowerCase;
        str = "Hotel Echo Lima Lima Oscar";
        System.out.println(s1.get());
        System.out.println(s2.get());
    }

    public static void streamRemove(){
        List<String> list = Arrays.asList("Chuck", "Arnie", "Slay");
        list.forEach(x -> {
            if(x.equals("Chuck")){
                list.remove("Chuck");
            }
        });
        System.out.println(list);
    }

    public static void Optional(){
        System.out.println(Optional.of("rtfm").orElseGet(null));
        System.out.println(Optional.empty().map(null).orElse("rtfm"));
    }
}