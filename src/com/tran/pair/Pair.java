package com.tran.pair;

/**
 * @Time: 19-11-7下午8:46
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair(){
        this.first = null;
        this.second = null;
    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
