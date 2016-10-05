package core.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * https://examples.javacodegeeks.com/core-java/util/optional/java-8-optional-example/
 */
public class OptionalJava8 {
    public static void main(String... args) {
        emptyOptional();
        emptyOptional(null);

        Integer value1 = null;
        Integer value2 = new Integer(10);

        //Optional.ofNullable - allows passed parameter to be null.
        Optional<Integer> a = Optional.ofNullable(value1);

        Optional<String> string = Optional.ofNullable("Himansu");
        System.out.println(string);

        Optional<String> nullString = Optional.ofNullable(null);
        System.out.println(nullString);

        //Optional.of - throws NullPointerException if passed parameter is null
        Optional<Integer> b = Optional.of(value2);

        Optional<Integer> obj = Optional.empty();
        obj.ifPresent(x -> System.out.println(x));

        System.out.println(sum(a, b));
    }

    // null pointer if obj is null
    public static Optional initOptional(Integer obj) {
        return Optional.of(obj);
    }

    // works even if str is null
    public static Optional initOptional(String str) {
        return Optional.ofNullable(null);
    }

    // no such element exception on empty optional
    public static void emptyOptional() {
        try {
            Optional emptyOptional = Optional.empty();
            System.out.println(emptyOptional.get());
        } catch (NoSuchElementException ex) {
            System.out.println("expected NoSuchElementException");
        }
    }

    // works without throwing noSuchElement exception
    public static void emptyOptional(String defaultString) {
        Optional emptyOptional = Optional.empty();
        String obj = (String) emptyOptional.orElse(defaultString);
        System.out.println(obj);
    }

    // explicit throws exception
    public static void emptyOptionalExplicitException() {
        try {
            Optional emptyOptional = Optional.empty();
            emptyOptional.orElseThrow(IllegalArgumentException::new);
        } catch (Throwable iae) {
            System.out.println("IllegalArgumentException");
        }
    }

    // safe way to check null
    public static void emptyOptionWithIf(String string){
        Optional stringToUse = Optional.of(string);
        stringToUse.ifPresent(System.out::println);
    }



    public static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        //Optional.isPresent - checks the value is present or not

        System.out.println("First parameter is present: " + a.isPresent());
        System.out.println("Second parameter is present: " + b.isPresent());

        //Optional.orElse - returns the value if present otherwise returns
        //the default value passed.
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - gets the value, value should be present
        Integer value2 = b.get();
        return value1 + value2;
    }
}
