package core.java8.string;

import java.util.stream.Collectors;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class StringJoin {
    public static void main(String...args) {
        String join = String.join("/", "opt", "ericsson", "jboss", "modules");
        System.out.println(join);

        String chars = "foobar:foo:bar";
        chars.chars().distinct().mapToObj(c -> String.valueOf((char) c)).sorted()
                .collect(Collectors.joining());
        System.out.println(chars);
    }
}
