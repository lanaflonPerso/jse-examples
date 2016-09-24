package core.collection;

public class ReHashing {
    private static final Integer ARRAY_SIZE = 100;

    private static String name = "Himansu";

    public static void main(String...args) {
        int array[] = new int[ARRAY_SIZE];
        System.out.println(name.hashCode() & array.length - 1);

    }
}
