package core.java8.staticdefaultsfi;

// Not mandatory to annotate @FunctionalInterface
@FunctionalInterface
public interface DiamondProblemInterfaceB {

    void method2();

    default void log(String str){
        System.out.println("I2 logging::"+str);
    }

}
