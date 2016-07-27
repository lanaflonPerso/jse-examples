package core.collection.custom.arrayList;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.testng.Assert;

public class ArrayListMain {

    @Test
    public void assertInLoop() {
        List<Boolean> assertList = new ArrayList<Boolean>() {
            {
                add(true);
                add(false);
            }
        };
        for (boolean assertCheck : assertList) {
            Assert.assertEquals(true, assertCheck);
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMyList() {
        ArrayListCustom<Integer> list = new ArrayListCustom<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

        list.get(6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testNegative() {
        ArrayListCustom<Integer> list = new ArrayListCustom<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

        list.get(6);
    }

}