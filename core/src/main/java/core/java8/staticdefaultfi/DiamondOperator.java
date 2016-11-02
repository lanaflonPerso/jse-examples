package core.java8.staticdefaultfi;

// https://dzone.com/articles/the-java-8-api-design-principles?edition=219182&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=dd%202016-10-02
public class DiamondOperator implements DiamondProblemInterfaceA, DiamondProblemInterfaceB {

    @Override
    public void method2() {
    }

    @Override
    public void method1(String str) {
    }

    @Override
    public void method2(String str) {

    }

    //MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str){
        System.out.println("MyClass logging::"+str);
    }

    @Override
    public void log2(String str) {

    }

    public static void main(String...args) {
        new DiamondOperator().log("default");
    }

}
