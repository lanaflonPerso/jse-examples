package com.pivotal;

/**
 * Created by ehimnay on 06/11/2016.
 */
public class CustomSetTDD {
    public static void main(String...args) {
        CustomSet<String> set = new CustomSet<>();
        set.add("SCB");
        set.add("CGI");
        set.add("MBRDI");
        set.add("Accenture");
        set.add("Ericsson");
        System.out.println("Your size: " + set.size() + ", contains(Sorry): " + set.contains("Ericsson"));

        CustomSet<Integer> ints = new CustomSet<>();
        for (int i = 0; i < 100; i++) {
            ints.add(i);
        }

        System.out.println("Your size: " + ints.size());
        System.out.println("Exp. size: 100\n");

        for (int i = 0; i < 100; i += 2) {
            ints.remove(i);
        }

        System.out.println("Your size: " + ints.size());
        System.out.println("Exp. size: 50\n");
        CustomSet<Integer> zeroThroughNine = new CustomSet<>();

        for (int i = 0; i < 10; i++) {
            zeroThroughNine.add(i);
        }
        ints.retainAll(zeroThroughNine);
        System.out.println("ints should now only retain odd numbers"
                + " 0 through 10\n");

        System.out.println("Testing your iterator:\n");

        for (Integer i : ints) {
            System.out.println(i);
        }

        System.out.println("\nExpected: \n\n1 \n3 \n5 \n7 \n9\n");

        System.out.println("Yours:");
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("\nExpected: \nHey! \nListen!");
        set.clear();
        System.out.println("\nClearing your set...\n");
        System.out.println("Your set is empty: " + set.isEmpty());
        System.out.println("Exp. set is empty: true");
    }
}
