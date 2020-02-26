package com.train.rb.bstAVL;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/**
 * @Time: 20-2-25上午11:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TestBST {
    private Random random = new Random();
    private final int MAX1 = 16;

    @Test
    public void testPutAndIt() {
        AVLMap<Integer, String> map = new AVLMap<>();
        for (int i = 0; i < MAX1; i++) {
            map.put(random.nextInt(MAX1), random.nextInt(MAX1) + " ");
        }
        Iterator<AVLEntry<Integer, String>> iterator = map.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().key + " ");
        }
    }

    @Test
    public void testPutAndItrWithJDK() {
        AVLMap<Integer, String> map1 = new AVLMap<>();
        TreeMap<Integer, String> map2 = new TreeMap<>();
        Random random = new Random();
        int MAX2 = 65535;
        for (int i = 0; i < MAX2; i++) {
            int key = random.nextInt(MAX2);
            String value = random.nextInt(MAX2) + "";
            map1.put(key, value);
            map2.put(key, value);
        }
        Assert.assertTrue(map1.size() == map2.size());

        Iterator<AVLEntry<Integer, String>> it1 = map1.iterator();
        Iterator<Map.Entry<Integer, String>> it2 = map2.entrySet().iterator();
        while (it1.hasNext() && it2.hasNext()) {
            Assert.assertTrue(it1.next().getKey().equals(it2.next().getKey()));
        }
        Assert.assertTrue(!it1.hasNext() && !it2.hasNext());
    }

    @Test
    public void testQuery() {
        AVLMap<Integer, String> map = new AVLMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");
        map.put(5, "e");
        map.put(6, "f");
        map.containsValue("f");
        Assert.assertTrue(map.containsKey(1));
        Assert.assertTrue(map.containsValue("f"));
        Assert.assertFalse(map.containsValue("g"));
        Assert.assertTrue(map.get(3).equals("c"));
    }

    @Test
    public void testQueryWithJDK(){
        AVLMap<Integer, String> map1 = new AVLMap<>();
        TreeMap<Integer, String> map2 = new TreeMap<>();
        int max3 = 16;
        for (int i = 0; i < max3; i++) {

        }
    }

    @Test
    public void testRemoveCase1(){
        AVLMap<Integer, String> map = new AVLMap<>();
        int[] arr = {5, 2, 6, 1, 4, 7, 3};
        for (int i : arr) {
            map.put(i, i+"");
        }
        map.remote(1);
        map.levelOrder();
        Iterator<AVLEntry<Integer, String>> it1 = map.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next().getKey());
        }
        System.out.println();
    }

}
