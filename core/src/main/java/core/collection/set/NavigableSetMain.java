package core.collection.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetMain {

    public static void main(String...args) {

        NavigableSet<String> navigableSet = new TreeSet<String>(Arrays.asList("X", "B", "A", "Z", "T"));

        Iterator<String> iterator = null;

        System.out.println("Original Set :");
        for (iterator = navigableSet.descendingIterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.println("Sorted Navigable Set :");
        for (iterator = navigableSet.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }

        System.out.printf("Head Set : %s.%n", navigableSet.headSet("X"));

        System.out.printf("Tail Set : %s.%n", navigableSet.tailSet("T", false));

        System.out.printf("Sub Set : %s.%n", navigableSet.subSet("B", true, "X", true));

        System.out.printf("Last Element : %s%n", navigableSet.last());

        System.out.printf("First Element : %s%n", navigableSet.first());

        System.out.printf("Reverse Set : %s%n", navigableSet.descendingSet());

        System.out.printf("Original Set : %s%n", navigableSet);

    }
}