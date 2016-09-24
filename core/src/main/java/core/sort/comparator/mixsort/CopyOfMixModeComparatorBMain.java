package core.sort.comparator.mixsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CopyOfMixModeComparatorBMain {

    public static void main(String...args) {
        List<String> alphaNumericList = new ArrayList<String>() {
            {
                add("A11");
                add("A");
                add("d");
                add("b");
                add("e");
                add("D");
                add("X");
            }
        };

        Collections.sort(alphaNumericList, new Comparator<String>() {
            public int compare(String s1, String s2) {
                String s1StringPart = s1.replaceAll("\\d", "");
                String s2StringPart = s2.replaceAll("\\d", "");
                if (s1StringPart.equalsIgnoreCase(s2StringPart)) {
                    return extractInt(s1) - extractInt(s2);
                }
                return s1.compareTo(s2);
            }

            int extractInt(String s) {
                String num = s.replaceAll("\\D", "");
                return num.isEmpty() ? 0 : Integer.parseInt(num);
            }
        });

        System.out.println(alphaNumericList);
    }

}
