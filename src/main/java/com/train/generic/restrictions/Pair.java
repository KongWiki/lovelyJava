package com.train.generic.restrictions;

/**
 * @Time: 20-3-5上午11:37
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
