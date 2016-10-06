package test.java;

import java.util.*;

/**
 * Created by ehimnay on 06/10/2016.
 */
public class SplitList {
    public static void main(String[] args) {
        List<String> string = Arrays.asList("a","b");
        System.out.println(string.subList(0,5));
        List<List<String>> choppedList = splitList(string, 0);
        System.out.println(choppedList.size());
        System.out.println(choppedList.get(0).size());
    }

    public static <T> List<List<T>> splitList(final List<T> list, final long size) {
        final List<List<T>> choppedList = new ArrayList<>();
        final int listSize = list.size();
        for (int index = 0; index < listSize; index += size) {
            choppedList.add(new ArrayList<>(list.subList(index, Math.min(listSize, index + (int)size))));
        }
        return choppedList;
    }

}
