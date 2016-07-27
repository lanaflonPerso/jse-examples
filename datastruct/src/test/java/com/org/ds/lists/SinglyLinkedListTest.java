package com.org.ds.lists;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.org.ds.linkedlists.SinglyLinkedList;

public class SinglyLinkedListTest {

    private SinglyLinkedList<Integer> tested;

    @Before
    public void setup() {
        tested = new SinglyLinkedList<Integer>();
    }

    @Test
    public void reverseEmptyList() {
        tested.reverse();
        assertEquals(0, tested.size());
    }
}
