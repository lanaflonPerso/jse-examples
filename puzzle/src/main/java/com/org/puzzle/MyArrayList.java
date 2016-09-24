package com.org.puzzle;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    private final static int MAX_SIZE = 5;
    private final List<String> custom = new ArrayList<String>();
    private int size = 0;
    private int[] array = new int[MAX_SIZE];

    public static void main(String...args) throws Exception {

        // create HashMapCustom list
        MyArrayList list = new MyArrayList();
        list.add(2);
        list.add(3);
        list.add(4);

        // get an element from the list
        int element = list.get(0);
        System.out.println("element = " + element);

        // get the size
        int size = list.size();
        System.out.println("size = " + size);
    }

    public void add(int element) throws Exception {

        // make sure that they're room to add an element
        if (size >= MAX_SIZE) {
            throw new Exception("MyArrayList is full");
        }

        // add the new element
        array[size++] = element;

    }

    public int get(int index) {

        // require HashMapCustom valid index
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // return the value
        return array[index];
    }

    public int size() {
        return size;
    }

}
