package core.java8.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * forEach, lambda and functional interface.
 */
public class ForEach {
    public static void main(String...args) {
        List<String> list = Arrays.asList("Himansu", "Nayak", "Ericsson");
        forEach(list);
        lambda(list);
        reuseConsumer(list);
    }

    // Style 1
    public static void forEach(List<String> list) {
        System.out.println("ForEach.forEach");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    // Style 2
    public static void lambda(List<String> list) {
        System.out.println("ForEach.lambda");
        list.forEach(s -> System.out.println(s));
    }

    // Style 3
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