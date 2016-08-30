package core.java8.foreach;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
    public static void main(String...args) {
        forEach();
        lambda();
    }

    public static void forEach(){
        List<String> list = Arrays.asList("Himansu", "Nayak", "Ericsson");
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    public static void lambda(){
        List<String> list = Arrays.asList("Himansu", "Nayak", "Ericsson");
        list.forEach(s -> System.out.println(s));
    }
}