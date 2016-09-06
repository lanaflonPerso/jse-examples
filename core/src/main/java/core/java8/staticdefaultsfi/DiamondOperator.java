package core.java8.staticdefaultsfi;

public class DiamondOperator implements DiamondProblemInterfaceA, DiamondProblemInterfaceB {

    @Override
    public void method2() {
    }

    @Override
    public void method1(String str) {
    }

    //MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str){
        System.out.println("MyClass logging::"+str);
    }

    public static void main(String...args) {
        new DiamondOperator().log("default");
    }

}
