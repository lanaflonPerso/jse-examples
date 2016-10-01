package core.java8.math;

/**
 * Created by ehimnay on 01/10/2016.
 */
public class MathExample {
    public static void main(String...args) {
        System.out.println(100000 * 100000);
        floorMod();
        floorDiv();
        opExactly(Integer.MAX_VALUE, Integer.MAX_VALUE);
        toIntExactly();
        nextDown();
    }

    public static void opExactly(int a, int b){
        System.out.println(Math.multiplyExact(a, b));
        System.out.println(Math.addExact(a, b));
        System.out.println(Math.subtractExact(a, b));
    }

    public static void floorMod(){
        System.out.println(4 % 2);
        System.out.println(3 % 2);
        System.out.println(-15 % 2);
        System.out.println(-16 % 2);
        System.out.println(Math.floorMod(4, 2));
        System.out.println(Math.floorMod(3, 2));
        System.out.println(Math.floorMod(-15, 2));
        System.out.println(Math.floorMod(-16, 2));
    }

    public static void floorDiv(){
        System.out.println(4 % 2);
        System.out.println(3 % 2);
        System.out.println(-15 % 2);
        System.out.println(-16 % 2);
        System.out.println(Math.floorDiv(4, 2));
        System.out.println(Math.floorDiv(3, 2));
        System.out.println(Math.floorDiv(-15, 2));
        System.out.println(Math.floorDiv(-16, 2));
    }

    public static void toIntExactly(){
        System.out.println( Long.MAX_VALUE );
        System.out.println( (int)Long.MAX_VALUE );
        System.out.println( Math.toIntExact(10_00_00_000) );
        System.out.println( Math.toIntExact(Long.MAX_VALUE) );
    }

    public static void nextDown(){
        System.out.println( Math.nextDown(100) );
        System.out.println( Math.nextDown(100.365) );
    }
}
