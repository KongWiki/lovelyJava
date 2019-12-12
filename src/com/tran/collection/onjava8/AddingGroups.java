package com.tran.collection.onjava8;

import java.util.*;

/**
 * @Time: 19-12-12下午7:08
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,34,5,5,6));
        Integer[] moreInts = {6,77,8,8,98};
        collection.addAll(Arrays.asList(moreInts));
        System.out.println("第一次collection 为： " + collection);
        Collections.addAll(collection, 11,22,124);
        Collections.addAll(collection, moreInts);

        List<Integer> list = Arrays.asList(16,17,18,19,20);
        list.set(1, 99);
    }
}
