package core.java8.staticdefaultfi;

//Not mandatory to annotate @FunctionalInterface. This will help you to declare multiple abstract methods.
//@FunctionalInterface restrict multiple abstract methods. also check java.util.function pkg in java8
//@FunctionalInterface
public interface DiamondProblemInterfaceA extends DiamondProblemInterface{

    void method1(String str);

    void method2(String str);

    default void log(String str){
        System.out.println("I1 logging::"+str);
    }

    default void log2(String str){
        System.out.println("I1 logging::"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }

    static void print2(String str){
        System.out.println("Printing "+str);
    }

    //trying to override Object method gives compile time error as
    //"A default method cannot override a method from java.lang.Object"

//	default String toString(){
//		return "i1";
//	}

}