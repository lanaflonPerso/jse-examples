package core.scratch;

/**
 * Created by ehimnay on 18/10/2016.
 */
public class LeftRightShiftOperator {
    public static void main(String[] args) {
        //10
        System.out.println(Integer.toBinaryString(2));
        //1000000000000  shift 1 11times
        System.out.println(Integer.toBinaryString(2 << 11));

        System.out.println(Integer.toBinaryString(2 >> 2));
    }
}
