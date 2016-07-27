package com.org.ds.cache;

/**
 * A simple com.org.ds.cache interface.
 * 
 * @param <CacheKeyType>
 *            Type of com.org.ds.cache key
 * @param <CacheValueType>
 *            Type of com.org.ds.cache value
 */
public interface Cache<CacheKeyType, CacheValueType> {
    CacheValueType get(CacheKeyType key);

    void put(CacheKeyType key, CacheValueType value);

    int getSize();
}
