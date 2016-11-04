package main.java.com.crackingthecode;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class RecursiveFibonacci {
    public static void main(String...args) {
        fibonacci(10);
    }

    public static int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
