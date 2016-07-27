package core.java8.sam;

@FunctionalInterface
public interface FunctionalInterfaceExample {
    public void sam();

//    public void method();

    default void method2(){

    }

    default void method3(){

    }

    @Override
    public String toString();

    @Override
    public boolean equals(Object object);

}