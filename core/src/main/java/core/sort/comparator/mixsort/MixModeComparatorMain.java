package core.sort.comparator.mixsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MixModeComparatorMain {

    public static void main(String...args) {
        List<String> alphaNumericList = new ArrayList<String>() {
            {
                add("LTE07ERBS0000A");
                add("LTE07ERBS0000Z");
                add("LTE07ERBS0000M");
                add("LTE07ERBS0000D");
                add("LTE07ERBS0000O");
                add("LTE07ERBS");
                add("LTE07ERBS00001-1");
                add("LTE07ERBS00001-2");
                add("LTE07ERBS00001-11");
                add("LTE07ERBS00001-0");
                add("LTE07ERBS00001-22");
            }
        };
        Collections.sort(alphaNumericList, new MixModeComparator());
        System.out.println(alphaNumericList);
    }
}
