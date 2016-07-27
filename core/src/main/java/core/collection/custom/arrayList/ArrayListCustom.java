package core.collection.custom.arrayList;

import java.util.Arrays;

public class ArrayListCustom<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object elements[];

    public ArrayListCustom() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayListCustom(int capacity) {
        elements = new Object[capacity];
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
        // System.arraycopy();
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }
}