package com.train.rb.bstAVL;

import com.train.pair.Pair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Time: 20-2-25上午9:11
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AVLMap<K, V> implements Iterable<AVLEntry<K, V>> {
    private int size;
    private AVLEntry<K, V> root;
    private Comparator<K> comp;

    public AVLMap(Comparator<K> comp) {
        this.comp = comp;
    }

    public AVLMap() {
    }

    @SuppressWarnings("unchecked")
    private int compare(K a, K b) {
        if (comp != null) {
            return comp.compare(a, b);
        } else {
            Comparable<K> c = (Comparable<K>) a;
            return c.compareTo(b);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /*
    ===================================================================
    * 增
    * */
    public V put(K key, V value) {
        if (root == null) {
            root = new AVLEntry<K, V>(key, value);
            size++;
        } else {
            AVLEntry<K, V> p = root;
            while (p != null) {
                int compareResult = compare(key, p.key);
                if (compareResult == 0) {
                    p.setValue(value);
                    break;
                } else if (compareResult < 0) {
                    if (p.left == null) {
                        p.left = new AVLEntry<K, V>(key, value);
                        size++;
                        break;
                    } else {
                        p = p.left;
                    }
                } else {
                    if (p.right == null) {
                        p.right = new AVLEntry<K, V>(key, value);
                        size++;
                        break;
                    } else {
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

    /*
    ===================================================================
    * 查
    * */
    // 主要查找逻辑
    private AVLEntry<K, V> getEntry(K key) {
        AVLEntry<K, V> p = root;
        while (p != null) {
            int comp = compare(key, p.key);
            if (comp == 0) {
                return p;
            } else if (comp < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    // 是否含有key
    public boolean containsKey(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p != null;
    }

    // 是否含有value
    public boolean containsValue(V value) {
        Iterator<AVLEntry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    // 根据key获取对应的value
    public V get(K key) {
        AVLEntry<K, V> p = getEntry(key);
        return p != null ? p.getValue() : null;
    }

    /*
    ===================================================================
    * 删
    * */
    // 获取最小节点 也就是中序遍历的第一个节点
    public AVLEntry<K, V> getFirstEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.left != null) {
            p = p.left;
        }
        return p;

    }

    // 获取最大节点 也就是中序遍历的最后的节点
    public AVLEntry<K, V> getLastEntry(AVLEntry<K, V> p) {
        if (p == null) {
            return null;
        }
        while (p.right != null) {
            p = p.right;
        }
        return p;
    }
    // 主逻辑
    private AVLEntry<K, V> deleteEntry(AVLEntry<K, V> p, K key) {
        if (p == null) {
            return null;
        }
        else {
            int comp = compare(p.key, key);
            // 查找成功
            if (comp == 0) {
                // 三种情况讨论
                //1 p为叶子节点
                if (p.right == null && p.left == null) {
                    p = null;
                }
                //2 p仅有左子树（右子树）
                else if (p.left != null && p.right == null) {
                    p = p.left;
                } else if (p.left == null && p.right != null) {
                    p = p.right;
                }
                //3 p既有左子树又有右子树
                else if (p.left != null && p.right != null) {
                    // 只要为用于随机使用rightMax || leftMin
                    if((size & 1) == 0) {
                        // 1. 先寻找右子树的firstEntry
                        AVLEntry<K, V> rightMin = getFirstEntry(p.right);
                        // 2. 修改p的值
                        p.value = rightMin.value;
                        p.key = rightMin.key;
                        // 3. 递归删除rightMin(先找节点再删除)
                        AVLEntry<K, V> newRight = deleteEntry(p.right, p.key);
                        p.right = newRight;
                    }else {
                        // 1. 先寻找右子树的firstEntry
                        AVLEntry<K, V> leftMax = getLastEntry(p.left);
                        // 2. 修改p的值
                        p.value = leftMax.value;
                        p.key = leftMax.key;
                        // 3. 递归删除rightMin(先找节点再删除)
                        AVLEntry<K, V> newLeft = deleteEntry(p.left, p.key);
                        p.left = newLeft;
                    }
                }

            }
            // 不相等 和查找算法相似
            else if(comp < 0){
                AVLEntry<K, V> newRight = deleteEntry(p.right, key);
                p.right = newRight;
            }else {
                AVLEntry<K, V> newLeft = deleteEntry(p.left, key);
                p.left = newLeft;
            }
        }
        return p;


    }

    public V remote(K key) {
        AVLEntry<K, V> entry = getEntry(key);
        if(entry == null){
            return null;
        }
        V oldValue = entry.getValue();
        root = deleteEntry(root, key);
        size --;
        return oldValue;
    }

    // 层次遍历
    // 可使用队列遍历
    // 也可使用递归
    public void levelOrder() {
        Queue<AVLEntry<K, V>> queue = new LinkedList<>();
        int preCount = 1;
        int pCount = 0;
        queue.offer(root);
        while (!queue.isEmpty()){
            preCount --;
            AVLEntry<K, V> p = queue.poll();
            System.out.print(p + "  ");
            if(p.left != null){
                queue.offer(p.left);
                pCount++;
            }
            if(p.right != null){
                queue.offer(p.right);
                pCount++;
            }
            if(preCount==0){
                preCount = pCount;
                pCount = 0;
                System.out.println();
            }
        }


    }


}
