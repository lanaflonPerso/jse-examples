package core.sort.comparator;

import java.util.Arrays;

public class ComparableCheckMain {
    public static void main(String... args) {
        ComparableCheck employees[] = new ComparableCheck[5];

        ComparableCheck obj1 = new ComparableCheck(2, "D");
        employees[0] = obj1;

        ComparableCheck obj2 = new ComparableCheck(1, "E");
        employees[1] = obj2;

        ComparableCheck obj3 = new ComparableCheck(0, "Z");
        employees[2] = obj3;

        ComparableCheck obj4 = new ComparableCheck(5, "X");
        employees[3] = obj4;

        ComparableCheck obj5 = new ComparableCheck(9, "U");
        employees[4] = obj5;

        Arrays.sort(employees);

    }
}
