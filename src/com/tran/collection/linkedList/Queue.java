package com.tran.collection.linkedList;

/**
 * @Time: 19-11-18上午11:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface Queue<E> {
    // 添加元素
    void add(E elemnt);
    // 移除元素
    E remote();
    // 返回容量大小
    int size();
}
