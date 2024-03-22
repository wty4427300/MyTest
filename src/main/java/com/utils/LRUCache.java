package com.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> {
    protected final LinkedHashMap<K, V> cache;
    protected final Set<Map.Entry<K, V>> cacheEntrySet;

    public LRUCache() {
        cache = new LinkedHashMap<>(16, .75f, true);
        cacheEntrySet = cache.entrySet();
    }

    public synchronized boolean touch(K key) {
        return cache.get(key) != null;
    }

    public synchronized void put(K key, V value) {
        if (cache.put(key, value) != null) {
            touch(key);
        }
    }

    public synchronized V get(K key) {
        return cache.get(key);
    }

    public synchronized Map.Entry<K, V> pop() {
        Iterator<Map.Entry<K, V>> it = cacheEntrySet.iterator();
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry<K, V> entry = it.next();
        if (entry == null) {
            return null;
        }
        it.remove();
        return entry;
    }

    public synchronized boolean remove(K key) {
        return cache.remove(key) != null;
    }

    public synchronized int size() {
        return cache.size();
    }

    public synchronized boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
