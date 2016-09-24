package core.tricks;

import java.util.Iterator;

/**
 * Created by ehimnay on 01/12/2015.
 */
public class ForEachIterator {
    public static void main(String...args) {
        MyCollection<String> stringCollection = new MyCollection<String>();

        for (String string : stringCollection) {

        }
    }

    static class MyCollection<E> implements Iterable<E> {

        public Iterator<E> iterator() {
            return new MyIterator<E>();
        }
    }

    static class MyIterator<T> implements Iterator<T> {

        public boolean hasNext() {
            return true;
        }

        public T next() {
            return null;
        }

        public void remove() {

        }
    }
}
