package com.org.ds;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.org.ds.arrays.RearrangeInputToTargetTest;
import com.org.ds.arrays.SimplePhoneNumberAllotterTest;
import com.org.ds.binarytree.BstClosestNodeTest;
import com.org.ds.binarytree.BstFindModeTest;
import com.org.ds.bitsandbytes.NumSetBitsTest;
import com.org.ds.cache.LRUCacheTest;
import com.org.ds.collections.DeepIteratorTest;
import com.org.ds.collections.PeekIteratorTest;
import com.org.ds.common.NumberUtilsTest;
import com.org.ds.general.RainWaterTest;
import com.org.ds.lists.SinglyLinkedListTest;
import com.org.ds.sorting.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({ RearrangeInputToTargetTest.class, BstClosestNodeTest.class, BstFindModeTest.class,
        MergeSortTest.class, LRUCacheTest.class, DeepIteratorTest.class, PeekIteratorTest.class,
        SinglyLinkedListTest.class, NumberUtilsTest.class, NumSetBitsTest.class, SimplePhoneNumberAllotterTest.class,
        RainWaterTest.class, HeapSortTest.class, QuickSortTest.class, StupidSortTest.class, InsertionSortTest.class,
        SimpleHeapImplTest.class, })
public class AllTests {
    public static void main(String...argsargs) {
        org.junit.runner.JUnitCore.main("AllTests");
    }
}
