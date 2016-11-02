package core.java8.staticdefaultfi;

// Not mandatory to annotate @FunctionalInterface
@FunctionalInterface
public interface DiamondProblemInterfaceB extends DiamondProblemInterface{

//    void method1();

    void method2();


    default void log(String str){
        System.out.println("I2 logging::"+str);
    }

}
