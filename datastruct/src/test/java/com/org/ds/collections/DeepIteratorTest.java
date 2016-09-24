package com.org.ds.collections;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class DeepIteratorTest {

    public static void main(String...args) {
        org.junit.runner.JUnitCore.main("collections.DeepIteratorTest");
        Set<?> x = new HashSet<Integer>();
        Collection<?> c = x;
    }

    @Test
    public void flatCollection() {
        Integer[] expected = { 1, 2, 3, 4, 5 };
        List<Integer> flatList = Arrays.asList(expected);

        checkIterator(new DeepIterator<Integer>(flatList), expected);
    }

    @Test
    public void nestedCollections() {
        Integer[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Collection<Object> bag = new Vector<Object>();
        bag.add(1);

        List<Object> foo = new Vector<Object>();
        foo.add(2);
        foo.add(3);

        List<Integer> bar = new Vector<Integer>();
        bar.add(4);
        bar.add(5);

        foo.add(bar);

        bag.add(foo);
        bag.add(6);

        List<Object> zee = new Vector<Object>();
        zee.add(7);
        zee.add(8);

        List<Integer> xow = new Vector<Integer>();
        xow.add(9);
        xow.add(10);

        zee.add(xow);

        bag.add(zee);

        checkIterator(new DeepIterator<Integer>(bag), expected);
    }

    @Test
    public void emptyCollections() {
        Integer[] expected = { 1, 2, 3 };

        Collection<Object> bag = new Vector<Object>();
        bag.add(1);
        bag.add(new Vector<Object>());
        bag.add(2);
        bag.add(new Vector<Object>());
        bag.add(3);

        checkIterator(new DeepIterator<Integer>(bag), expected);
    }

    private void checkIterator(DeepIterator<Integer> deepIterator, Integer[] expected) {
        int index = 0;
        while (deepIterator.hasNext()) {
            assertEquals(deepIterator.next(), expected[index]);
            index++;
        }

        assertFalse(deepIterator.hasNext());
    }
}
