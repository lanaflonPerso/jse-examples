package main.java.core.scratch;

/**
 * Created by ehimnay on 07/10/2016.
 */
public class IntegerCompare {

    public static void main(String[] args) {

        Integer alpha = new Integer(1);
        Integer beta = new Integer(1);

        if (alpha == beta) {
            System.out.println("==");
        }

        if (alpha.equals(beta)) {
            System.out.println("equal");
        }

    }
}
