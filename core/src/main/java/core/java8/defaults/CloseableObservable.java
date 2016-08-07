/*
package com.core.java8.defaults;

import java.io.Closeable;
import java.io.IOException;
import java.util.*;

public interface CloseableObservable extends Closeable {

    class HiddenAndNasty {
        private static final Map<CloseableObservable, Collection<com.core.java8.defaults.CloseListener>> allObservers = new WeakHashMap<>();

        private static final Collection<com.core.java8.defaults.CloseListener> getObservers(CloseableObservable observable) {
            synchronized (observable) {
                Collection<com.core.java8.defaults.CloseListener> observers = allObservers.get(observable);
                if (observers == null) {
                    observers = new ArrayList<>();
                    allObservers.put(observable, observers);
                }
                return observers;
            }
        }
    }

    public default void addObserver(com.core.java8.defaults.CloseListener observer) {
        HiddenAndNasty.getObservers(this).add(observer);
    }

    @Override
    public default void close() throws IOException {
        // Copy Collection to avoid concurrent modification
        Collection<com.core.java8.defaults.CloseListener> observers = new ArrayList<>(HiddenAndNasty.getObservers(this));
        observers.forEach(observer -> observer.objectWillBeClosed(this));
        closeInternal();
        observers.forEach(observer -> observer.objectClosed(this));
    }

    void closeInternal() throws IOException;
}
*/
