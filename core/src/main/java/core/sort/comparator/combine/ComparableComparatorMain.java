package core.sort.comparator.combine;

import java.util.Arrays;

public class ComparableComparatorMain {
    public static void main(String...args) {
        ComparableComparator cc2[] = new ComparableComparator[6];
        cc2[0] = new ComparableComparator(5, "A");
        cc2[1] = new ComparableComparator(1, "N");
        cc2[2] = new ComparableComparator(6, "B");
        cc2[3] = new ComparableComparator(9, "O");
        cc2[4] = new ComparableComparator(-4, "X");
        cc2[5] = new ComparableComparator(0, "Z");

        Arrays.sort(cc2, ComparableComparator.sortByAge);

        for (ComparableComparator cc : cc2) {
            System.out.println(cc);
        }

        Arrays.sort(cc2, ComparableComparator.sortByName);

        for (ComparableComparator cc : cc2) {
            System.out.println(cc);
        }
    }
}
