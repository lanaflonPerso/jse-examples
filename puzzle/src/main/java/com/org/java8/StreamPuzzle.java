package com.org.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamPuzzle {
    public static void main(String...args) {
        method1();
        method2();
    }

    public static void method1(){
        List streamList = new ArrayList<>();
        streamList.add("Himansu");
        streamList.add("Nayak");
        Stream<String> stream = streamList.stream();
        streamList.add("Ericsson");
        stream.forEach(System.out::println);
    }

    public static void method2(){
        List streamList = new ArrayList<>();
        streamList.add("Himansu");
        streamList.add("Nayak");
        List subStream = streamList.subList(0, 2);
        streamList.add("Ericsson");
        Stream<String> stringStream = subStream.stream();
        stringStream.forEach(System.out::println);
    }
}