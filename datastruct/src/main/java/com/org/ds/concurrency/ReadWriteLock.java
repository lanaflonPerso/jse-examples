package com.org.ds.concurrency;

/**
 * Defines a com.org.ds.common interface for different types of read writer locks.
 */
public interface ReadWriteLock {
    void readLock() throws InterruptedException;

    void readUnlock() throws InterruptedException;

    void writeLock() throws InterruptedException;

    void writeUnlock() throws InterruptedException;
}
