package com.train.generic.cla;

/**
 * @Time: 20-3-5上午8:42
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MultiInfo<K, V> {
    private K key;
    private V value;

    public MultiInfo(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "MultiInfo{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        MultiInfo<Integer, String> info = new MultiInfo<>(1, "1");
        System.out.println(info);

        MultiInfo<Integer, MultiInfo<Integer, String>> multi = new MultiInfo<>(1, new MultiInfo<>(1,"32"));
        System.out.println(multi);


    }
}
