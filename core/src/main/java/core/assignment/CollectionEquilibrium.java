package core.assignment;

public class CollectionEquilibrium {
    public static void main(String...args) {
        long equilibrium = solution(new int[]{4,1,2,3,3});
        System.out.println(equilibrium);
    }
    public static long solution(int[] x) {
        long equilibrium = 0, leftMost = 0,rightMost = 0;
        for (int index = 0; index < x.length; index++) {
            rightMost += x[index];
        }
        for (int index = 0; index < x.length; index++) {
            long tempRight = rightMost - x[index];
            if (leftMost == tempRight) {
                equilibrium = index;
                break;
            } else {
                leftMost += x[index];
                rightMost = tempRight;
            }
        }
        return equilibrium;
    }
}
