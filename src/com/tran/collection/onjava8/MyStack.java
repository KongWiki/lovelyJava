package com.tran.collection.onjava8;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 19-12-12下午8:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MyStack<T> {
    private Deque<T> storage = new ArrayDeque<>();
    private void push(T v){
        storage.push(v);
    }

    private T peek(){return storage.peek();}
    private T pop() { return storage.pop();}
    private boolean isEmpty(){
        return storage.isEmpty();
    }


    @Override
    public String toString() {
        return storage.toString();
    }


    public static void main(String[] args) {
        MyStack<String> s = new MyStack<>();
        for(String a : " i am wkk".split(" ")){
            s.push(a);
        }
        System.out.println(s.peek());
    }
}
