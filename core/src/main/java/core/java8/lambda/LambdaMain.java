package core.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaMain {
    public static void main(String...args) {
        example1();

    }

    public static void example1(){
        new Thread(()-> System.out.println("LambdaMain.example1")).start();
    }

    public static void example2(){
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Himansu");
        arrayList.add("Ericsson");
        arrayList.forEach(p -> System.out.println(p));
    }


}
