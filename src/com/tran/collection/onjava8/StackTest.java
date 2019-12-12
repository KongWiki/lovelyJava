package com.tran.collection.onjava8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 19-12-12下午8:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class StackTest {
    public static void main(String[] args) {
        Deque<String> deque = new ArrayDeque<>();
        for (String s: "I am wkk".split(" ")){
            deque.push(s);
        }

//        for (String s : deque) {
//            System.out.print(s + " ");
//        }
        while (!deque.isEmpty()){
            System.out.print(deque.pop() + " ");
        }
    }
}
