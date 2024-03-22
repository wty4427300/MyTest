package com.utils;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * LRU缓存实现类。基于 LinkedHashMap 实现。
 *
 * @param <K> 键的类型
 * @param <V> 值的类型
 */
public class LRUCache<K, V> {
    // 缓存存储结构，使用 LinkedHashMap 来保证访问顺序性
    protected final LinkedHashMap<K, V> cache;
    // 缓存的入口集合，用于遍历和移除操作
    protected final Set<Map.Entry<K, V>> cacheEntrySet;

    /**
     * 构造函数，初始化缓存。
     */
    public LRUCache() {
        cache = new LinkedHashMap<>(16, .75f, true); // 初始化 LinkedHashMap，容量为16，加载因子为0.75，访问顺序
        cacheEntrySet = cache.entrySet(); // 获取缓存的入口集合
    }

    /**
     * 触发键的访问，将对应的缓存项移到链表尾部，表示最近访问。
     *
     * @param key 被访问的键
     * @return 如果缓存中存在该键，则返回 true；否则返回 false。
     */
    public synchronized boolean touch(K key) {
        return cache.get(key) != null;
    }

    /**
     * 将键值对放入缓存，如果键已存在，则更新值并触发访问。
     *
     * @param key 键
     * @param value 值
     */
    public synchronized void put(K key, V value) {
        if (cache.put(key, value) != null) { // 如果键已存在，更新值并触发访问
            touch(key);
        }
    }

    /**
     * 获取缓存的值。
     *
     * @param key 键
     * @return 对应的值，如果不存在，则返回 null。
     */
    public synchronized V get(K key) {
        return cache.get(key);
    }

    /**
     * 移除并返回缓存中最老的键值对。
     *
     * @return 最老的键值对，如果缓存为空，则返回 null。
     */
    public synchronized Map.Entry<K, V> pop() {
        Iterator<Map.Entry<K, V>> it = cacheEntrySet.iterator();
        if (!it.hasNext()) { // 如果缓存为空，直接返回 null
            return null;
        }
        Map.Entry<K, V> entry = it.next();
        if (entry == null) { // 安全检查
            return null;
        }
        it.remove(); // 移除最老的键值对
        return entry;
    }

    /**
     * 从缓存中移除指定键的键值对。
     *
     * @param key 要移除的键
     * @return 如果成功移除，则返回 true；否则返回 false。
     */
    public synchronized boolean remove(K key) {
        return cache.remove(key) != null;
    }

    /**
     * 获取缓存中键值对的数量。
     *
     * @return 缓存大小
     */
    public synchronized int size() {
        return cache.size();
    }

    /**
     * 检查缓存是否包含指定键。
     *
     * @param key 要检查的键
     * @return 如果缓存包含该键，则返回 true；否则返回 false。
     */
    public synchronized boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}

