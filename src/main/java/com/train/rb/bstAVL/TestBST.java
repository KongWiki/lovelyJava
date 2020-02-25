package com.train.rb.bstAVL;

import org.junit.Test;

import java.util.Iterator;
import java.util.Random;

/**
 * @Time: 20-2-25上午11:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TestBST {
    private Random random = new Random();
    private final int MAX1 = 16;
    @Test
    public void testPutAndIt(){
        AVLMap<Integer, String> map = new AVLMap<>();
        String wkk = map.put(1, "wkk");
        String kkk = map.put(2, "kkk");
        Iterator<AVLEntry<Integer, String>> iterator = map.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().key + " ");
        }
    }

}
