package com.train.rb.bstAVL;

import com.train.pair.Pair;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @Time: 20-2-25上午9:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AVLMap<K, V>  implements Iterable<AVLEntry<K, V>>{
    private int size;
    private AVLEntry<K, V> root;
    private Comparator<K> comp;

    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public AVLMap(Comparator<K> comp) {
        this.comp = comp;
    }

    public AVLMap() {
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        if (root == null) {
            System.out.println("root为空");
            root = new AVLEntry<K, V>(key, value);
            size++;
        }else {
            AVLEntry<K, V> p = root;
            System.out.println("root不为空");
            while (p != null){
                int compareResult = compare(key, p.key);
                if(compareResult == 0){
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if(p.left == null){
                        p.left = new AVLEntry<K, V>(key, value);
                        size ++;
                        break;
                    }else {
                        p = p.left;
                    }
                }else {
                    if(p.right == null){
                        p.right = new AVLEntry<K, V>(key, value);
                        size ++;
                        break;
                    }else {
                        p = p.right;
                    }
                }
            }
        }
        return value;
    }

    @Override
    public Iterator<AVLEntry<K, V>> iterator() {
        return new AVLIterator<K, V>(root);
    }
}
