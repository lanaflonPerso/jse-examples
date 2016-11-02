package core.java8.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * functionalInterface, lambda and functional interface.
 */
public class ForEach {
    public static void main(String...args) {
        List<String> list = Arrays.asList("Himansu", "Nayak", "Ericsson");
        functionalInterface(list);
        lambda(list);
        reuseConsumer(list);
    }

    // Style 1
    public static void functionalInterface(List<String> list) {
        System.out.println("ForEach.functionalInterface");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    // Style 2 Method Reference
    public static void methodReference(List<String> list) {
        System.out.println("ForEach.functionalInterface");
        list.forEach(System.out::println);
    }

    // Style 3 lambda(internal iterator)
    public static void lambda(List<String> list) {
        System.out.println("ForEach.lambda");
        list.forEach(s -> System.out.println(s));
    }

    // Style 4
    public static void reuseConsumer(List<String> list) {
        System.out.println("ForEach.reuseConsumer");
        list.forEach(new ReuseConsumer());
    }
}

class ReuseConsumer implements Consumer<String> {

    @Override
    public void accept(String s) {
        System.out.println(s);
    }
}