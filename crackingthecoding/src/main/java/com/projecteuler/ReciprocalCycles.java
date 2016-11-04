package main.java.com.projecteuler;

/**
 * Created by ehimnay on 02/10/2016.
 */
public class ReciprocalCycles {
    public static void main(String...args) {
        printRecurring(1.0, 3.0);
    }

    public static void printRecurring(double a, double b) {
        double denominator = a / b;
        String number = Double.toString(denominator);
        number = number.substring(2, number.length());
        System.out.println(number);
    }

    public static void findRecurring(String string) {
        for (int i = 0; i < string.length(); i++) {
            String sub = string.substring(0, i);
            for (int j = i + 1; j < string.length(); ) {
                if(sub.equals(string.substring(j,sub.length()+1))){
                    
                }
            }
        }
    }
}
