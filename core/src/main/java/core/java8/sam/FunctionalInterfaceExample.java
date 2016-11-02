package core.java8.sam;

@FunctionalInterface
public interface FunctionalInterfaceExample {
    void sam();

// multiple abstract method are not allowed
// void method();

    default void method2() {

    }

    default void method3() {

    }

    @Override
    String toString();

    @Override
    boolean equals(Object object);

}